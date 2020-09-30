package com.computacionfisica.api.models.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.computacionfisica.api.models.entity.RegistroCovid;



	public interface IRegistroCovidService {

	public List<RegistroCovid> findAll();
	
	public RegistroCovid save(RegistroCovid registroCovid);
	
	public RegistroCovid findById(Long id);
	
	public void delete(Long id);
	
	public List<Object[]> mostrar(float temperatura);
	
	public List<Object[]> registrarHorario(String codigo, String fecha, String hora);
	
}
