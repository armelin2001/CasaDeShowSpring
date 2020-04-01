package com.CasaDeShow.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CasaDeShow.model.Evento;
import com.CasaDeShow.repositorio.EventoRepository;
import com.CasaDeShow.service.exceptions.EventoNaoEncontradoException;

@Service
public class EventoService {
	private EventoRepository eventoRepository;
	public List<Evento> listar(){
		return eventoRepository.findAll();
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
}
