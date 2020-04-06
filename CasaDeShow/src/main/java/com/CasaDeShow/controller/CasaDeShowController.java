package com.CasaDeShow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.CasaDeShow.model.CasaDeShow;
import com.CasaDeShow.service.CasaDeShowService;

@Controller
@RequestMapping("/casaDeShow")
public class CasaDeShowController {
	@Autowired
	private CasaDeShowService casaDeShowService;
	private static final String CADASTRO_VIEW = "CadastroCasas";
	@RequestMapping
	public ModelAndView casasDeShow() {
		List<CasaDeShow> todasCasas = casaDeShowService.listar();
		ModelAndView mv = new ModelAndView("ListagemCasaDeShow");
		mv.addObject("casas",todasCasas);
		return mv;
	}
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new CasaDeShow());
		return mv;
	}
	@RequestMapping(method=RequestMethod.POST)
	public String salvar(@Validated CasaDeShow casa, Errors errors,RedirectAttributes attributes) {
		if(errors.hasErrors()) {
			return CADASTRO_VIEW;
		}
		else {
			casaDeShowService.salvar(casa);
			attributes.addFlashAttribute("mensagem", "Casa de show criada com sucesso");
			return "redirect:/casaDeShow/novo";
		}
	}
	@RequestMapping("{idCasaDeShow}")
	public ModelAndView edicao(@PathVariable("idCasaDeShow") CasaDeShow casaDeShow) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(casaDeShow);
		return mv;
	}
	@RequestMapping(value="{idCasaDeShow}",method=RequestMethod.POST)
	public String excluir(@PathVariable Long idCasaDeShow,RedirectAttributes attributes) {
		casaDeShowService.excluir(idCasaDeShow);
		attributes.addFlashAttribute("mensagem","Casa de show excluida com sucesso!");
		return "redirect:/casaDeShow";
	}	
}
