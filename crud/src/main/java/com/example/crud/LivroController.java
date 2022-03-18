package com.example.crud;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

public class LivroController {
	LivroDao dao;
	
	
	public String mostrarform(Model m) {
		m.addAttribute("comando", new Livro());
		return "form";
	}
	
	public String salvar(@ModelAttribute("livro")Livro livro) {
		dao.salva(livro);
		return "redirecionar:/verlivro";
	}

}