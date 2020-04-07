package com.CasaDeShow.api.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.CasaDeShow.model.CasaDeShow;
import com.CasaDeShow.model.Evento;
import com.CasaDeShow.service.EventoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(tags="Eventos")
@RestController
@RequestMapping("/api/evento")
public class EventoRecources {
	@Autowired 
	private EventoService eventoService;
	@ApiOperation("Lista todos os eventos")
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Evento>> listar(){
		List<Evento> eventos = eventoService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(eventos);
	}
	@ApiOperation("Busca evento pelo id")
	@RequestMapping(value="/{idEvento}")
	public ResponseEntity<?> buscar(@Valid @PathVariable("idEvento") Long idEvento){
		Evento evento = eventoService.buscar(idEvento);
		return ResponseEntity.status(HttpStatus.OK).body(evento);
	}
	@ApiOperation("Cria um evento")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?>salvar(@Valid @RequestBody Evento evento){
		evento = eventoService.salvar(evento);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{idEvento}")
				.buildAndExpand(evento.getIdEvento()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@ApiOperation("Deleta um evento pelo id")
	@RequestMapping(value="/{idEvento}",method=RequestMethod.DELETE)
	public ResponseEntity<Void>deletar(@PathVariable("idEvento") Long idEvento){
		eventoService.excluir(idEvento);
		return ResponseEntity.noContent().build();
	}
	@ApiOperation("Edita um evento")
	@RequestMapping(value="/{idEvento}",method=RequestMethod.PUT)
	public ResponseEntity<Void>editar(@RequestBody Evento evento,@PathVariable("idEvento") Long idEvento){
		evento.setIdEvento(idEvento);
		eventoService.editar(evento);
		return ResponseEntity.noContent().build();
	}
	@ApiOperation("Lista a casa de show que esta vinculada ao evento")
	@RequestMapping(value="/{idEvento}/casaDeShow",method=RequestMethod.GET)
	public ResponseEntity<CasaDeShow> listarCasas(@PathVariable("idEvento")Long idEvento){
		CasaDeShow casaTemp = eventoService.listarCasas(idEvento);
		return ResponseEntity.status(HttpStatus.OK).body(casaTemp);
	}


}