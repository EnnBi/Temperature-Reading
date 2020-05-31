package com.stie.dailytemp.dao;

import org.springframework.data.repository.CrudRepository;

import com.stie.dailytemp.model.AppUser;
import java.lang.String;

public interface AppUserDao extends CrudRepository<AppUser, Long> {
		
	AppUser findByNRIC(String nric);
	
}
