package com.mydom.rest_api_movies.controller;

import com.mydom.rest_api_movies.model.dto.Movie;
import com.mydom.rest_api_movies.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.UUID;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private static final Logger logger;

    static {
        logger = LoggerFactory.getLogger(MovieController.class);
    }

    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<Movie>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(required = false) String sortField,
            @RequestParam(defaultValue = "ASC") String sortDirection
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.valueOf(sortDirection.toUpperCase()), sortField != null ? sortField : "title");
        Page<Movie> movies = movieService.findAllMoviesByPage(pageable);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findById(@PathVariable String id) {
        logger.info("movie returned by id");
        return movieService.findById(UUID.fromString(id))
                .map(ResponseEntity::ok)
//                .map(movie -> ResponseEntity.ok(movie))
                .orElse(ResponseEntity.notFound().build());
    }

    //    http://localhost:8080/api/v0/movies/search?title=Forrest%20Gump&releaseDate=1994-07-06&runtime=142 sample query
    @GetMapping("/search")
    public ResponseEntity<Page<Movie>> searchMoviesByTitle(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "releaseDate", required = false) String releaseDateStr,
            @RequestParam(value = "runtime", required = false) Integer runtime,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir
    ) {
        LocalDate releaseDate = null;
        if (releaseDateStr != null && !releaseDateStr.isEmpty()) {
            try {
                releaseDate = LocalDate.parse(releaseDateStr, DateTimeFormatter.ISO_DATE);
            } catch (DateTimeParseException e) {
                return ResponseEntity.badRequest().body(null);
            }
        }
        Page<Movie> result = movieService.search(title, releaseDate, runtime, page, size, sortBy, sortDir);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> createMovie(@RequestBody Movie movie) {
        // Basic validation (optional, but recommended for strong input control)
        if (movie.getTitle() == null || movie.getTitle().isEmpty()) {
            return ResponseEntity.badRequest().body("Movie title is required");
        }

        // Call service or perform further processing (if applicable)
        Movie savedMovie;
        try {
            savedMovie = movieService.create(movie); // Example using MovieService
        } catch (Exception e) {
            // Handle potential exceptions during movie creation (e.g., database errors)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating movie");
        }

        // Handle successful creation
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody Movie movie) {

        // Optional: Basic validation for ID and incoming data
        if (id == null || movie == null) {
            return ResponseEntity.badRequest().build();  // Return empty ResponseEntity
        }

        // Call service or perform update logic (if applicable)
        Movie updatedMovie;
        try {
            updatedMovie = movieService.update(id, movie); // Example using MovieService
        } catch (Exception e) {
            // Handle potential exceptions during movie update (e.g., database errors)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating movie");
        }

        // Handle successful update (check if movie was found)
        if (updatedMovie == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedMovie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        movieService.deleteById(UUID.fromString(id));
        return ResponseEntity.ok(id);
    }
}