package com.example.apiserie.repository;

import com.example.apiserie.model.SerieEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SerieRepository extends MongoRepository<SerieEntity, Long> {

    List<SerieEntity> findByGenre(String genre);
}