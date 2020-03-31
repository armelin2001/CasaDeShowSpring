package com.CasaDeShow.model;

public enum GenerosMusicais {
	AXE("Axé"),
	ELETRONICA("Eletronica"),
	FUNK("Funk"),
	ROCK("Rock"),
	POP("Pop"),
	FORO("Foró");
	private String genero;
	GenerosMusicais(String genero){
		this.genero = genero;
	}
	public String getGenero() {
		return genero;
	}
}
