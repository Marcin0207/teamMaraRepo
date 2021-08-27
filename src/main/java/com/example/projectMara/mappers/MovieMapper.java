package com.example.projectMara.mappers;

import com.example.projectMara.adapter.dto.MovieDto;
import com.example.projectMara.domain.model.Movie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieMapper {
    public static MovieDto map(Movie movie){
        return MovieDto.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .director(movie.getDirector())
                .premiereDate(movie.getPremiereDate())
                .description(movie.getDescription())
                .movieGenre(movie.getMovieGenre())
                .movieStatus(movie.getMovieStatus())
                .avgRate(movie.getAvgRate())
                .createdAt(movie.getCreatedAt())
                .build();
    }
    public static Movie map(MovieDto movieDto){
        return Movie.builder()
                .title(movieDto.getTitle())
                .director(movieDto.getDirector())
                .movieStatus(movieDto.getMovieStatus())
                .movieGenre(movieDto.getMovieGenre())
                .premiereDate(movieDto.getPremiereDate())
                .description(movieDto.getDescription())
                .build();

    }
    public static List<MovieDto> mapList(List<Movie> movieList){
        List<MovieDto> movieDtoList = movieList.stream()
                .map(movie -> map(movie))
                .collect(Collectors.toList());

        return movieDtoList;
    }

}
