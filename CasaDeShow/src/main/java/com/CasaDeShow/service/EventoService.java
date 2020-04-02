package com.CasaDeShow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.CasaDeShow.model.CasaDeShow;
import com.CasaDeShow.model.Evento;
import com.CasaDeShow.repositorio.CasaDeShowRepository;
import com.CasaDeShow.repositorio.EventoRepository;
import com.CasaDeShow.service.exceptions.EventoNaoEncontradoException;

@Service
public class EventoService {
	@Autowired
	private EventoRepository eventoRepository;
	@Autowired
	private CasaDeShowRepository casaDeShowRepository;
	public List<Evento> listar(){
		return eventoRepository.findAll();
	}
	public List<CasaDeShow> listarCasas(){
		return casaDeShowRepository.findAll();
	}
	public Evento salvar(Evento evento) {
		evento.setIdEvento(null);
		return eventoRepository.save(evento);
	}
	public void excluir(Long idEvento) {
		if(eventoRepository.getOne(idEvento)!=null) {
			eventoRepository.deleteById(idEvento);
		}
		else {
			throw new EventoNaoEncontradoException("Não foi possivel deletar esse evento");
		}
	}
	public void deletar(Long idEvento) {
		try {
			eventoRepository.deleteById(idEvento);
		}catch(EmptyResultDataAccessException e){
			throw new EventoNaoEncontradoException("");
		}
	}




}








