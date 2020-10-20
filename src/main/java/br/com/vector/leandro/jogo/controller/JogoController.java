package br.com.vector.leandro.jogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vector.leandro.jogo.service.JogoService;
import br.com.vector.leandro.jogo.service.serviceImpl.JogoServiceImpl;
import br.com.vector.leandro.jogo.tree.No;

@RestController
public class JogoController {
	
	@Autowired(required = true)
	@Qualifier(value="JogoServiceImpl")
	private JogoService service;
	
	
	@RequestMapping("/")
	public String index()
	{
		return "index";
	}
	
	
	@RequestMapping("/jogar")
	public String jogar(String valor)
	{
		service.jogar();
		return "teste";
	}

}
