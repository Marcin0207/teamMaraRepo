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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AddCopyToCentralStore {
    private final MovieDao movieDao;

    public List<CopyDto> add(int id, int quantity) throws MovieIdDoesntExsistException {


        if (!movieDao.existsById(id)) {
            throw new MovieIdDoesntExsistException(id);
        }

        Movie movie = movieDao.findById(id).get();

        List<Copy> copies = movie.getCopies();

        for (int i = 0; i < quantity; i++) {

            Copy copy = new Copy();
            copy.setMovie(movie);
            copies.add(copy);

        }

      /*  for (Copy copy:copies){
            System.out.println(copy.getId() + " " + copy.getMovie().getTitle());
        }*/
        movie.setCopies(copies);
        movieDao.save(movie);
        return CopyMapper.mapList(copies);

    }
}
