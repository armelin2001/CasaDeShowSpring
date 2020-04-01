package com.CasaDeShow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CasaDeShow.model.CasaDeShow;
import com.CasaDeShow.repositorio.CasaDeShowRepository;
import com.CasaDeShow.service.exceptions.CasaDeShowEncontradaException;
import com.CasaDeShow.service.exceptions.CasaDeShowNaoEncontradaException;
@Service
public class CasaDeShowService {
	@Autowired
	private CasaDeShowRepository casaDeShowRepository; 
	public List<CasaDeShow> listar(){
		return casaDeShowRepository.findAll();
	}
	public CasaDeShow salvar(CasaDeShow casaDeShow) {
		casaDeShow.setIdCasaDeShow(null);
		return casaDeShowRepository.save(casaDeShow);
	}
	public void excluir(Long idcasaDeShow) {
		if(casaDeShowRepository.getOne(idcasaDeShow)!=null) {
			casaDeShowRepository.deleteById(idcasaDeShow);
		}
		else {
			throw new CasaDeShowNaoEncontradaException("Não foi encontrada uma casa de show para deleção");
		}
	}
	public CasaDeShow buscar(Long idCasaDeShow){
		CasaDeShow casa = casaDeShowRepository.getOne(idCasaDeShow);
		if(casa!=null) {
			return casa;
		}
		else {
			throw new CasaDeShowNaoEncontradaException("Casa de show não encontrada");
		}
	}
}
