package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSeries(@JsonAlias("Title") String titulo,
                          @JsonAlias("totalSeasons") Integer totaLTemporadas,
                          @JsonAlias("imdbRating") String avaliacao,
                          @JsonAlias("Poster") String capaSerie,
                          @JsonAlias("Genre") String genero,
                          @JsonAlias("Plot") String sinopse
                          )

{

}
