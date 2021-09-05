package com.example.projectMara.adapter.controller;


import com.example.projectMara.adapter.dto.CartDto;
import com.example.projectMara.adapter.dto.MiniCartDto;
import com.example.projectMara.adapter.dto.MovieDto;
import com.example.projectMara.usecase.cart.CartService;
import com.example.projectMara.usecase.cart.MovieService;
import com.example.projectMara.usecase.cart.exception.AddingMovieDuplicateException;
import com.example.projectMara.usecase.cart.exception.MovieNotInCartException;
import com.example.projectMara.usecase.logregister.exception.FullNameToLongException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CartController {

    @Autowired
    private final CartService cartService;
    @Autowired
    private final MovieService movieService;

    @ExceptionHandler(MovieNotInCartException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleMovieNotInCartException(HttpServletRequest hser, Exception ex){
        log.error(hser.getRequestURI()+ " error: "  +ex.getMessage());

    }
    @ExceptionHandler(AddingMovieDuplicateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleAddingMovieDuplicateException(HttpServletRequest hser, Exception ex){
        log.error(hser.getRequestURI()+ " error: "  +ex.getMessage());

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("catalogue/movie/addToCart/{id}")
    public MiniCartDto addToCart(@PathVariable int id) {
        return this.cartService.addMovie(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("cart/removeFromCart/{id}")
    public MiniCartDto removeFromCart(@PathVariable int id) {
        return this.cartService.removeMovie(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("cart")
    public CartDto removeFromCart() {
        return this.cartService.showCart();
    }
//    @GetMapping("cartO")
//    public ModelAndView cart() {
//        ModelAndView modelAndView = new ModelAndView("/cartO");
//        modelAndView.addObject("movies", cartService.getMovieInCart());
//        //modelAndView.addObject("total", cartService.getTotal().toString());
//        return modelAndView;
//    }
//
//    @GetMapping("cartO/addMovie/{movieId}")
//    public ModelAndView addMovieToCart(@PathVariable("movieId") Integer movieId) {
//        movieService.findById(movieId).ifPresent(cartService::addMovie);
//        return cart();
//    }
//
//    @GetMapping("cartO/removeMovie/{movieId}")
//    public ModelAndView removeMovieFromCart(@PathVariable("movieId") Integer movieId) {
//        movieService.findById(movieId).ifPresent(cartService::removeMovie);
//        return cart();
//    }
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

/*
    public MovieDto getById(@PathVariable int id){
        return this.readMovieFromCentralStore.readById(id);
    }

    @GetMapping("cart")
    public CartDto cart() {
        cartService.getCartDto;


        cartService.getMovieInCart());
        modelAndView.addObject("total", cartService.getTotal().toString());
        return modelAndView;
    }

}
*/