package com.computacionfisica.api.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computacionfisica.api.models.dao.IRegistroCovidDao;
import com.computacionfisica.api.models.entity.RegistroCovid;

@Service
public class RegistroCovidServiceImpl implements IRegistroCovidService {

	@Autowired
	private IRegistroCovidDao registroCovidDao;
	
	@Override
	public List<RegistroCovid> findAll() {
		// TODO Auto-generated method stub
		return (List<RegistroCovid>)registroCovidDao.findAll();
	}

	@Override
	public RegistroCovid save(RegistroCovid registroCovid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegistroCovid findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Object[]> mostrar(float temperatura) {
		// TODO Auto-generated method stub
		return registroCovidDao.mostrar(temperatura);
	}

	@Override
	public List<Object[]> registrarHorario(String codigo, String fecha, String hora) {
		// TODO Auto-generated method stub
		return registroCovidDao.registrarHorario(codigo, fecha, hora);
	}

}
