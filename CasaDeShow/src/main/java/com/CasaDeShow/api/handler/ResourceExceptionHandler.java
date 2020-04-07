package com.CasaDeShow.api.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.CasaDeShow.model.DetalhesErro;
import com.CasaDeShow.service.exceptions.CasaDeShowNaoEncontradaException;
import com.CasaDeShow.service.exceptions.EventoNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(CasaDeShowNaoEncontradaException.class)
	public ResponseEntity<DetalhesErro> handlerCasaDeShowNaoEncontrada(CasaDeShowNaoEncontradaException ex
			, HttpServletRequest request){
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("A casa não foi encontrada");
		erro.setMensagemDesenvolvedor("http://erros.CasaDeShow.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	@ExceptionHandler(EventoNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handlerEventoNaoEncontrado(EventoNaoEncontradoException ex
			, HttpServletRequest request){
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O evento não foi encontrado");
		erro.setMensagemDesenvolvedor("http://erros.CasaDeShow.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
}
