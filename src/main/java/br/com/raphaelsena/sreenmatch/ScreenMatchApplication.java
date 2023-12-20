package br.com.raphaelsena.sreenmatch;

import br.com.raphaelsena.sreenmatch.model.DadosEpisodios;
import br.com.raphaelsena.sreenmatch.model.DadosSerie;
import br.com.raphaelsena.sreenmatch.service.ConsumoApi;
import br.com.raphaelsena.sreenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ScreenMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=c75b219d");
		// System.out.println(json);
		// json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
		json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&Season=1&Episode=2&apikey=c75b219d");
		DadosEpisodios dadosEpisodio = conversor.obterDados(json, DadosEpisodios.class);
		System.out.println(dadosEpisodio);
	}
}
