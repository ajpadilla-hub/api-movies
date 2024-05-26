package com.mydom.rest_api_movies.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("movie_id")
    private UUID id;
    private String title;
    private String overview;
    private LocalDate releaseDate;
    private Integer runtime;

    public Movie(UUID id, String title, String overview, LocalDate releaseDate, Integer runtime) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.runtime = runtime;
    }

    @PrePersist
    public void prePersist() {
        if (this.id == null) {
            this.id = UUID.randomUUID();
        }
    }

    @ManyToMany(fetch = FetchType.LAZY) // Many-to-Many relationship with Genre
    @JoinTable(name = "movie_genre", // Join table for the relationship
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres = new HashSet<>();
}
