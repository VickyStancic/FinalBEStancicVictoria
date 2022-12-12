package com.example.apiserie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Chapter")
public class ChapterEntity {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    private Long chapterID;
    private String name;
    private Integer chapterNumber;
    private String urlStream;
}