package com.mydom.rest_api_movies.service;

import com.mydom.rest_api_movies.model.dto.MovieGenreData;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieGenreService {

    private final JdbcTemplate jdbcTemplate;

    public MovieGenreService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertMovieGenreRelationships(List<MovieGenreData> data) {
        String sql = "INSERT INTO movie_genre (movie_id, genre_id) VALUES (?, ?)";
        for (MovieGenreData entry : data) {
            jdbcTemplate.update(sql, entry.getMovieId(), entry.getGenreId());
        }
    }

}
