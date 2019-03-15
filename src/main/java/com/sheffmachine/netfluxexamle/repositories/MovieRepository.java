package com.sheffmachine.netfluxexamle.repositories;

import com.sheffmachine.netfluxexamle.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {}
