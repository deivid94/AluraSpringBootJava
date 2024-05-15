package com.example.demo.principal;
import com.example.demo.model.DadosEpsodios;
import com.example.demo.model.DadosSeries;
import com.example.demo.model.DadosTemporada;
import com.example.demo.model.Episodio;
import service.ConsumoApi;
import service.ConverteDados;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;


public class Principal {
    private final String ENDERECO = "http://www.omdbapi.com/?t=";
    private final String APIKEY = "&apikey=6de054f5";
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumoAPi = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();


    public void exibeMenu() {
        System.out.println("Digite o nome para serie para busca: ");
        var nomeSerie = leitura.nextLine();
        var json = consumoAPi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + APIKEY);
        DadosSeries dadoSerie = converteDados.obterDados(json, DadosSeries.class);



        List<DadosTemporada> temporadas = new ArrayList<>();
        for (int i = 1; i <= dadoSerie.totaLTemporadas(); i++) {
            json = consumoAPi.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + APIKEY);
            DadosTemporada dadosTemporada = converteDados.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);

        }

    List<DadosEpsodios> dadosEpsodios = temporadas.stream()
            .flatMap(t -> t.epsodios().stream())
            .toList();
        System.out.println("\n top 10 epsodios: ");
        dadosEpsodios.stream()
                .filter(e -> !e.avaliacaoEpsodio().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DadosEpsodios::avaliacaoEpsodio).reversed())
                .limit(10)
                .map(e -> e.tituloEpsodio().toUpperCase());
//                .forEach(System.out::println);


        List<Episodio> epsodio = temporadas.stream()
            .flatMap(t -> t.epsodios().stream())
            .map(d-> new Episodio(d.numeroEpsodio(), d)).toList();
        epsodio.forEach(System.out::println);


        System.out.println("Digite um trecho do titulo do epsodio");
            var trechoDoTitulo = leitura.nextLine();
             Optional<Episodio>  episodioBuscado = epsodio.stream()

                    .filter(e -> e.getTitulo().toUpperCase().contains(trechoDoTitulo.toUpperCase()))
                    .findFirst();
             if (episodioBuscado.isPresent()){
                 System.out.println("Epsodios encontrado:");
                 System.out.println("temporada: "+ episodioBuscado.get().getTemporada());
             }else {
                 System.out.println("Epsodio nao encontrado: ");
             }

//        System.out.println("Deseja filtrar datas de epsodios informe: ");
//        var ano = leitura.nextInt();
//        leitura.nextLine();
//        LocalDate dataBusca = LocalDate.of(ano, 1,1);
//
//        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        epsodio.stream()
//                .filter(e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
//                .forEach(e -> System.out.println(
//                        "Tempoorada: " + e.getTemporada() +
//                                "Episodio: " + e.getTitulo() +
//                                "Data lancamento: " + e.getDataLancamento().format(formatador)));

        Map<Integer, Double>  avaliacoesPorTemporada = epsodio.stream()
                .filter(e -> e.getAvaliacao() > 0.0)
                .collect(Collectors.groupingBy(Episodio::getTemporada, // Coleta os elementos da stream
                        Collectors.averagingDouble(Episodio::getAvaliacao)));
        System.out.println(avaliacoesPorTemporada);

        DoubleSummaryStatistics est  = epsodio.stream()
                .filter(e -> e.getAvaliacao() > 0.0)
                .collect(Collectors.summarizingDouble(Episodio::getAvaliacao));

        System.out.println("media: " +est.getAverage());
        System.out.println("Melhor epsodio: " +est.getMax());
        System.out.println("Pior epsodio: " +est.getMin());
    }
}