package com.mydom.rest_api_movies.services;

import com.mydom.rest_api_movies.controllers.MovieController;
import com.mydom.rest_api_movies.models.dto.Genre;
import com.mydom.rest_api_movies.models.dto.Movie;
import com.mydom.rest_api_movies.models.dto.MovieGenreData;
import org.apache.el.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class SampleDataQuery implements CommandLineRunner {

    @Autowired
    MovieService movieService = new MovieService();
    @Autowired
    GenreService genreService = new GenreService();
    @Autowired
    MovieGenreService movieGenreService = new MovieGenreService();
    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(SampleDataQuery.class);

    @Override
    public void run(String... args) throws Exception {

        logger.info("sample data class");
        logger.info("sample dat  " + UUID.fromString("570a68f5-46ca-45ea-970e-b75317d0adaa"));
        List<Movie> movies =
                Arrays.asList(

                        new Movie(
                                UUID.fromString("570a68f5-46ca-45ea-970e-b75317d0adaa"),
                                "Titanic",
                                "A fictionalized account of the sinking of the RMS Titanic, starring Leonardo DiCaprio and Kate Winslet.",
                                LocalDate.of(1997, 12, 19),
                                195
                        ),
                        new Movie(
                                UUID.fromString("142217d5-eb0d-4a1e-a125-bfb3eda4bd54"),
                                "The Godfather",
                                "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
                                LocalDate.of(1972, 03, 24),
                                175
                        ),
                        new Movie(
                                UUID.fromString("8cc5fd8c-eb04-49a2-a892-247d7f7082fd"),
                                "The Shawshank Redemption",
                                "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
                                LocalDate.of(1994, 10, 14),
                                142
                        ),
                        new Movie(
                                UUID.fromString("c4a421d2-445c-41c3-a442-405a4ff10ade"),
                                "Inception",
                                "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.A thief who steals corporate secrets.",
                                LocalDate.of(2010, 7, 16),
                                148
                        ),
                        new Movie(
                                UUID.fromString("825e63b1-ef66-415f-9c6c-2d9f2fc99fc3"),
                                "The Dark Knight",
                                "When the menace known as The Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.",
                                LocalDate.of(2008, 7, 18),
                                152
                        ),
                        new Movie(
                                UUID.fromString("a21c1f7b-2437-4a4e-8abf-c527bcdc34a7"),
                                "Schindler\"\"s List",
                                "In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.",
                                LocalDate.of(1994, 12, 15),
                                195
                        ),
                        new Movie(
                                UUID.fromString("57282b58-bec8-4dda-8edb-cac5d64f9178"),
                                "The Lord of the Rings: The Return of the King",
                                "Gandalf and Aragorn lead the World of Men against Sauron\"\"s army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.",
                                LocalDate.of(2003, 12, 17),
                                201
                        ),
                        new Movie(
                                UUID.fromString("3743c258-86f9-4293-9e31-bc08044804c6"),
                                "Pulp Fiction",
                                "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
                                LocalDate.of(1994, 10, 12),
                                154
                        ),
                        new Movie(
                                UUID.fromString("08f7603b-ab99-4aff-8d07-2f1b94d66866"),
                                "Fight Club",
                                "An insomniac office worker and a devil-may-care soapmaker form an underground fight club that evolves into something much, much more.",
                                LocalDate.of(1999, 10, 15),
                                139
                        ),
                        new Movie(
                                UUID.fromString("d565b800-f6e8-4c5c-afd2-f71ab257946c"),
                                "Forrest Gump",
                                "The presidencies of Kennedy and Johnson, the Vietnam War, the Watergate scandal and other historical events unfold from the perspective of an Alabama man with an IQ of 75, whose only desire is to be reunited with his childhood sweetheart.",
                                LocalDate.of(1994, 7, 6),
                                142
                        )

                );

        movieService.saveAll(movies);

        List<Genre> genres =
                Arrays.asList(

                        new Genre(
                                UUID.fromString("9a7b070d-fe97-4446-96b7-a6ae485192a5"),
                                "Action"
                        ),
                        new Genre(
                                UUID.fromString("9d676cfb-dd6c-4e28-8c5a-b89574ac6a5a"),
                                "Adventure"
                        ),
                        new Genre(
                                UUID.fromString("5552de5e-51f5-4a23-a6d1-52fe35a07555"),
                                "Comedy"
                        ),
                        new Genre(
                                UUID.fromString("44be136c-574a-4199-8392-e45fe67aa7ae"),
                                "Drama"
                        ),
                        new Genre(
                                UUID.fromString("1a98678d-3bd7-45c9-a8cd-3d5d266e18b7"),
                                "Fantasy"
                        ),
                        new Genre(
                                UUID.fromString("5aaaaa6c-574a-4199-8392-e45fe67aaaaa"),
                                "Horror"
                        ),
                        new Genre(
                                UUID.fromString("22c354f2-0104-47c0-941e-fd6db8591244"),
                                "Romance"
                        ),
                        new Genre(
                                UUID.fromString("6f8e34ca-a0f6-4a97-a337-124bd9f3f0e8"),
                                "Science Fiction"
                        ),
                        new Genre(
                                UUID.fromString("656ff2a9-634f-489d-a32d-f03691d7826b"),
                                "Thriller"
                        ),
                        new Genre(
                                UUID.fromString("1161f2a9-634f-489d-a32d-f01691d78261"),
                                "Crime"
                        ), new Genre(
                                UUID.fromString("8861f288-834f-488d-a82d-f08691d78261"),
                                "Western"
                        ), new Genre(
                                UUID.fromString("1cd62784-35a1-4d24-b8be-0211cfb0f13a"),
                                "History"
                        )

                );

        genreService.saveAll(genres);

        List<MovieGenreData> movieGenreData =
                Arrays.asList(
                        new MovieGenreData(UUID.fromString("570a68f5-46ca-45ea-970e-b75317d0adaa"), UUID.fromString("9a7b070d-fe97-4446-96b7-a6ae485192a5")),
                        new MovieGenreData(UUID.fromString("570a68f5-46ca-45ea-970e-b75317d0adaa"), UUID.fromString("22c354f2-0104-47c0-941e-fd6db8591244")),

                        new MovieGenreData(UUID.fromString("142217d5-eb0d-4a1e-a125-bfb3eda4bd54"), UUID.fromString("44be136c-574a-4199-8392-e45fe67aa7ae")),
                        new MovieGenreData(UUID.fromString("142217d5-eb0d-4a1e-a125-bfb3eda4bd54"), UUID.fromString("1161f2a9-634f-489d-a32d-f01691d78261")),

                        new MovieGenreData(UUID.fromString("8cc5fd8c-eb04-49a2-a892-247d7f7082fd"), UUID.fromString("44be136c-574a-4199-8392-e45fe67aa7ae")),
                        new MovieGenreData(UUID.fromString("8cc5fd8c-eb04-49a2-a892-247d7f7082fd"), UUID.fromString("656ff2a9-634f-489d-a32d-f03691d7826b")),

                        new MovieGenreData(UUID.fromString("c4a421d2-445c-41c3-a442-405a4ff10ade"), UUID.fromString("6f8e34ca-a0f6-4a97-a337-124bd9f3f0e8")),
                        new MovieGenreData(UUID.fromString("c4a421d2-445c-41c3-a442-405a4ff10ade"), UUID.fromString("656ff2a9-634f-489d-a32d-f03691d7826b")),

                        new MovieGenreData(UUID.fromString("825e63b1-ef66-415f-9c6c-2d9f2fc99fc3"), UUID.fromString("9a7b070d-fe97-4446-96b7-a6ae485192a5")),
                        new MovieGenreData(UUID.fromString("825e63b1-ef66-415f-9c6c-2d9f2fc99fc3"), UUID.fromString("1161f2a9-634f-489d-a32d-f01691d78261")),

                        new MovieGenreData(UUID.fromString("a21c1f7b-2437-4a4e-8abf-c527bcdc34a7"), UUID.fromString("44be136c-574a-4199-8392-e45fe67aa7ae")),

                        new MovieGenreData(UUID.fromString("57282b58-bec8-4dda-8edb-cac5d64f9178"), UUID.fromString("1a98678d-3bd7-45c9-a8cd-3d5d266e18b7")),

                        new MovieGenreData(UUID.fromString("08f7603b-ab99-4aff-8d07-2f1b94d66866"), UUID.fromString("44be136c-574a-4199-8392-e45fe67aa7ae")),

                        new MovieGenreData(UUID.fromString("3743c258-86f9-4293-9e31-bc08044804c6"), UUID.fromString("1161f2a9-634f-489d-a32d-f01691d78261")),

                        new MovieGenreData(UUID.fromString("d565b800-f6e8-4c5c-afd2-f71ab257946c"), UUID.fromString("44be136c-574a-4199-8392-e45fe67aa7ae"))
                );

        movieGenreService.insertMovieGenreRelationships(movieGenreData);

    }
}
