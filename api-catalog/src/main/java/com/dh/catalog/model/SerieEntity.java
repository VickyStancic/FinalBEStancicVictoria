package com.dh.catalog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Serie")
public class SerieEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    private Long serieID;
    private String name;
    private String genre;
    private List<SeasonEntity> seasons;
}
