package com.mydom.rest_api_movies.service;

import com.mydom.rest_api_movies.exception.NotFoundException;
import com.mydom.rest_api_movies.model.dto.Movie;
import com.mydom.rest_api_movies.model.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieService {

    private final MovieRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(MovieService.class);

    @Autowired
    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public Page<Movie> findAllMoviesByPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<Movie> findById(UUID id) {
                return repository.findById(id);
    }

    public void save(Movie movie) {
        repository.save(movie);
    }

    public void saveAll(Iterable<Movie> movies) {
        repository.saveAll(movies);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public Page<Movie> search(String title, LocalDate releaseDate, Integer runtime, int page, int size, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return repository.findAll(MovieSpecification.withDynamicQuery(title, releaseDate, runtime), pageable);
    }

    public Movie create(Movie movie) {
        return repository.save(movie);
    }

    public Movie update(UUID id, Movie movie) throws NotFoundException {
        // Check if movie with the id exists
        Optional<Movie> existingMovie = repository.findById(id);

        // Handle movie not found case
        if (!existingMovie.isPresent()) {
            throw new RuntimeException("Movie not found with id: " + id);
        }

        // Update existing movie object with new data (assuming setters are defined)
        Movie movieToUpdate = existingMovie.get();
        movieToUpdate.setId(movie.getId());
        movieToUpdate.setTitle(movie.getTitle());  // Update specific fields as needed
        movieToUpdate.setOverview(movie.getOverview());
        movieToUpdate.setReleaseDate(movie.getReleaseDate());
        movieToUpdate.setRuntime(movie.getRuntime());
        movieToUpdate.setGenres(movie.getGenres());

        /* Save the updated movie object (CrudRepository.save performs update) */

        return repository.save(movieToUpdate);
    }
}