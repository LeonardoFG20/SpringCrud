package com.crud.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.crud.beans.Livro;
import com.crud.dao.LivroDao;

@Controller
public class LivroController {
	@Autowired  
    LivroDao dao;
      
    @RequestMapping("/addlivro")  
    public String showform(Model m){  
    	m.addAttribute("command", new Livro());
    	return "addlivro"; 
    }  

    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("livro") Livro livro){  
        dao.save(livro);  
        return "redirect:/listlivro";
    }  

    @RequestMapping("/listlivro")  
    public String listlivro(Model m){  
        List<Livro> list=dao.getLivros();  
        m.addAttribute("list",list);
        return "listlivro";  
    }  
  
    @RequestMapping(value="/edit/{id}")  
    public String edit(@PathVariable int id, Model m){  
        Livro livro=dao.getLivroById(id);  
        m.addAttribute("command",livro);
        return "editlivro";  
    }  

    @RequestMapping(value="/update",method = RequestMethod.POST)  
    public String update(@ModelAttribute("livro") Livro livro){  
        dao.update(livro);  
        return "redirect:/listlivro";  
    }  
 
    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.delete(id);  
        return "redirect:/listlivro";  
    }  

}
