package com.CasaDeShow.service.exceptions;

public class EventoNaoEncontradoException extends RuntimeException{
	public EventoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	public EventoNaoEncontradoException(String mensagem, Throwable erro) {
		super(mensagem,erro);
	}
}
