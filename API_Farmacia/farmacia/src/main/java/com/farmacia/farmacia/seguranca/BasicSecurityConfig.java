package com.farmacia.farmacia.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService; 
	
	@Override // sobrescreve o metodo, não guarda informação
	protected void configure(AuthenticationManagerBuilder auth) throws Exception { /*throws Exception: Tratativa de erros*/
		auth.userDetailsService(userDetailsService); 
	}
	
	@Bean // transforma a senha em uma chave de acesso
	public PasswordEncoder passwordEncoder() { // publico por que o usuario vai adicionar dados
		return new BCryptPasswordEncoder();    // retorna os dados criptografados
	}
	
	@Override /*Sobreescrita de método*/
	protected void configure(HttpSecurity http) throws Exception{ /*throws Exception: Tratativa de erros*/
		http.authorizeRequests()
		.antMatchers("/usuarios/logar").permitAll()
		.antMatchers("/usuarios/cadastrar").permitAll()
		.anyRequest().authenticated()
		.and().httpBasic()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) /*STATELESS: Não Guarda sessão*/
		.and().cors()
		.and().csrf().disable();
	}
}
