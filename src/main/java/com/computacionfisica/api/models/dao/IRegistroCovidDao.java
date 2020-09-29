package com.computacionfisica.api.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.computacionfisica.api.models.entity.RegistroCovid;



public interface IRegistroCovidDao extends CrudRepository<RegistroCovid, Long> {

	@Query(value = "call guardar_temperatura( :temperatura)", nativeQuery = true)
	public List<Object[]> mostrar(@Param("temperatura") float temperatura);
	
}
