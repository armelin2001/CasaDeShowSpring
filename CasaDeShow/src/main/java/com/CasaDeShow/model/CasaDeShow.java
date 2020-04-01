package com.CasaDeShow.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class CasaDeShow {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCasaDeShow;
	@NotEmpty(message="A casa de show deve ter um nome")
	@Size(max=60,message="A casa de show não pode ter mais de 60 caracteres")
	private String nomeCasa;
	@NotEmpty(message="A casa de show deve ter uma endereço")
	@Size(max=60,message="A casa de show não pode ter mais de 60 caracteries")
	private String endereco;
	public Long getIdCasaDeShow() {
		return idCasaDeShow;
	}
	public void setIdCasaDeShow(Long idCasaDeShow) {
		this.idCasaDeShow = idCasaDeShow;
	}
	public String getNomeCasa() {
		return nomeCasa;
	}
	public void setNomeCasa(String nomeCasa) {
		this.nomeCasa = nomeCasa;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
