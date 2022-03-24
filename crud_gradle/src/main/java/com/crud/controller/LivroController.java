package com.crud.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.crud.model.Livro;
import com.crud.service.LivroService;

@Controller
public class LivroController {
	
	@Autowired
    private LivroService livroService;
  
    @GetMapping("/")
    public String viewHomePage(Model model) {
        return findPaginated(1, "nome", "asc", model);
    }
  
    @GetMapping("/add")
    public String showNewLivroForm(Model model) {
        Livro Livro = new Livro();
        model.addAttribute("livro", Livro);
        return "addlivro";
    }
  
    @PostMapping("/save")
    public String saveLivro(@ModelAttribute("livro") Livro livro) {
        livroService.saveLivro(livro);
        return "redirect:/";
    }
  
    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {
  
        Livro livro = livroService.getLivroById(id);
        model.addAttribute("livro", livro);
        return "updatelivro";
    }
  
    @GetMapping("/delete/{id}")
    public String deleteLivro(@PathVariable (value = "id") long id) {
  
        this.livroService.deleteLivroById(id);
        return "redirect:/";
    }
  
  
    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;
  
        Page<Livro> page = livroService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Livro> listLivros = page.getContent();
  
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
  
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
  
        model.addAttribute("listLivros", listLivros);
        return "index";
    }

}
