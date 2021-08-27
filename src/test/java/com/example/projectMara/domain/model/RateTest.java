package com.example.projectMara.domain.model;

import com.example.projectMara.adapter.repository.MovieDao;
import com.example.projectMara.adapter.repository.RateDao;
import com.example.projectMara.adapter.repository.UserDao;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
class RateTest {

    @Autowired
    private RateDao rateDao;

    @Autowired
    private MovieDao movieDao;

    @Autowired
    private UserDao userDao;



    @Test
    public void saves_rate_and_related_users_and_movies() {
        //given
        String movieTitle = "Terminator2";
        String movieDirector = "James Cameron";

        Movie movie = Movie.builder().title(movieTitle)
                .movieGenre(MovieGenre.ACTION)
                .movieStatus(MovieStatus.CLASSIC)
                .description("mocny dobry, najlepsza czesc")
                .premiereDate(LocalDate.of(1991,7,1))
                .createdAt(LocalDateTime.now())
                .director(movieDirector)
                .build();


        User user1 = User.builder().fullName("Adam Mickiewicz")
                .nickName("Wieszczu")
                .phoneNumber("44-44-44-444")
                .password("pantadeusz11")
                .email("adam.miszcz@wp.pl")
                .createdAt(LocalDateTime.now())
                .build();

        Rate rate1 = new Rate();
        rate1.setValue(2);
        rate1.setMovie(movie);
        rate1.setUser(user1);
        rate1.setComment("na dziesięć dwa, hahaha");

        List<Rate> rateList = new ArrayList<>();
        rateList.add(rate1);

        user1.setRateList(rateList);

        movie.setRateList(rateList);



        Optional<Rate> foundRateOptional = rateDao.findById(1);
        Assertions.assertThat(foundRateOptional.isEmpty()).isTrue();

        Optional<Movie> foundMovieOptional = movieDao.findByTitle(movieTitle);
        Assertions.assertThat(foundMovieOptional.isEmpty()).isTrue();

        //when
        movieDao.save(movie);
        userDao.save(user1);

        foundRateOptional = rateDao.findById(1);
        Assertions.assertThat(foundRateOptional.isPresent()).isTrue();

        foundMovieOptional = movieDao.findById(1);
        Assertions.assertThat(foundMovieOptional.isPresent()).isTrue();

        Rate foundRate = foundRateOptional.get();

        Movie foundMovie = foundMovieOptional.get();

        //then
        Assertions.assertThat(foundRate.getMovie().getTitle()).isEqualTo("Terminator2");
        Assertions.assertThat(foundRate.getUser().getNickName()).isEqualTo(user1.getNickName());

    }

}