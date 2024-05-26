package com.mydom.rest_api_movies.models.dto;

import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class MovieGenreData {

private UUID movieId;
private UUID genreId;

    public MovieGenreData() {
    }

    public MovieGenreData(UUID movieId, UUID genreId) {
        this.movieId = movieId;
        this.genreId = genreId;
    }

    public UUID getMovieId() {
        return movieId;
    }

    public UUID getGenreId() {
        return genreId;
    }
}
