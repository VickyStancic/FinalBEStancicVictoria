package com.example.apiserie.event;

import com.example.apiserie.config.RabbitMQConfig;
import com.example.apiserie.model.SerieEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Component
@Slf4j
public class NewSerieEventProducer {
    private final RabbitTemplate rabbitTemplate;
    public NewSerieEventProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    public void execute(SerieEntity newSerie) {
        NewSerieEventProducer.Data data = new NewSerieEventProducer.Data();
        BeanUtils.copyProperties(newSerie, data.getSerie());
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.TOPIC_NEW_SERIES, data);
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Data implements Serializable {
        @Serial
        private static final long serialVersionUID = 1L;
        private Data.SerieDTO serie = new Data.SerieDTO();
        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class SerieDTO implements Serializable {
            @Serial
            private static final long serialVersionUID = 1L;
            private Long serieId;
            private String name;
            private String genre;
            private List<SeasonDTO> seasons;
        }
        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class SeasonDTO implements Serializable {
            @Serial
            private static final long serialVersionUID = 1L;
            private Long seasonId;
            private Integer seasonNumber;
            private List<ChapterDTO> chapters;
        }
        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class ChapterDTO implements Serializable {
            @Serial
            private static final long serialVersionUID = 1L;
            private Long chapterId;
            private String name;
            private Integer chapterNumber;
            private String urlStream;
        }
    }
}
