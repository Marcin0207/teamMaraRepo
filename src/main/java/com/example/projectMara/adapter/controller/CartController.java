package com.example.projectMara.adapter.controller;


import com.example.projectMara.usecase.cart.CartService;
import com.example.projectMara.usecase.cart.MovieService;
import com.example.projectMara.usecase.cart.exception.NotEnoughCopiesInStockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {

    private final CartService cartService;

    private final MovieService movieService;

    @Autowired
    public CartController(CartService cartService, MovieService movieService) {
        this.cartService = cartService;
        this.movieService = movieService;
    }

    @GetMapping("/cart")
    public ModelAndView cart() {
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("copies", cartService.getMovieInCart());
        //modelAndView.addObject("total", cartService.getTotal().toString());
        return modelAndView;
    }

    @GetMapping("/cart/addMovie/{movieId}")
    public ModelAndView addMovieToCart(@PathVariable("movieId") Integer movieId) {
        movieService.findById(movieId).ifPresent(cartService::addMovie);
        return cart();
    }

    @GetMapping("/cart/removeMovie/{movieId}")
    public ModelAndView removeMovieFromCart(@PathVariable("movieId") Integer movieId) {
        movieService.findById(movieId).ifPresent(cartService::removeMovie);
        return cart();
    }

  /*  @GetMapping("/cart/checkout")
    public ModelAndView checkout() {
        try {
            cartService.checkout();
        } catch (NotEnoughCopiesInStockException e) {
            return cart().addObject("outOfStockMessage", e.getMessage());
        }
        return cart();
    }

   */
}
