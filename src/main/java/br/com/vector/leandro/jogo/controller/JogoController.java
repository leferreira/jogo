package br.com.vector.leandro.jogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vector.leandro.jogo.service.JogoService;
import br.com.vector.leandro.jogo.tree.No;

@RestController
public class JogoController {
	
	@Autowired(required = true)
	@Qualifier(value="JogoServiceImpl")
	private JogoService service;
	
	private No jogoPrincipal;
	
	
	@RequestMapping("/")
	public String index()
	{
		return "index";
	}
	
	
	@RequestMapping("/jogar")
	public String jogar(String valor)
	{
//		this.getJogoPrincipal();
//		while(true) {
//			System.out.println("Pense em um animal ?");
//			
//		}
		
		return "teste";
	}
	
	
	public No getJogoPrincipal() {
		if (this.jogoPrincipal == null) {
			this.jogoPrincipal = new No(null,null, null, "vive na água");
		}
		return this.jogoPrincipal;
	}
	
	public No setJogoPrincipal(No jogoPrincipal) {
		this.jogoPrincipal = jogoPrincipal;
		return this.getJogoPrincipal();
	}
	

}
