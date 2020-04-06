package com.CasaDeShow.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.CasaDeShow.model.CasaDeShow;
import com.CasaDeShow.model.Evento;
import com.CasaDeShow.model.GenerosMusicais;
import com.CasaDeShow.service.CasaDeShowService;
import com.CasaDeShow.service.EventoService;

@Controller
@RequestMapping("/evento")
public class EventoController {
	@Autowired
	private EventoService eventoService;
	@Autowired
	private CasaDeShowService casaDeShowService;
	
	private static final String CADASTRO_VIEW="CadastroEvento";
	@ModelAttribute("todosGenerosMusicais")
	public List<GenerosMusicais> todosGenerosMusicais(){
		return Arrays.asList(GenerosMusicais.values());
	}
	@ModelAttribute("todasCasasDeShow")
	public List<CasaDeShow> todasCasasDeShow(){
		return casaDeShowService.listar();
	}
	@RequestMapping
	public ModelAndView eventos() {
		List<Evento> todosEventos = eventoService.listar();
		ModelAndView mv = new ModelAndView("");
		mv.addObject("eventos", todosEventos);
		return mv;
	}
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Evento());
		return mv;
	}
	@RequestMapping(method=RequestMethod.POST)
	public String salvar(@Validated Evento evento,Errors errors,RedirectAttributes attributes) {
		if(errors.hasErrors()) {
			return CADASTRO_VIEW;
		}
		else {
			eventoService.salvar(evento);
			attributes.addFlashAttribute("mensagem", "Evento criado com sucesso!");
			return "redirect:/evento/novo";
		}
	}
	@RequestMapping("{idEvento}")
	public ModelAndView edicao(@PathVariable("idEvento") Evento evento) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(evento);
		return mv;
	}
	@RequestMapping(value="{idEvento}",method=RequestMethod.POST)
	public String excluir(@PathVariable Long idEvento, RedirectAttributes attributes) {
		eventoService.excluir(idEvento);
		attributes.addFlashAttribute("mensagem","Eventos excluido com sucesso!");
		return "redirect:/evento";
	}
	
}
