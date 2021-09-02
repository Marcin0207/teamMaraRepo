package com.example.projectMara.adapter.controller.mainpage;

import com.example.projectMara.adapter.dto.MovieDto;
import com.example.projectMara.adapter.dto.MovieMainPageDto;
import com.example.projectMara.domain.model.MovieGenre;
import com.example.projectMara.usecase.mainpage.ShowMovies;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class homeController {

    private final ShowMovies showMovies;

    @GetMapping("titles")
    public List<MovieMainPageDto> getByTitleAlphabetical(@RequestParam MovieGenre genre) {
        return this.showMovies.getByAlphabeticalOrder(genre);
    }
    @GetMapping("premiereDate")
    public List<MovieMainPageDto> getByPremDate(@RequestParam MovieGenre genre) {
        return this.showMovies.getByPremiereDate(genre);
    }

    public List<MovieMainPageDto> getByCreationDate(@RequestParam MovieGenre genre) {
        return this.showMovies.getByCreationDate(genre);
    }
    @GetMapping("avgRate")
    public List<MovieMainPageDto> getByAvgRate(@RequestParam MovieGenre genre) {
        return this.showMovies.getByAvgRate(genre);
    }
}
