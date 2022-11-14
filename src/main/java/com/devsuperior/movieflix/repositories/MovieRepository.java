package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT new com.devsuperior.movieflix.dto.MovieDTO(obj.id, obj.title, obj.subTitle, obj.year, obj.imgUrl, obj.synopsis, obj.genre) " +
            "FROM Movie obj " +
            "WHERE (:genre = null OR obj.genre = :genre) " +
            "GROUP BY obj.title")
    Page<MovieDTO> findAllByGenre(Genre genre, Pageable pageable);
}
