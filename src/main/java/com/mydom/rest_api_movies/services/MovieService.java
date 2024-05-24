package com.mydom.rest_api_movies.services;

import com.mydom.rest_api_movies.models.dto.Movie;
import com.mydom.rest_api_movies.models.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public Page<Movie> findAllMoviesByPage(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
