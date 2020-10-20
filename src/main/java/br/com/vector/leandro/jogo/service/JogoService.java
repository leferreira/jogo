package br.com.vector.leandro.jogo.service;

import java.util.List;

import br.com.vector.leandro.jogo.tree.No;

public interface JogoService {
	
	public void inserirDireita(No node, No caracteristica, No animal);
	
	public void inserirEsquerda(No node, No caracteristica, No animal);
	
	public void remover(No node);
	
	public List<No> list(No node);
	
	public No iniciar();
	
	public void jogar();

}
