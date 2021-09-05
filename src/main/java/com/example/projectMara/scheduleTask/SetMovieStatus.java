package com.example.projectMara.scheduleTask;

import com.example.projectMara.adapter.repository.MovieDao;
import com.example.projectMara.domain.model.Movie;
import com.example.projectMara.domain.model.MovieStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SetMovieStatus {

    private final MovieDao movieDao;

    @Async
    @Scheduled(cron = "0 00 00 * * ?")
    public void setStatus() {
        System.out.println("############## Scheduled");

        long daysBetween;


        List<Movie> movieList = movieDao.findAll();
        for (Movie movie : movieList) {


            daysBetween = ChronoUnit.DAYS.between(movie.getPremiereDate(), LocalDate.now());

            movie.setMovieStatus(getStatusFromDays(daysBetween));
            movieDao.save(movie);
            System.out.println("daysBetween" + daysBetween);
        }

    }

    private MovieStatus getStatusFromDays(long daysBetween) {

        MovieStatus status = MovieStatus.STANDARD;

        if (daysBetween <= 14) {
            status = MovieStatus.PREMIERE;

        } else if (14 < daysBetween && daysBetween < 90) {
            status = MovieStatus.NOVELTY;

        } else if (90 <= daysBetween && daysBetween < 365) {
            status = MovieStatus.STANDARD;

        } else if (daysBetween >= 365) {
            status = MovieStatus.CLASSIC;

        }
        return status;
    }
}