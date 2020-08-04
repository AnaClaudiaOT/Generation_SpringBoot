package com.minharedesocial.minhaRedeSocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minharedesocial.minhaRedeSocial.model.PostagemModel;

@Repository
public interface PostagemRepository extends JpaRepository<PostagemModel, Long> {

}
