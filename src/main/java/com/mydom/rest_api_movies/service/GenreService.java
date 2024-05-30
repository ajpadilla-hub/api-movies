package com.mydom.rest_api_movies.service;

import com.mydom.rest_api_movies.model.dto.Genre;
import com.mydom.rest_api_movies.model.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    private final GenreRepository repository;

    public GenreService(GenreRepository repository) {
        this.repository = repository;
    }

    public void save(Genre genre){
        repository.save(genre);
    }

    public void saveAll(List<Genre> genres) {
        repository.saveAll(genres);
    }
}
