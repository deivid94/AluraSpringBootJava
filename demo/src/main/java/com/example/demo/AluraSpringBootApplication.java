package com.example.demo;

import com.example.demo.model.DadosSeries;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.ConsumoApi;
import service.ConverteDados;

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
        DadosSeries dados = conversor.obterDados(json, DadosSeries.class);
        System.out.println(dados);


    }
}
