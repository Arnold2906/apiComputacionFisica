package com.computacionfisica.api.models.service;

import java.util.List;

import com.computacionfisica.api.models.entity.RegistroCovid;



	public interface IRegistroCovidService {

	public List<RegistroCovid> findAll();
	
	public RegistroCovid save(RegistroCovid registroCovid);
	
	public RegistroCovid findById(Long id);
	
	public void delete(Long id);
	
	public List<Object[]> mostrar(float temperatura);
	
}
