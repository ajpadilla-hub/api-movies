package com.mydom.rest_api_movies.services;

import com.mydom.rest_api_movies.models.dto.Genre;
import com.mydom.rest_api_movies.models.dto.Movie;
import com.mydom.rest_api_movies.models.repository.GenreRepository;
import com.mydom.rest_api_movies.models.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepository repository;

    public void save(Genre genre){
        repository.save(genre);
    }

    public void saveAll(List<Genre> genres) {
        repository.saveAll(genres);
    }
}
