package com.sheffmachine.netfluxexamle.controllers;

import com.sheffmachine.netfluxexamle.domain.Movie;
import com.sheffmachine.netfluxexamle.domain.MovieEvent;
import com.sheffmachine.netfluxexamle.service.MovieService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(value = "/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE
    )
    Flux<MovieEvent> streamMovieEvents(@PathVariable String id) {
        return movieService.events(id);
    }
    @GetMapping("/{id}")
    Mono<Movie> getMoviesById(@PathVariable String id) {
        return movieService.getMoviesById(id);
    }
    @GetMapping({"", "/"})
    Flux<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
}
