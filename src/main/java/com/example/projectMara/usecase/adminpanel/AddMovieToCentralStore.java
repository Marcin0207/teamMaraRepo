package com.example.projectMara.usecase.adminpanel;

import com.example.projectMara.adapter.repository.MovieDao;
import com.example.projectMara.domain.model.Movie;
import com.example.projectMara.usecase.adminpanel.exception.MovieAlreadyPresentException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddMovieToCentralStore {

    private final MovieDao movieDao;

    public Movie add(Movie movie) throws MovieAlreadyPresentException {
        if(movieDao.findByTitle(movie.getTitle()).isPresent()){
            throw new MovieAlreadyPresentException(movie.getTitle());
        } else {
            return movieDao.save(movie);
        }


    }


}
