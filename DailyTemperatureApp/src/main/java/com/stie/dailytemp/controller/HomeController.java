package com.stie.dailytemp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.stie.dailytemp.customdao.TemperatureCustom;
import com.stie.dailytemp.dao.AppUserDao;
import com.stie.dailytemp.dao.TemperatureDao;
import com.stie.dailytemp.model.AppUser;
import com.stie.dailytemp.model.Search;
import com.stie.dailytemp.model.Temperature;

@RestController
@CrossOrigin
public class HomeController {

	@Autowired
	AppUserDao appUserDao;
	
	 @Autowired
	TemperatureDao tempDao;
	 
	 @Autowired
		TemperatureCustom tempCustomDao;
	 
	 @GetMapping("/dashboard")
	 public ModelAndView home(ModelAndView mv){
		  mv.setViewName("dashboard");
		 return mv;
	 }
	
	 @PostMapping("/temperature")
	 private ResponseEntity<?> saveTemp(@RequestBody Temperature temperature,@RequestAttribute("username") String username) {
		 	AppUser user=appUserDao.findByNRIC(username);
		 	temperature.setAppUser(user);
		 	tempDao.save(temperature);
		 	return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	 
	 
	 
	@PostMapping("/temperatures")
	private ResponseEntity<?> getAll(@RequestBody Search search){
		List<Temperature> temps = tempCustomDao.getTemperaturesOnSearch(search);
			return ResponseEntity.status(HttpStatus.OK).body(temps);
	}
	 
	@ExceptionHandler
	public void Exception(Exception e){
		e.printStackTrace();
	}
	
}
