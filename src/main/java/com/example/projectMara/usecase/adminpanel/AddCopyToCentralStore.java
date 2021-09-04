package com.example.projectMara.usecase.adminpanel;

import com.example.projectMara.adapter.dto.CopyDto;
import com.example.projectMara.adapter.dto.MovieDto;
import com.example.projectMara.adapter.repository.CopyDao;
import com.example.projectMara.adapter.repository.MovieDao;
import com.example.projectMara.domain.model.Copy;
import com.example.projectMara.domain.model.Movie;
import com.example.projectMara.mappers.CopyMapper;
import com.example.projectMara.mappers.MovieMapper;
import com.example.projectMara.usecase.adminpanel.exception.MovieAlreadyPresentException;
import com.example.projectMara.usecase.adminpanel.exception.MovieIdDoesntExsistException;

import java.time.LocalDateTime;

public class AddCopyToCentralStore {
    private final CopyDao copyDao;

    public CopyDto add(CopyDto copyDto) throws MovieIdDoesntExsistException {

        Copy copy = CopyMapper.map(copyDto);
        if(copyDao.existsById(movie.getId()){
            throw new MovieIdDoesntExsistException(movie.getId());
        } else {
            movie.setCreatedAt(LocalDateTime.now());
            return MovieMapper.map(movieDao.save(movie));
        }
}
