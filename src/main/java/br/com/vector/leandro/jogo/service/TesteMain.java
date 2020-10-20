package br.com.vector.leandro.jogo.service;

import br.com.vector.leandro.jogo.service.serviceImpl.JogoServiceImpl;

public class TesteMain {

	public static void main(String[] args) {
		JogoServiceImpl servico = new JogoServiceImpl();
		servico.jogar();

	}

}
