package com.mydom.rest_api_movies.utils;

import com.mydom.rest_api_movies.model.dto.Genre;
import com.mydom.rest_api_movies.model.dto.Movie;
import com.mydom.rest_api_movies.model.dto.MovieGenreData;
import com.mydom.rest_api_movies.service.GenreService;
import com.mydom.rest_api_movies.service.MovieGenreService;
import com.mydom.rest_api_movies.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

import static com.mydom.rest_api_movies.utils.GenreIds.*;
import static com.mydom.rest_api_movies.utils.MovieIds.*;

@Component
public class SampleDataQuery implements CommandLineRunner {

    MovieService movieService;
    GenreService genreService;
    MovieGenreService movieGenreService;
    private static final Logger logger;

    static {
        logger = LoggerFactory.getLogger(SampleDataQuery.class);
    }

    public SampleDataQuery(MovieService movieService, GenreService genreService, MovieGenreService movieGenreService) {
        this.movieService = movieService;
        this.genreService = genreService;
        this.movieGenreService = movieGenreService;
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info("sample data class to populate database");
        List<Movie> movies =
                Arrays.asList(
                        new Movie(
                                UUID.fromString(TITANIC_ID),
                                "Titanic",
                                "A fictionalized account of the sinking of the RMS Titanic, starring Leonardo DiCaprio and Kate Winslet.",
                                LocalDate.of(1997, 12, 19),
                                195
                        ),
                        new Movie(
                                UUID.fromString(THE_GODFATHER_ID),
                                "The Godfather",
                                "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
                                LocalDate.of(1972, 3, 24),
                                175
                        ),
                        new Movie(
                                UUID.fromString(THE_SHAWSANK_REDEMPTION_ID),
                                "The Shawshank Redemption",
                                "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
                                LocalDate.of(1994, 10, 14),
                                142
                        ),
                        new Movie(
                                UUID.fromString(INCEPTION_ID),
                                "Inception",
                                "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.A thief who steals corporate secrets.",
                                LocalDate.of(2010, 7, 16),
                                148
                        ),
                        new Movie(
                                UUID.fromString(THE_DARK_KNIGHT_ID),
                                "The Dark Knight",
                                "When the menace known as The Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.",
                                LocalDate.of(2008, 7, 18),
                                152
                        ),
                        new Movie(
                                UUID.fromString(SCHINDLERS_LIST_ID),
                                "Schindler\"\"s List",
                                "In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.",
                                LocalDate.of(1994, 12, 15),
                                195
                        ),
                        new Movie(
                                UUID.fromString(THE_LORD_OF_RINGS_ID),
                                "The Lord of the Rings: The Return of the King",
                                "Gandalf and Aragorn lead the World of Men against Sauron\"\"s army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.",
                                LocalDate.of(2003, 12, 17),
                                201
                        ),
                        new Movie(
                                UUID.fromString(PULP_FICTION_ID),
                                "Pulp Fiction",
                                "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
                                LocalDate.of(1994, 10, 12),
                                154
                        ),
                        new Movie(
                                UUID.fromString(FIGHT_CLUB_ID),
                                "Fight Club",
                                "An insomniac office worker and a devil-may-care soapmaker form an underground fight club that evolves into something much, much more.",
                                LocalDate.of(1999, 10, 15),
                                139
                        ),
                        new Movie(
                                UUID.fromString(FORREST_GUMP_ID),
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
                                UUID.fromString(ACTION_ID),
                                "Action"
                        ),
                        new Genre(
                                UUID.fromString(ADVENTURE_ID),
                                "Adventure"
                        ),
                        new Genre(
                                UUID.fromString(COMEDY_ID),
                                "Comedy"
                        ),
                        new Genre(
                                UUID.fromString(DRAMA_ID),
                                "Drama"
                        ),
                        new Genre(
                                UUID.fromString(FANTASY_ID),
                                "Fantasy"
                        ),
                        new Genre(
                                UUID.fromString(HORROR_ID),
                                "Horror"
                        ),
                        new Genre(
                                UUID.fromString(ROMANCE_ID),
                                "Romance"
                        ),
                        new Genre(
                                UUID.fromString(SCIENCE_FICTION_ID),
                                "Science Fiction"
                        ),
                        new Genre(
                                UUID.fromString(THRILLER_ID),
                                "Thriller"
                        ),
                        new Genre(
                                UUID.fromString(CRIME_ID),
                                "Crime"
                        ), new Genre(
                                UUID.fromString(WESTERN_ID),
                                "Western"
                        ), new Genre(
                                UUID.fromString(HISTORY_ID),
                                "History"
                        )
                );
        genreService.saveAll(genres);

        List<MovieGenreData> movieGenreData =
                Arrays.asList(
                        new MovieGenreData(UUID.fromString(TITANIC_ID), UUID.fromString(ACTION_ID)),
                        new MovieGenreData(UUID.fromString(TITANIC_ID), UUID.fromString(ROMANCE_ID)),

                        new MovieGenreData(UUID.fromString(THE_GODFATHER_ID), UUID.fromString(DRAMA_ID)),
                        new MovieGenreData(UUID.fromString(THE_GODFATHER_ID), UUID.fromString(CRIME_ID)),

                        new MovieGenreData(UUID.fromString(THE_SHAWSANK_REDEMPTION_ID), UUID.fromString(DRAMA_ID)),
                        new MovieGenreData(UUID.fromString(THE_SHAWSANK_REDEMPTION_ID), UUID.fromString(THRILLER_ID)),

                        new MovieGenreData(UUID.fromString(INCEPTION_ID), UUID.fromString(SCIENCE_FICTION_ID)),
                        new MovieGenreData(UUID.fromString(INCEPTION_ID), UUID.fromString(THRILLER_ID)),

                        new MovieGenreData(UUID.fromString(THE_DARK_KNIGHT_ID), UUID.fromString(ACTION_ID)),
                        new MovieGenreData(UUID.fromString(THE_DARK_KNIGHT_ID), UUID.fromString(CRIME_ID)),

                        new MovieGenreData(UUID.fromString(SCHINDLERS_LIST_ID), UUID.fromString(DRAMA_ID)),

                        new MovieGenreData(UUID.fromString(THE_LORD_OF_RINGS_ID), UUID.fromString(FANTASY_ID)),

                        new MovieGenreData(UUID.fromString(FIGHT_CLUB_ID), UUID.fromString(DRAMA_ID)),

                        new MovieGenreData(UUID.fromString(PULP_FICTION_ID), UUID.fromString(CRIME_ID)),

                        new MovieGenreData(UUID.fromString(FORREST_GUMP_ID), UUID.fromString(DRAMA_ID))
                );

        movieGenreService.insertMovieGenreRelationships(movieGenreData);
    }
}
