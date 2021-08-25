package com.example.projectMara.usecase.adminpanel;

import com.example.projectMara.adapter.repository.MovieDao;
import com.example.projectMara.domain.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReadMovieFromCentralStore {

    @Autowired
    private final MovieDao movieDao;

    public Movie readByTitle(String title){
        return movieDao.findByTitle(title).get();
    }
    public Movie readById(Integer id){
        return movieDao.findById(id).get();
    }

}
