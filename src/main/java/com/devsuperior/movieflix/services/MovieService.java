package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MovieReviewDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;
    @Autowired
    private GenreService genreService;


    public Page<MovieDTO> findAllPaged(Long genreId, Pageable pageable) {
        Genre genre = genreId != 0L? genreService.findById(genreId) : null;
        Page<MovieDTO> result = repository.findAllByGenre(genre, pageable);
        return result;
    }

    private Movie findById(Long id) {
        Optional<Movie> obj = repository.findById(id);
        return obj.orElseThrow(() -> {
            throw new ObjectNotFoundException(id, Movie.class);
        });
    }
    public MovieDTO findByIdDTO(Long id) {
        return new MovieDTO(findById(id));
    }
    public MovieReviewDTO findMovieWithReview(Long id) {
        Movie obj = findById(id);
        return new MovieReviewDTO(obj);
    }
}
