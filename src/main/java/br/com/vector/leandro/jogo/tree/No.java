package br.com.vector.leandro.jogo.tree;

import java.io.Serializable;

public class No implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5169230574349044402L;
	
	private No pai;
	private No direita;
	private No esquerda;
	private String caracteristica;
	
	
	public No(No pai, No direita, No esquerda, String caracteristica) {
		this.pai = pai;
		this.direita = direita;
		this.esquerda = esquerda;
		this.caracteristica = caracteristica;
	}
	
	public No getPai() {
		return pai;
	}
	public void setPai(No pai) {
		this.pai = pai;
	}
	public No getDireita() {
		return direita;
	}
	public void setDireita(No direita) {
		this.direita = direita;
	}
	public No getEsquerda() {
		return esquerda;
	}
	public void setEsquerda(No esquerda) {
		this.esquerda = esquerda;
	}
	public String getCaracteristica() {
		return caracteristica;
	}
	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}


	@Override
	public String toString() {
		return getCaracteristica();
	}
	
	
	
}
