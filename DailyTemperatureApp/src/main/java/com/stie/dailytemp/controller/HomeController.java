package com.stie.dailytemp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stie.dailytemp.dao.AppUserDao;
import com.stie.dailytemp.dao.TemperatureDao;
import com.stie.dailytemp.model.AppUser;
import com.stie.dailytemp.model.Temperature;

@RestController
@CrossOrigin
public class HomeController {

	@Autowired
	AppUserDao appUserDao;
	
	 @Autowired
	TemperatureDao tempDao;
	
	 @PostMapping("/temperature")
	 private ResponseEntity<?> saveTemp(@RequestBody Temperature temperature,@RequestAttribute("username") String username) {
		 	AppUser user=appUserDao.findByNRIC(username);
		 	temperature.setAppUser(user);
		 	tempDao.save(temperature);
		 	return ResponseEntity.status(HttpStatus.OK).body(null);
	}
 
}
