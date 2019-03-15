package com.sheffmachine.netfluxexamle.service;

import com.sheffmachine.netfluxexamle.domain.Movie;
import com.sheffmachine.netfluxexamle.domain.MovieEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {
    Flux<MovieEvent> events(String movieId);
    Mono<Movie> getMoviesById(String id);
    Flux<Movie> getAllMovies();
}
