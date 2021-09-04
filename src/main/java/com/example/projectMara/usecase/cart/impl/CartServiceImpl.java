package com.example.projectMara.usecase.cart.impl;

import com.example.projectMara.adapter.repository.MovieDao;
import com.example.projectMara.domain.model.Movie;
import com.example.projectMara.usecase.cart.CartService;
import com.example.projectMara.usecase.cart.exception.AddingMovieDuplicateException;
import com.example.projectMara.usecase.cart.exception.NotEnoughCopiesInStockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.*;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class CartServiceImpl implements CartService {

    private final MovieDao movieDao;

    private List<Movie> movies = new ArrayList<>();

    @Autowired
    public CartServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }


    @Override
    public void addMovie(Movie movie) throws AddingMovieDuplicateException {
        for (Movie movie2 : movies) {
            if (movie2.getTitle() == movie.getTitle()) {
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

    }


    @Override
    public void removeMovie(Movie movie) {
            movies.remove(movie.getId());

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

    /*@Override
    public BigDecimal getTotal() {
        return movies.entrySet().stream()
                .map(entry -> entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }*/
}


