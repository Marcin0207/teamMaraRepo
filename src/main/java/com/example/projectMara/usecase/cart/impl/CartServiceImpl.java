package com.example.projectMara.usecase.cart.impl;

import com.example.projectMara.adapter.dto.MiniCartDto;
import com.example.projectMara.adapter.repository.MovieDao;
import com.example.projectMara.domain.model.Movie;
import com.example.projectMara.domain.model.PriceService;
import com.example.projectMara.usecase.adminpanel.exception.MovieIdDoesntExsistException;
import com.example.projectMara.usecase.cart.CartService;
import com.example.projectMara.usecase.cart.exception.AddingMovieDuplicateException;
import com.example.projectMara.usecase.cart.exception.MovieNotInCartException;
import com.example.projectMara.usecase.cart.exception.NotEnoughCopiesInStockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class CartServiceImpl implements CartService {

    private final MovieDao movieDao;
    private final PriceService priceService;

    private List<Movie> movies = new ArrayList<>();

    @Autowired
    public CartServiceImpl(MovieDao movieDao, PriceService priceService) {
        this.movieDao = movieDao;
        this.priceService = priceService;
    }





    @Override
    public MiniCartDto addMovie(int id) throws AddingMovieDuplicateException {
        if (!movieDao.existsById(id)) {
            throw new MovieIdDoesntExsistException(id);
        }
        Movie movie = movieDao.findById(id).get();

        for (Movie movieInCart : movies) {
            if (movieInCart.getId() == movie.getId()) {
                throw new AddingMovieDuplicateException(movie.getTitle());
            }
        }
            movies.add(movie);

            System.out.println("Koszyk:");
            for (Movie movie1 : movies) {
                System.out.println("-" +
                        movie1.getTitle()
                );

            }

            MiniCartDto miniCartDto = new MiniCartDto();
            miniCartDto.setMovieTitle(movie.getTitle());
            miniCartDto.setMoviePricePerDay(priceService.priceOfStatus(movie.getMovieStatus()));

            return miniCartDto;
    }


    @Override
    public MiniCartDto removeMovie(int id) {
        if (!movieDao.existsById(id)) {
            throw new MovieIdDoesntExsistException(id);
        }

        Movie movie = movieDao.findById(id).get();

        List<Movie> movieWithId = movies.stream().filter(m -> m.getId() == id).collect(Collectors.toList());

        if (movieWithId.isEmpty()){
            throw new MovieNotInCartException(movie.getTitle());
        }
            movies.removeIf(m ->m.getId() == id);

        System.out.println("Koszyk:");
        for (Movie movie1 : movies) {
            System.out.println("-" +
                    movie1.getTitle()
            );

        }
        MiniCartDto miniCartDto = new MiniCartDto();
        miniCartDto.setMovieTitle(movie.getTitle());
        miniCartDto.setMoviePricePerDay(priceService.priceOfStatus(movie.getMovieStatus()));

        return miniCartDto;
    }



    @Override
    public List<Movie> getMovieInCart() {
        return Collections.unmodifiableList(movies);
    }

/*
    @Override
    public void checkout() throws NotEnoughCopiesInStockException {
        Movie movie;
        for (Map.Entry<Movie, Integer> entry : movies.entrySet()) {
            // Refresh quantity for every copy before checking
            movie = movieDao.findOne(entry.getKey().getId());
            if (movie.getId() == entry.getValue())
                throw new NotEnoughCopiesInStockException(movie);
            entry.getKey().setQuantity(movie.getQuantity() - entry.getValue());

        }
        movieDao.save(movie.keySet());
        movieDao.flush();
        movies.clear();
    }

    @Override
    public BigDecimal getTotal() {
        return movies.entrySet().stream()
                .map(entry -> entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }*/
}


