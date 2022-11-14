package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Movie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieReviewDTO extends MovieDTO implements Serializable  {
    private static final long serialVersionUID = 1L;


    private List<ReviewDTO> reviews = new ArrayList<>();

    public MovieReviewDTO(Long id, String title, String subTitle, Integer year, String imgUrl, List<ReviewDTO> reviews) {
        super(id, title, subTitle, year, imgUrl);
        this.reviews = reviews;
    }

    public MovieReviewDTO(Movie movie) {
        super(movie);
        this.reviews = movie.getReviews().stream().map(ReviewDTO::new).collect(Collectors.toList());;
    }

    public List<ReviewDTO> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewDTO> reviews) {
        this.reviews = reviews;
    }
}
