package com.mydom.rest_api_movies.services;

import com.mydom.rest_api_movies.models.dto.MovieGenreData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieGenreService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertMovieGenreRelationships(List<MovieGenreData> data) {
        String sql = "INSERT INTO movie_genre (movie_id, genre_id) VALUES (?, ?)";
        for (MovieGenreData entry : data) {
            jdbcTemplate.update(sql, entry.getMovieId(), entry.getGenreId());
        }
    }

}
