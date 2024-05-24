package com.mydom.rest_api_movies.models.repository;

import com.mydom.rest_api_movies.models.dto.Movie;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MovieRepository extends PagingAndSortingRepository<Movie, UUID> {

}
