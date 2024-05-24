package com.mydom.rest_api_movies.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    @GetMapping
    public ResponseEntity findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        return ResponseEntity.ok("all");
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable String id) {
        return ResponseEntity.ok(id);
    }

    @GetMapping("/search")
    public ResponseEntity searchMoviesByTitle(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "genre", required = false) String genre,
            @RequestParam(value = "genre", required = false) String year,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        return null;
    }

    /*
    @PostMapping
    public ResponseEntity createMovie(@RequestBody Movie movie) {
        return null;
    }
    */

    /*
    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        return null;
    }
    */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable String id) {
        return ResponseEntity.ok(id);
    }
}
