package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;
    @Autowired
    private MovieService movieService;

    @Autowired
    private UserService userService;

    @Transactional
    @PreAuthorize("hasAnyRole('MEMBER')")
    public ReviewDTO insert(ReviewDTO dto) {

        Movie movie = movieService.findById(dto.getMovieId());
        Review obj = new Review();
        obj.setText(dto.getText());
        obj.setMovie(movie);
        obj.setUser(userService.authenticated());
        obj = repository.save(obj);

        return new ReviewDTO(obj);
    }
}
