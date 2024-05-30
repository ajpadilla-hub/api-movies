package com.mydom.rest_api_movies.service;

import com.mydom.rest_api_movies.model.dto.Movie;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovieSpecification {
    private MovieSpecification() {
    }

    public static Specification<Movie> withDynamicQuery(String title, LocalDate releaseDate, Integer runtime) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (title != null && !title.isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%"));
            }
            if (releaseDate != null) {
                predicates.add(cb.equal(root.get("releaseDate"), releaseDate));
            }
            if (runtime != null) {
                predicates.add(cb.equal(root.get("runtime"), runtime));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
