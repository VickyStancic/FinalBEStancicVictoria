package com.dh.catalog.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="api-serie")

public interface SerieServiceClient {

    @GetMapping("/api/v1/series/{genre}")
    List<SerieDTO> getSerieByGenre(@PathVariable (value = "genre") String genre);
    @Getter
    @Setter
    @AllArgsConstructor
    class SerieDTO{
        private Long serieID;
        private String name;
        private String genre;
        private List<SeasonDTO> seasons;
    }
    @Getter
    @Setter
    @AllArgsConstructor
    static class SeasonDTO{
        private Long seasonID;
        private Integer seasonNumber;
        private List<ChapterDTO> chapters;
    }
    @Getter
    @Setter
    @AllArgsConstructor
    static class ChapterDTO{
        private Long chapterID;
        private String name;
        private Integer chapterNumber;
        private String urlStream;
    }
}
