package com.minhaescola.escola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minhaescola.escola.model.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
	public List<Turma> findAllByDescricaoContainingIgnoreCase (String descricao);
	
}
