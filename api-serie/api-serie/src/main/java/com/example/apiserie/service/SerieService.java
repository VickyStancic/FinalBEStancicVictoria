package com.example.apiserie.service;

import com.example.apiserie.event.NewSerieEventProducer;
import com.example.apiserie.model.SerieEntity;
import com.example.apiserie.repository.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {
    private final SerieRepository serieRepository;
    private final NewSerieEventProducer newSerieEventProducer;

    public SerieService(SerieRepository serieRepository, NewSerieEventProducer newSerieEventProducer) {
        this.serieRepository = serieRepository;
        this.newSerieEventProducer = newSerieEventProducer;
    }
    public List<SerieEntity> findByGenre(String genre) {
        return serieRepository.findByGenre(genre);
    }
    public void save(SerieEntity serie) {
        //newSerieEventProducer.execute(serie);
         serieRepository.save(serie);
    }
}
