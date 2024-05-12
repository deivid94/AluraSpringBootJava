package com.example.demo.principal;
import com.example.demo.model.DadosSeries;
import service.ConsumoApi;
import service.ConverteDados;

import java.util.Scanner;



public class Principal {
    private final String ENDERECO = "http://www.omdbapi.com/?t=";
    private final String APIKEY = "&apikey=6de054f5";
    private Scanner leitura = new Scanner(System.in);
    private  ConsumoApi consumoAPi = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();



        public void exibeMenu(){
            System.out.println("Digite o nome para serie para busca: ");
            var nomeSerie = leitura.nextLine();
            var json = consumoAPi.obterDados(ENDERECO+nomeSerie.replace(" ", "+")+APIKEY);
            DadosSeries dadoSerie = converteDados.obterDados(json, DadosSeries.class);
            System.out.println(dadoSerie);
        }
}
