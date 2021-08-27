package com.example.projectMara.usecase.adminpanel;

import com.example.projectMara.adapter.dto.MovieDto;
import com.example.projectMara.adapter.repository.MovieDao;
import com.example.projectMara.domain.model.Movie;
import com.example.projectMara.mappers.MovieMapper;
import com.example.projectMara.usecase.adminpanel.exception.MovieAlreadyPresentException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AddMovieToCentralStore {

    private final MovieDao movieDao;

    public MovieDto add(MovieDto movieDto) throws MovieAlreadyPresentException {
        Movie movie = MovieMapper.map(movieDto);
        if(movieDao.findByTitle(movie.getTitle()).isPresent()){
            throw new MovieAlreadyPresentException(movie.getTitle());
        } else {
            movie.setCreatedAt(LocalDateTime.now());
            return MovieMapper.map(movieDao.save(movie));
        }


    }


}
