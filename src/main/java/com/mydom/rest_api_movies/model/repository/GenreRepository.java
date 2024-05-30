package com.mydom.rest_api_movies.model.repository;

import com.mydom.rest_api_movies.model.dto.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GenreRepository extends CrudRepository<Genre, UUID> {
}
