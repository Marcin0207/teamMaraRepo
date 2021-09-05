package com.example.projectMara.scheduleTask;

import com.example.projectMara.adapter.repository.MovieDao;
import com.example.projectMara.domain.model.Movie;
import com.example.projectMara.domain.model.MovieStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SetMovieStatus {

    private final MovieDao movieDao;

    @Async
    @Scheduled(cron = "*/10 * * * * *")
    public void setStatus() {
        System.out.println("############## Scheduled");

        int daysBetween;

        List<Movie> movieList = movieDao.findAll();
        for (Movie movie : movieList) {
            daysBetween = (int) Duration.between(movie.getPremiereDate(), LocalDateTime.now()).toDays();

            movie.setMovieStatus(getStatusFromDays(daysBetween));
            movieDao.save(movie);
            System.out.println("daysBetween" + daysBetween);
        }

    }

    private MovieStatus getStatusFromDays(int daysBetween) {

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