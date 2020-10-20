package br.com.vector.leandro.jogo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import jogo.negocio.Logica;

@SpringBootApplication
public class JogoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JogoApplication.class, args);
	} 
	
	@Bean 
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("==============================================================");
			System.out.println("Funcionou");
			Logica logica = new Logica();
			logica.inicia();
			System.out.println("==============================================================");
		};
	}

}
