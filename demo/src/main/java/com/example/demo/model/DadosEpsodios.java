package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)
public record DadosEpsodios(@JsonAlias ("Title") String tituloEpsodio,
                            @JsonAlias("imdbRating") String avaliacaoEpsodio,
                            @JsonAlias("Plot")String sinopsEpsodio,
                            @JsonAlias("Runtime") String duracaoEpsodio

                            )
{

}
