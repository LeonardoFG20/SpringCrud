package com.crud.livro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.livro.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
