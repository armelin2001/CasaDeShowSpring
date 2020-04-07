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
import com.CasaDeShow.service.CasaDeShowService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(tags="Casas de show")
@RestController
@RequestMapping("/api/casaDeShow")
public class CasaDeShowResources {
	@Autowired
	private CasaDeShowService casaDeShowService;
	@ApiOperation("Lista todas as casa de show registrada")
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CasaDeShow>> listar(){
		List<CasaDeShow> casasDeShow = casaDeShowService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(casasDeShow);
	}
	@ApiOperation("Busca uma casa de show pelo id")
	@RequestMapping(value="/{idCasaDeShow}",method=RequestMethod.GET)
	public ResponseEntity<?> buscar(@Valid @PathVariable("idCasaDeShow") Long idCasaDeShow){
		CasaDeShow casaDeShow = casaDeShowService.buscar(idCasaDeShow);
		return ResponseEntity.status(HttpStatus.OK).body(casaDeShow);
	}
	@ApiOperation("Cria novas casas de show")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> salvar(@Valid @RequestBody CasaDeShow casaDeShow){
		casaDeShow = casaDeShowService.salvar(casaDeShow);
		URI	uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/idCasaDeShow}").buildAndExpand(casaDeShow.getIdCasaDeShow()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@ApiOperation("Deleta uma casa pelo id")
	@RequestMapping(value="/{idCasaDeShow}", method=RequestMethod.DELETE)
	public ResponseEntity<Void>deletar(@PathVariable("idCasaDeShow") Long idCasaDeShow){
		casaDeShowService.excluir(idCasaDeShow);
		return ResponseEntity.noContent().build();
	}
	@ApiOperation("Edita uma casa de shwo pelo id")
	@RequestMapping(value="/{idCasaDeShow}", method=RequestMethod.PUT)
	public ResponseEntity<Void>editar(@RequestBody CasaDeShow casaDeShow,@PathVariable("idCasaDeShow") Long idCasaDeShow){
		casaDeShow.setIdCasaDeShow(idCasaDeShow);
		casaDeShowService.editar(casaDeShow);
		return ResponseEntity.noContent().build();
	}
}
