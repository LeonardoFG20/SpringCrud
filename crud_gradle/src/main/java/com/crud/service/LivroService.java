package com.crud.service;

import java.util.List;
import org.springframework.data.domain.Page;
import com.crud.model.Livro;

public interface LivroService {
	List<Livro> getAllLivros();
    void saveLivro(Livro livro);
    Livro getLivroById(long id);
    void deleteLivroById(long id);
    Page<Livro> findPaginated(int pageNum, int pageSize,
                               String sortField,
                               String sortDirection);
}
