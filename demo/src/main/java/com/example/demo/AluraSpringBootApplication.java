package com.example.demo;

import com.example.demo.model.DadosEpsodios;
import com.example.demo.model.DadosSeries;
import com.example.demo.model.DadosTemporada;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.ConsumoApi;
import service.ConverteDados;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AluraSpringBootApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AluraSpringBootApplication.class, args);
	}

    @Override                   //metodoMain
    public void run(String... args) throws Exception {
        var consumoApi = new ConsumoApi();


        var json = consumoApi.obterDados("http://www.omdbapi.com/?t=gilmore+girls&apikey=6de054f5");
        ConverteDados conversor = new ConverteDados();
        DadosSeries dadoSerie = conversor.obterDados(json, DadosSeries.class);
        //System.out.println(dadoSerie);


        json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&&season=1&episode=2&apikey=6de054f5");
        DadosEpsodios dadosEpsodios = conversor.obterDados(json, DadosEpsodios.class);
       // System.out.println(dadosEpsodios);

        json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&&season=1&apikey=6de054f5");
         DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
        System.out.println(dadosTemporada);






        }


    }

