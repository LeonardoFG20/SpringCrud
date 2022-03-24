package com.crud.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.crud.model.Livro;
import com.crud.repository.LivroRepository;

@Service
public class LivroServiceImpl implements LivroService {
	
	@Autowired
    private LivroRepository livroRepository;

	@Override
	public List<Livro> getAllLivros() {
		return livroRepository.findAll();
	}

	@Override
	public void saveLivro(Livro livro) {
		this.livroRepository.save(livro);
		
	}

	@Override
	public Livro getLivroById(long id) {
		Optional<Livro> optionalLivro = livroRepository.findById(id);
        Livro livro = null;
        if (optionalLivro.isPresent()) {
            livro = optionalLivro.get();
        } else {
            throw new RuntimeException("O livro não foi achado pelo id : " + id);
        }
        return livro;
	}

	@Override
	public void deleteLivroById(long id) {
		this.livroRepository.deleteById(id);
		
	}

	@Override
	public Page<Livro> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
        Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        return this.livroRepository.findAll(pageable);
	}

}
