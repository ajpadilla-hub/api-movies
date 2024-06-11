package com.mydom.rest_api_movies.controller;

import com.mydom.rest_api_movies.model.dto.Genre;
import com.mydom.rest_api_movies.model.dto.Movie;
import com.mydom.rest_api_movies.service.MovieService;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

@WebMvcTest(MovieController.class)
@AutoConfigureMockMvc
class MovieControllerTest {

    @MockBean
    MovieService movieService;

    @Autowired
    MockMvc mockMvc;
    private static final Logger logger = LoggerFactory.getLogger(MovieControllerTest.class);

    @Test
    void findById() throws Exception {
        UUID uuid = UUID.randomUUID();
        var movie = new Movie(
                uuid,
                "Movie Title",
                "Movie Description",
                LocalDate.of(2002, 2, 2),
                333,
                new HashSet<>(List.of(new Genre(UUID.randomUUID(), "Action")))
        );

        logger.info("UUID: {}", uuid);
        logger.info("Movie: {}", movie);
        when(movieService.findById(uuid)).thenReturn(Optional.of(movie));

        logger.info(String.valueOf(movieService.findById(uuid)));
        mockMvc.perform(get("/movies/{id}", uuid.toString()))
                .andExpect(status().isOk());
    }
}