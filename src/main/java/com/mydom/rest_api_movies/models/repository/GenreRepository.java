package com.mydom.rest_api_movies.models.repository;

import com.mydom.rest_api_movies.models.dto.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GenreRepository extends CrudRepository<Genre, UUID> {
}
