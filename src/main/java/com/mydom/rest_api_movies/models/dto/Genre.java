package com.mydom.rest_api_movies.models.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@Entity
@Table(name = "genres")
@NoArgsConstructor
public class Genre {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("genre_id")
    private UUID id;
    private String name;

    public Genre(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
    @PrePersist
    public void prePersist() {
        if (this.id == null) {
            this.id = UUID.randomUUID();
        }
    }

    @ManyToMany(mappedBy = "genres") // Mapped by refers to the collection in Movie
    private Set<Movie> movies = new HashSet<>();
}
