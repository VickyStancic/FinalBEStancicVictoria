package com.dh.catalog.service;

import com.dh.catalog.model.MovieEntity;
import com.dh.catalog.model.SerieEntity;
import com.dh.catalog.repository.MovieMongoRepository;
import com.dh.catalog.repository.SerieMongoRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogOfflineService {

    final static Logger log = Logger.getLogger(CatalogOfflineService.class);

    private final MovieMongoRepository movieMongoRepository;
    private final SerieMongoRepository serieMongoRepository;

    public CatalogOfflineService(MovieMongoRepository movieMongoRepository, SerieMongoRepository serieMongoRepository) {
        this.movieMongoRepository = movieMongoRepository;
        this.serieMongoRepository = serieMongoRepository;
    }
    public List<MovieEntity> findMovieByGenre(String genre) {
        List<MovieEntity> allMovies = movieMongoRepository.findAll();
        List<MovieEntity> genreMovies = new ArrayList<>();
        for (MovieEntity movie : allMovies) {
            if (movie.getGenre().equals(genre)) {
                genreMovies.add(movie);
            }
        }
        log.info("Consultando la película del género " + genre + "en la base de datos catálogo");
        return genreMovies;
    }
    public List<SerieEntity> findSerieByGenre(String genre) {
        List<SerieEntity> allSeries = serieMongoRepository.findAll();
        List<SerieEntity> genreSeries = new ArrayList<>();
        for (SerieEntity serie : allSeries) {
            if (serie.getGenre().equals(genre)) {
                genreSeries.add(serie);
            }
        }
        log.info("Consultando las series del género " + genre + "en la base de datos de catálogo");
        return genreSeries;
    }
}
