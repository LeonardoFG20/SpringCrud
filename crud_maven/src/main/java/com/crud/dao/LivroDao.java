package com.crud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.crud.beans.Livro;

public class LivroDao {
	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}  
	public int save(Livro livro){  
	    String sql="insert into Livro(nome) values('"+livro.getNome()+"')";  
	    return template.update(sql);  
	}  
	public int update(Livro livro){  
	    String sql="update Livro set nome='"+livro.getNome()+"' where id="+livro.getId()+"";  
	    return template.update(sql);  
	}  
	public int delete(int id){  
	    String sql="delete from Livro where id="+id+"";  
	    return template.update(sql);  
	}
	@SuppressWarnings("deprecation")
	public Livro getLivroById(int id){  
	    String sql="select * from Livro where id=?";  
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Livro>(Livro.class));  
	}  
	public List<Livro> getLivros(){  
	    return template.query("select * from Livros",new RowMapper<Livro>(){  
	        public Livro mapRow(ResultSet rs, int row) throws SQLException {  
	            Livro livro=new Livro();  
	            livro.setId(rs.getInt(1));  
	            livro.setNome(rs.getString(2)); 
	            return livro;  
	        }  
	    });  
	} 
}
