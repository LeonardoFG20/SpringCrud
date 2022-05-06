package com.crud.livro.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.livro.model.Livro;
import com.crud.livro.repository.LivroRepository;

@RestController
@RequestMapping("/")
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@GetMapping
	public List<Livro> listar() {
		List<Livro> livros = livroRepository.findAll();
		return livros;
    }
	
	@Transactional
	@PostMapping
	public void salvar(@RequestBody Livro livro) {
		livroRepository.save(livro);

	}
	
	@Transactional
	@PutMapping
	public void atualizar(@RequestBody Livro livro) {
		livroRepository.save(livro);
	}
	
    @Transactional
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){

	    livroRepository.deleteById(id);

    }
}
