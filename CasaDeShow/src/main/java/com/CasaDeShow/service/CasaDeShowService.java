package com.CasaDeShow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CasaDeShow.model.CasaDeShow;
import com.CasaDeShow.repositorio.CasaDeShowRepository;
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
	public void editar(CasaDeShow casaDeShow){
		CasaDeShow casaTemp = buscar(casaDeShow.getIdCasaDeShow());
		casaDeShowRepository.save(casaTemp);
	}
	public void excluir(Long idcasaDeShow) {
		CasaDeShow casaTemp = buscar(idcasaDeShow);
		casaDeShowRepository.deleteById(casaTemp.getIdCasaDeShow());
	}
	public CasaDeShow buscar(Long idCasaDeShow){
		CasaDeShow casaTemp = casaDeShowRepository.getOne(idCasaDeShow);
		if(casaTemp!=null) {
			return casaTemp;
		}
		else {
			throw new CasaDeShowNaoEncontradaException("Casa de show não encontrada");
		}
	}
}