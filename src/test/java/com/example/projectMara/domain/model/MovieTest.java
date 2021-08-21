package com.example.projectMara.domain.model;

import com.example.projectMara.repository.CopyDao;
import com.example.projectMara.repository.MovieDao;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest //
class MovieTest {

    @Autowired
    private MovieDao movieDao;

    @Autowired
    private CopyDao copyDao;

    @Test
    public void saves_movie_and_related_copies() {
        //given
        String movieTitle = "Transporter1";
        String movieDirector = "Corey Yuen, Louis Leterrier";

        Movie movie = Movie.builder().title(movieTitle)
                .movieGenre(MovieGenre.ACTION)
                .movieStatus(MovieStatus.CLASSIC)
                .description("mocny dobry, najlepsza czesc")
                .premiereDate(LocalDate.of(2002,10,2))
                .createdAt(LocalDateTime.now())
                .director(movieDirector)
                .build();


        Copy copy = new Copy();
        copy.setMovie(movie);
        Copy copy2 = new Copy();
        copy2.setMovie(movie);

        List<Copy> copies = new ArrayList<>();
        copies.add(copy);
        copies.add(copy2);
        //add copies list to movie
        movie.setCopies(copies);

        Optional<Movie> foundMovieOptional = movieDao.findByTitle(movieTitle);
        Assertions.assertThat(foundMovieOptional.isEmpty()).isTrue();

        //when
        movieDao.save(movie);
        foundMovieOptional = movieDao.findByTitle(movieTitle);
        Assertions.assertThat(foundMovieOptional.isPresent()).isTrue();
        Movie foundMovie = foundMovieOptional.get();

        List<Copy> foundCopies = copyDao.findAll();

        //then
        Assertions.assertThat(foundMovie.getTitle()).isEqualTo(movie.getTitle());
        Assertions.assertThat(foundMovie.getDescription()).isEqualTo("mocny dobry, najlepsza czesc");
        Assertions.assertThat(foundCopies.isEmpty()).isFalse();
        Assertions.assertThat(foundCopies.get(0).getMovie().getDescription()).isEqualTo("mocny dobry, najlepsza czesc");
    }



}