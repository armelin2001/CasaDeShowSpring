package com.CasaDeShow.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
@Entity
public class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEvento;
	@NotEmpty(message="O evnto deve ter um nome")
	@Size(max=60,message="O evento não pode ter mais de 60 caracteres")
	private String nomeEvento;
	@NotNull(message="O evento deve ter uma capacidade")
	private int capacidade;
	@NotNull(message="Preço obrigatorio")	
	@DecimalMax(value="9999999.99", message="Valor não pode ser maior que 9.999.999,99")
	@DecimalMin(value="0.01", message="Valor não pode ser menor que 0,01")
	@NumberFormat(pattern="#,##0.00")
	private BigDecimal preco;
	@NotNull(message="Escolha uma data")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	@Temporal(TemporalType.DATE)
	private Date data;
	@Enumerated(EnumType.STRING)
	@NotNull(message="Selecione um genero músico")
	private GenerosMusicais generosMusicais;
	@ManyToOne
	@JoinColumn(name="CASADESHOW_ID",nullable=true)
	private CasaDeShow casaDeShow;
	public Long getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}
	public String getNomeEvento() {
		return nomeEvento;
	}
	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public GenerosMusicais getGenerosMusicais() {
		return generosMusicais;
	}
	public void setGenerosMusicais(GenerosMusicais generosMusicais) {
		this.generosMusicais = generosMusicais;
	}
	public CasaDeShow getCasaDeShow() {
		return casaDeShow;
	}
	public void setCasaDeShow(CasaDeShow casaDeShow) {
		this.casaDeShow = casaDeShow;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEvento == null) ? 0 : idEvento.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		if (idEvento == null) {
			if (other.idEvento != null)
				return false;
		} else if (!idEvento.equals(other.idEvento))
			return false;
		return true;
	}
}

 