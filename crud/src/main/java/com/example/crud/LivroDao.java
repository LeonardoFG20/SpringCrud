package com.example.crud;

import org.springframework.jdbc.core.JdbcTemplate;

public class LivroDao {
JdbcTemplate template;

   public void setTemplate(JdbcTemplate template) {    
        this.template = template;    
    }   
	
	public int salva(Livro livro){    
	    String sql="insert into Livros(nome) values('"+livro.getNome()+"')";
	    return template.update(sql);
	}
	
	public int altera(Livro livro){    
	    String sql="update Livros set nome='"+livro.getNome()+ "'where id=" + livro.getId()+"";
	    return template.update(sql);
	}
	
	public int deleta(int id){    
	    String sql="delete from Livros where id="+id+"";
	    return template.update(sql);
	}
}  