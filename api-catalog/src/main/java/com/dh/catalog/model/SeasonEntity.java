package com.dh.catalog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeasonEntity implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;

    @Id
    private String seasonID;
    private Integer seasonNumber;
    private List<ChapterEntity> chapters;
}
