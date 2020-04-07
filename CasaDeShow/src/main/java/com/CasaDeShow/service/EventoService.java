package com.CasaDeShow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CasaDeShow.model.CasaDeShow;
import com.CasaDeShow.model.Evento;
import com.CasaDeShow.repositorio.EventoRepository;
import com.CasaDeShow.service.exceptions.EventoNaoEncontradoException;

@Service
public class EventoService {
	@Autowired
	private EventoRepository eventoRepository;
	public List<Evento> listar(){
		return eventoRepository.findAll();
	}
	public CasaDeShow listarCasas(Long idEvento){
		Evento eventoTemp = buscar(idEvento);
		return eventoTemp.getCasaDeShow();
	}
	public Evento salvar(Evento evento) {
		evento.setIdEvento(null);
		return eventoRepository.save(evento);
	}
	public void editar(Evento evento) {
		Evento eventoTemp = buscar(evento.getIdEvento());
		eventoRepository.save(eventoTemp);
	}
	public void excluir(Long idEvento) {
		Evento evento = buscar(idEvento);
		eventoRepository.deleteById(evento.getIdEvento());
	}
	public Evento buscar(Long idEvento) {
		Evento evento = eventoRepository.getOne(idEvento);
		if(evento!=null) {
			return evento;
		}
		else {
			throw new EventoNaoEncontradoException("Evento não encontrado");
		}
	}
}
