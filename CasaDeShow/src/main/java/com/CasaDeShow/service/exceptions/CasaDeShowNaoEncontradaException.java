package com.CasaDeShow.service.exceptions;

public class CasaDeShowNaoEncontradaException extends RuntimeException{
	public CasaDeShowNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	public CasaDeShowNaoEncontradaException(String mensagem, Throwable erro) {
		super(mensagem,erro);
	}
}
