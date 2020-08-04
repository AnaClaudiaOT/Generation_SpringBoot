package com.minharedesocial.minhaRedeSocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minharedesocial.minhaRedeSocial.model.TemaModel;

@Repository
public interface TemaRepository extends JpaRepository<TemaModel, Long> {

}
