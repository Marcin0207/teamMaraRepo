package com.example.projectMara.adapter.controller;


import com.example.projectMara.usecase.cart.CartService;
import com.example.projectMara.usecase.cart.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
public class CartController {

    @Autowired
    private final CartService cartService;
    @Autowired
    private final MovieService movieService;



    @GetMapping("cartO")
    public ModelAndView cart() {
        ModelAndView modelAndView = new ModelAndView("/cartO");
        modelAndView.addObject("movies", cartService.getMovieInCart());
        //modelAndView.addObject("total", cartService.getTotal().toString());
        return modelAndView;
    }

    @GetMapping("cartO/addMovie/{movieId}")
    public ModelAndView addMovieToCart(@PathVariable("movieId") Integer movieId) {
        movieService.findById(movieId).ifPresent(cartService::addMovie);
        return cart();
    }

    @GetMapping("cartO/removeMovie/{movieId}")
    public ModelAndView removeMovieFromCart(@PathVariable("movieId") Integer movieId) {
        movieService.findById(movieId).ifPresent(cartService::removeMovie);
        return cart();
    }

  /*  @GetMapping("/cartO/checkout")
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
