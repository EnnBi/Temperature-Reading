package com.stie.dailytemp.dao;

import org.springframework.data.repository.CrudRepository;

import com.stie.dailytemp.model.Temperature;

public interface TemperatureDao extends CrudRepository<Temperature, Long> {
		
}
