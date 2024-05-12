package com.example.demo;


import com.example.demo.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class AluraSpringBootApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AluraSpringBootApplication.class, args);
	}

    @Override                   //metodoMain
    public void run(String... args) throws Exception {
        Principal menu = new Principal();
        menu.exibeMenu();

//
//        List<DadosTemporada> temporadas = new ArrayList<>();
//         for (int i = 1 ; i<= dadoSerie.totaLTemporadas(); i ++){
//             json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&&season="+i+"&apikey=6de054f5");
//             DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
//             temporadas.add(dadosTemporada);
//             temporadas.forEach(System.out::println);
         }









    }

