package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;

import java.io.Serializable;

public class ReviewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String text;
    private Long movieId;

    public ReviewDTO() {
    }

    public ReviewDTO(Long id, String text, Long movieId) {
        this.id = id;
        this.text = text;
        this.movieId = movieId;
    }
    public ReviewDTO(Review obj) {
        this.id = obj.getId();
        this.text = obj.getText();
        this.movieId = obj.getMovie().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}
