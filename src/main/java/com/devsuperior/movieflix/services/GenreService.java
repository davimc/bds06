package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GenreService {

    @Autowired
    private GenreRepository repository;

    @Transactional(readOnly = true)
    public List<GenreDTO> findAll() {
        List<Genre> result = repository.findAll();
        return result.stream().map(GenreDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Genre findById(Long id) {
        Optional<Genre> result = repository.findById(id);
        return result.orElseThrow(() -> {
            throw new ObjectNotFoundException(id, Genre.class);
        });
    }
    @Transactional(readOnly = true)
    public GenreDTO findByIdDTO(Long id){
        return new GenreDTO(findById(id));
    }
}
