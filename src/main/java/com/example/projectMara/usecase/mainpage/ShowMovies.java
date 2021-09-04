package com.example.projectMara.usecase.mainpage;


import com.example.projectMara.adapter.dto.MovieMainPageDto;
import com.example.projectMara.adapter.repository.MovieDao;
import com.example.projectMara.domain.model.Movie;
import com.example.projectMara.domain.model.MovieGenre;
import com.example.projectMara.mappers.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ShowMovies {

    private final MovieDao movieDao;


    public List<MovieMainPageDto> getByAlphabeticalOrder(MovieGenre genre) {


        List<Movie> movieList = (movieDao.findByOrderByTitle());
        if (genre != null) {
            movieList = filterByGenre(movieList, genre);
        }
        List<MovieMainPageDto> movieDtos = new ArrayList<>();
        for (Movie movie : movieList) {
            movieDtos.add(MovieMapper.mapForMainPage(movie));
        }
        return movieDtos;
    }

    public List<MovieMainPageDto> getByPremiereDate(MovieGenre genre) {

        List<Movie> movieList = (movieDao.findByOrderByPremiereDate());
        if (genre != null) {
            movieList = filterByGenre(movieList, genre);
        }
        List<MovieMainPageDto> movieDtos = new ArrayList<>();
        for (Movie movie : movieList) {
            movieDtos.add(MovieMapper.mapForMainPage(movie));
        }
        return movieDtos;
    }

    public List<MovieMainPageDto> getByCreationDate(MovieGenre genre) {
        List<Movie> movieList = (movieDao.findByOrderByCreatedAt());
        if (genre != null) {
            movieList = filterByGenre(movieList, genre);
        }

        List<MovieMainPageDto> movieDtos = new ArrayList<>();
        for (Movie movie : movieList) {
            movieDtos.add(MovieMapper.mapForMainPage(movie));
        }
        return movieDtos;
    }

    public List<MovieMainPageDto> getByAvgRate(MovieGenre genre) {

        List<Movie> movieList = (movieDao.findByOrderByAvgRateDesc());
        if (genre != null) {
            movieList = filterByGenre(movieList, genre);
        }
        List<MovieMainPageDto> movieDtos = new ArrayList<>();
        for (Movie movie : movieList) {
            movieDtos.add(MovieMapper.mapForMainPage(movie));
        }
        return movieDtos;
    }

    private List<Movie> filterByGenre(List<Movie> list, MovieGenre genre) {

        list.removeIf(movie -> !movie.getMovieGenre().equals(genre));
        return list;
    }

}
