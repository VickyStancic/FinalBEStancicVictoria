package com.dh.movie.service;


import com.dh.movie.event.NewMovieEventProducer;
import com.dh.movie.model.Movie;
import com.dh.movie.repository.MovieRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    final static Logger log = Logger.getLogger(MovieService.class);
    private final MovieRepository movieRepository;
    private final NewMovieEventProducer newMovieEventProducer;

    public MovieService(MovieRepository movieRepository, NewMovieEventProducer newMovieEventProducer) {
        this.movieRepository = movieRepository;
        this.newMovieEventProducer = newMovieEventProducer;
    }
    public List<Movie> getAllMovies(){
        log.info("Listando todas las peliculas");
        return movieRepository.findAll();
    }
    public Movie getMovieById(Long id) {
        log.info("Buscando la pelicula número " + id);
        return movieRepository.findById(id).orElse(null);
    }
    public List<Movie> findByGenre(String genre) {
        log.info("Listando las peliculas del género "+ genre);
        return movieRepository.findByGenre(genre);
    }
    public Movie save(Movie movie) {
        log.info("Guardando la película " + movie.getName());
        movieRepository.save(movie);
        newMovieEventProducer.execute(movie);
        return movie;
    }
    public void deleteMovie(Long id){
        log.info("Eiminando la película con el id " + id);
        movieRepository.deleteById(id);
    }
    public void updateMovie(Movie movie){
        log.info("Actualizando la película número " + movie.getId());
        if(movieRepository.existsById(movie.getId())){
            movieRepository.save(movie);
        }
    }
}
