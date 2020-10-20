package br.com.vector.leandro.jogo.service.serviceImpl;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import br.com.vector.leandro.jogo.service.JogoService;
import br.com.vector.leandro.jogo.tree.Mensagem;
import br.com.vector.leandro.jogo.tree.No;

@Component(value="JogoServiceImpl")
public class JogoServiceImpl implements JogoService{ 

	private static final String SIM = "sim";
	private static final String OK = "ok";
	
	private No principal;
	private String resposta;
	private Scanner ler;
	
	public void jogar() {
		this.ler = new Scanner(System.in);
		this.iniciar();
		
		if (this.isPai(this.getPrincipal())) {
			System.out.println(this.primeiraPergunta());
			this.setResposta(this.ler.nextLine());
			if (OK.equals(this.getResposta())) {
				this.logica(this.getPrincipal());
			}
			else {
				System.out.println("Fim de jogo");
			}
		}
		else {
			this.logica(this.getPrincipal());
		}
		this.ler.close();
	}
	
	private No logica(No node) {
		if (this.isFolha(node)) {
			System.out.println(Mensagem.O_ANIMAL_QUE_VOCE_PENSEOU_EH.getMsg() + node.getCaracteristica());
			this.setResposta(ler.nextLine());
			if (SIM.equals(this.getResposta())) {
				System.out.println("Eu venci");
				return node;
			}
			else {
				System.out.println(Mensagem.QUAL_ANIMAL_VOCE_PENSOU.getMsg());
				this.setResposta(ler.nextLine());
				No novoAnimal = this.createNo(this.getResposta());
				System.out.println( Mensagem.PERGUNTA_NOVA_CARACTERISTICA.getMsg().replace("XXXX", novoAnimal.getCaracteristica()).replace("yyyy", node.getCaracteristica()) );
				this.setResposta(ler.nextLine());
				No novoCaracteristica = this.createNo(this.getResposta());
				this.inserir(node, novoCaracteristica, novoAnimal);
				return this.logica(this.nodePai(node));
			}
		}else {
			System.out.println(Mensagem.PERGUNTA_CARACTERISTICA.getMsg() + node.getCaracteristica());
			this.setResposta(ler.nextLine());
			if (SIM.equals(this.getResposta())) {
				return this.logica(node.getDireita());
			}else {
				return this.logica(node.getEsquerda());
			}
		}
	}
	
	private void inserir(No node, No caracteristica, No animal) {
		if (node.getPai().getDireita().getCaracteristica().equals(node.getCaracteristica())) {
			this.inserirDireita(node, caracteristica, animal);
		}else {
			this.inserirEsquerda(node, caracteristica, animal);
		}
	}

	private boolean isPai(No node) {
		if (node.getPai() == null) {
			return true;
		}
		return false;
	}

	private No nodePai(No node) {
		if(!this.isPai(node))
			return this.nodePai(node.getPai());
		return node;
	}

	public Boolean isFolha(No node) {
		if(node.getDireita() == null && node.getEsquerda() == null)
			return true;
		return false;
	}
	
	public No iniciar() { 
		this.getPrincipal();
		No direita = this.createNo(this.principal, "tubarao");
		No esquerda = this.createNo(this.principal, "macaco");
		this.principal.setDireita(direita);
		this.principal.setEsquerda(esquerda);

		return this.principal;
	}
	
	public String primeiraPergunta() {
		return Mensagem.PENSE_EM_UM_ANIMAL.getMsg();
	}
	
	
	@Override
	public void inserirDireita(No node, No caracteristica, No animal) {
		caracteristica.setPai(node.getPai());
		caracteristica.setEsquerda(node);
		caracteristica.setDireita(animal);
		node.getPai().setDireita(caracteristica);
		node.setPai(caracteristica);
		animal.setPai(caracteristica);
	}
	
	@Override
	public void inserirEsquerda(No node, No caracteristica, No animal) {
		caracteristica.setPai(node.getPai());
		caracteristica.setEsquerda(node);
		caracteristica.setDireita(animal);
		node.getPai().setEsquerda(caracteristica);
		node.setPai(caracteristica);
		animal.setPai(caracteristica);
	}

	@Override
	public void remover(No node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<No> list(No node) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public No getPrincipal() {
		if (this.principal == null) {
			this.principal = this.createNo("vive na água");
		}
		return principal;
	}
	
	public No setPrincipal(No principal) {
		this.principal = principal;
		return this.principal;
	}
	
	public No createNo(String caracteristica) {
		return new No(null, null, null, caracteristica);
	}
	
	public No createNo(No pai, String caracteristica) {
		return new No(pai, null, null, caracteristica);
	}
	
	public String getResposta() {
		if (this.resposta == null) {
			this.resposta = "";
		}
		return this.resposta.toLowerCase();
	}
	
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

}
