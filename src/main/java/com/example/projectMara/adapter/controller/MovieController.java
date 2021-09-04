package com.example.projectMara.adapter.controller;

import com.example.projectMara.adapter.dto.CartDto;
import com.example.projectMara.adapter.dto.MiniCartDto;
import com.example.projectMara.adapter.dto.MovieDto;
import com.example.projectMara.usecase.adminpanel.AddMovieToCentralStore;
import com.example.projectMara.usecase.adminpanel.ReadMovieFromCentralStore;
import com.example.projectMara.usecase.adminpanel.exception.MovieAlreadyPresentException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("catalogue/movie")
@RequiredArgsConstructor
public class MovieController {

    @Autowired
    private AddMovieToCentralStore addMovieToCentralStore;
    @Autowired
    private ReadMovieFromCentralStore readMovieFromCentralStore;

    @ExceptionHandler(MovieAlreadyPresentException.class)
    @ResponseStatus(HttpStatus.ALREADY_REPORTED)
    public void handleException(HttpServletRequest hser, Exception ex){
        log.error(hser.getRequestURI()+ " error: "  +ex.getMessage());

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("add")
    public MovieDto add(@RequestBody MovieDto movieDto) {
        return this.addMovieToCentralStore.add(movieDto);
    }

    @GetMapping("get/{id}")
    public MovieDto getById(@PathVariable int id){
        return this.readMovieFromCentralStore.readById(id);
    }

    @GetMapping("get")
    public MovieDto getByTitle(@RequestParam String title){
        return this.readMovieFromCentralStore.readByTitle(title);
    }


}
