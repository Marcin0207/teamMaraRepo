package com.example.projectMara.usecase;

import com.example.projectMara.domain.model.Movie;
import com.example.projectMara.domain.model.MovieGenre;
import com.example.projectMara.domain.model.MovieStatus;
import com.example.projectMara.usecase.adminpanel.AddMovieToCentralStore;
import com.example.projectMara.usecase.adminpanel.ReadMovieFromCentralStore;
import com.example.projectMara.usecase.adminpanel.exception.MovieAlreadyPresentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest
class AddMovieToCentralStoreTest {


    @Autowired
    private AddMovieToCentralStore addMovieToCentralStore;

    @Autowired
    private ReadMovieFromCentralStore readMovieByTitleFromCentralStore;

    Movie movie;
    @BeforeEach
    void createMovie() {
         movie = Movie.builder().title("Harry Potter i Komnata Tajemnic 3")
                .movieGenre(MovieGenre.FANTASY)
                .movieStatus(MovieStatus.CLASSIC)
                .description("W Hogwarcie dochodzi do tajemniczych ataków na uczniów.")
                .premiereDate(LocalDate.of(2002, 11, 3))
                .createdAt(LocalDateTime.now())
                .director("Chris Columbus")
                .build();
    }


    @Test
    void shouldAddNewMovieToCentralStore() throws MovieAlreadyPresentException {

        //given

        //when
        Movie newMovie = addMovieToCentralStore.add(movie);
        Movie readMovie = readMovieByTitleFromCentralStore.readByTitle(movie.getTitle());

        //then
        Assertions.assertAll(
                () -> assertThat(newMovie.getTitle()).isEqualTo(readMovie.getTitle()),
                () -> assertThat(newMovie.getId()).isEqualTo(readMovie.getId())
        );
    }

    @Test
    void shouldThrowExceptionIfMovieExists() throws MovieAlreadyPresentException {

        Movie movie2 = Movie.builder().title("Harry Potter i Komnata Tajemnic 3")
                .movieGenre(MovieGenre.FANTASY)
                .movieStatus(MovieStatus.CLASSIC)
                .description("W Hogwarcie dochodzi do tajemniczych ataków na uczniów.")
                .premiereDate(LocalDate.of(2002, 11, 3))
                .createdAt(LocalDateTime.now())
                .director("Chris Columbus")
                .build();
        //when
        Movie newMovie = addMovieToCentralStore.add(movie);

        assertThatExceptionOfType(MovieAlreadyPresentException.class).isThrownBy(()->addMovieToCentralStore.add(movie2));

    }


}