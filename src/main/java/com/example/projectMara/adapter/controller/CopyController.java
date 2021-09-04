package com.example.projectMara.adapter.controller;

import com.example.projectMara.adapter.dto.CopyDto;
import com.example.projectMara.adapter.dto.MovieDto;
import com.example.projectMara.adapter.dto.MovieMainPageDto;
import com.example.projectMara.domain.model.MovieGenre;
import com.example.projectMara.usecase.adminpanel.AddCopyToCentralStore;
import com.example.projectMara.usecase.adminpanel.exception.MovieAlreadyPresentException;
import com.example.projectMara.usecase.adminpanel.exception.MovieIdDoesntExsistException;
import com.example.projectMara.usecase.cart.exception.AddingMovieDuplicateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("catalogue/copy")
@RequiredArgsConstructor

public class CopyController {

    @Autowired
    private AddCopyToCentralStore addCopyToCentralStore;

    @ExceptionHandler(MovieIdDoesntExsistException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public void handleMovieIdDoesntExsistException(HttpServletRequest hser, Exception ex) {
        log.error(hser.getRequestURI() + " error: " + ex.getMessage());
    }

    @PostMapping("addCopy/{id}")
    public List<CopyDto> getById(@PathVariable int id, @RequestParam int quantity){
        return this.addCopyToCentralStore.add (id, quantity);
    }

}
