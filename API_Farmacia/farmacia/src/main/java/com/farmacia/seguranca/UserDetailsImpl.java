package com.farmacia.seguranca;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.farmacia.farmacia.model.Usuario;

public class UserDetailsImpl implements UserDetails {

private static final long serialVersionUID = 1L; /*Classe para controle interno*/
	
	/*Atributos privados*/
	private String userName;
	private String password;
	
	/*Construtor de classe, que recebe como parâmetro o user, populando com login e a senha, da Model Usuário*/
	public UserDetailsImpl(Usuario user ) {
		this.userName = user.getUsuario();
		this.password = user.getSenha();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
