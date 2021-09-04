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
import java.util.List;

public class AddCopyToCentralStore {
    private final MovieDao movieDao;

    public CopyDto add(int id, int quantity) throws MovieIdDoesntExsistException {


        if(!movieDao.existsById(id))
        {
            throw new MovieIdDoesntExsistException(id);
        }

         Movie movie = movieDao.findById(id).get();

         List<Copy> copies  = movie.getCopies();
         copies.add(1,)
                 for (int i = 1, )




}
