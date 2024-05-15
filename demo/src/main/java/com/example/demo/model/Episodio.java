package com.example.demo.model;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Episodio {
    private Integer temporada;
    private String titulo;
    private Integer numeroEpsodio;
    private Double avaliacao;
    private LocalDate dataLancamento;

    public Episodio (Integer numeroTemporada, DadosEpsodios dadosEpsodios ){
        this.temporada = numeroTemporada;
        this.titulo = dadosEpsodios.tituloEpsodio();
        this.numeroEpsodio =  dadosEpsodios.numeroEpsodio();

        try {
            this.avaliacao = Double.valueOf(dadosEpsodios.avaliacaoEpsodio()) ;
        }catch (NumberFormatException ex){
            this.avaliacao = 0.0;
        }

        try {
            this.dataLancamento = LocalDate.parse (dadosEpsodios.dataLancamento());
        }catch (DateTimeException ex){
            this.dataLancamento = null;
        }



    }

    @Override
    public String toString() {
        return "temporada=" + temporada + "," +
                " titulo='" + titulo +  "," +
                " numeroEpsodio='" + numeroEpsodio + '\'' +
                ", avaliacao='" + avaliacao + '\'' +
                ", dataLancamento=" + dataLancamento ;
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNumeroEpsodio() {
        return numeroEpsodio;
    }

    public void setNumeroEpsodio(Integer numeroEpsodio) {
        this.numeroEpsodio = numeroEpsodio;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}
