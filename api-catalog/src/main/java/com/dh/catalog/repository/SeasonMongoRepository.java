package com.dh.catalog.repository;

import com.dh.catalog.model.SeasonEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonMongoRepository extends MongoRepository<SeasonEntity, Long> {
}
