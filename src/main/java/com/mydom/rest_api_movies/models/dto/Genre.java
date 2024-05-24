package com.mydom.rest_api_movies.models.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonProperty("genre_id")
    private UUID id;
    private String name;

    @ManyToMany(mappedBy = "genres") // Mapped by refers to the collection in Movie
    private Set<Movie> movies;
}
