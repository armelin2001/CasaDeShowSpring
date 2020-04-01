package com.CasaDeShow.service.exceptions;

public class CasaDeShowEncontradaException extends RuntimeException{
	public CasaDeShowEncontradaException(String mensagem) {
		super(mensagem);
	}
	public CasaDeShowEncontradaException(String mensagem, Throwable erro) {
		super(mensagem,erro);
	}
}
