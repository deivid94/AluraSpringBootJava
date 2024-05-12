package com.example.demo.principal;

import service.ConsumoApi;

import java.util.Scanner;



public class Principal {
    private final String APIKEY = "http://www.omdbapi.com/?t=";
    private final String ENDERECO = "&apikey=6de054f5";
    private Scanner leitura = new Scanner(System.in);


        public void exibeMenu(){
            System.out.println("Digite o nome para serie para busca: ");

            var nomeSerie = leitura.nextLine();
            ConsumoApi consumoApi = new ConsumoApi();
            var json = consumoApi.obterDados(ENDERECO+nomeSerie.replace(" ", "+")+APIKEY);
        }
}
