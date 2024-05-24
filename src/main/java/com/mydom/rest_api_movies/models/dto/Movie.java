package com.mydom.rest_api_movies.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonProperty("movie_id")
    private UUID id;
    private String title;
    private String overview;
    private LocalDate releaseDate;
    private Integer runtime;

    @ManyToMany(fetch = FetchType.LAZY) // Many-to-Many relationship with Genre
    @JoinTable(name = "movie_genre", // Join table for the relationship
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres;
}