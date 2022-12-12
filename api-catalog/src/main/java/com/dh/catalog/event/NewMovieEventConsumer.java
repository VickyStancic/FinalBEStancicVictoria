package com.dh.catalog.event;

import com.dh.catalog.config.RabbitMQConfig;
import com.dh.catalog.model.MovieEntity;
import com.dh.catalog.repository.MovieMongoRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

@Component
public class NewMovieEventConsumer {

    private MovieMongoRepository movieMongoRepository;

    public NewMovieEventConsumer(MovieMongoRepository movieMongoRepository) {
        this.movieMongoRepository = movieMongoRepository;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NEW_MOVIE)
    public void execute(NewMovieEventConsumer.Data data){
        MovieEntity movieNew = new MovieEntity();
        BeanUtils.copyProperties(data.getMovie(), movieNew);
        movieMongoRepository.save(movieNew);


    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Data implements Serializable {
        private MovieDto movie = new MovieDto();

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class MovieDto {
            private String movieId;
            private String name;
            private String genre;
            private String urlStream;
        }
    }

}