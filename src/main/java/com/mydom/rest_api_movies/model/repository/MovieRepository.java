package com.mydom.rest_api_movies.model.repository;

import com.mydom.rest_api_movies.model.dto.Movie;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MovieRepository extends CrudRepository<Movie, UUID>, JpaSpecificationExecutor<Movie>, PagingAndSortingRepository<Movie,UUID> {

}
