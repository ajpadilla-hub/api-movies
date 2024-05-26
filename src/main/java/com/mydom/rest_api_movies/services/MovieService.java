package com.mydom.rest_api_movies.services;

import com.mydom.rest_api_movies.models.dto.Movie;
import com.mydom.rest_api_movies.models.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;
    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(MovieService.class);

    public MovieService() {
    }

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public Page<Movie> findAllMoviesByPage(Pageable pageable) {
        return null;
    }

    public Optional<Movie> findById(UUID id){
        return repository.findById(id);
    }

    public void save(Movie movie) {
        repository.save(movie);
    }

    public void saveAll(Iterable<Movie> movies) {
        for (Movie item : movies){
            logger.info(String.valueOf(item.getId()));
        }

        repository.saveAll(movies);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}