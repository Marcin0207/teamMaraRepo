package com.example.projectMara.usecase.cart.util;



import com.example.projectMara.domain.model.Movie;
import org.springframework.data.domain.Page;

public class Pager {

    private final Page<Movie> movies;

    public Pager(Page<Movie> movies) {
        this.movies = movies;
    }

    public int getPageIndex() {
        return movies.getNumber() + 1;
    }

    public int getPageSize() {
        return movies.getSize();
    }

    public boolean hasNext() {
        return movies.hasNext();
    }

    public boolean hasPrevious() {
        return movies.hasPrevious();
    }

    public int getTotalPages() {
        return movies.getTotalPages();
    }

    public long getTotalElements() {
        return movies.getTotalElements();
    }

    public boolean indexOutOfBounds() {
        return this.getPageIndex() < 0 || this.getPageIndex() > this.getTotalElements();
    }

}