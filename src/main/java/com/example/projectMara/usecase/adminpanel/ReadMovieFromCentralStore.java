package com.example.projectMara.usecase.adminpanel;

import com.example.projectMara.adapter.dto.MovieDto;
import com.example.projectMara.adapter.repository.MovieDao;
import com.example.projectMara.domain.model.Movie;
import com.example.projectMara.mappers.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReadMovieFromCentralStore {

    @Autowired
    private final MovieDao movieDao;

    public MovieDto readByTitle(String title){
        return MovieMapper.map(movieDao.findByTitle(title).get());
    }
    public MovieDto readById(Integer id){
        return MovieMapper.map(movieDao.findById(id).get());
    }

}
