package com.stie.dailytemp.customdao;

import java.util.List;

import com.stie.dailytemp.model.Search;
import com.stie.dailytemp.model.Temperature;

public interface TemperatureCustom {
	
	List<Temperature> getTemperaturesOnSearch(Search search);
}
