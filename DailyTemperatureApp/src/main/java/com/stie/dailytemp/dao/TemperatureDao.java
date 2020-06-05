package com.stie.dailytemp.dao;

import org.springframework.data.repository.CrudRepository;

import com.stie.dailytemp.customdao.TemperatureCustom;
import com.stie.dailytemp.model.Temperature;

public interface TemperatureDao extends CrudRepository<Temperature, Long>{
		
/*	@Query("Select t from Temperature t where t.date between :startDate and :endDate GROUP BY t.shift ")
	List<Temperature> findAllGroupByShift(@Param("startDate") LocalDate startDate,@Param("endDate") LocalDate endDate);
	
	//@Query("Select t from Temperature t where t.date between :startDate and :endDate and CAST(t.reading as DECIMAL(9,2)) >= :temp  or t.reading= :reading ")
	@Query(value="SELECT * FROM temperature AS t where t.date BETWEEN :startDate AND :endDate AND (CAST(t.reading as DECIMAL(9,2)) >= :temp   OR t.reading = :reading) ",nativeQuery=true)
	List<Temperature> findAllGreaterThanGivenTemp(@Param("startDate") LocalDate startDate,@Param("endDate") LocalDate endDate,
													@Param("temp") int temp,@Param("reading") String reading);
	
	//@Query("Select t from Temperature t where t.date between :startDate and :endDate and ((CAST(t.reading as DECIMAL(9,2)) <= :temp AND CAST(t.reading as DECIMAL(9,2)) >= 0) or t.reading= :reading) ")
	@Query(value="SELECT * FROM temperature AS t where t.date BETWEEN :startDate AND :endDate AND ((CAST(t.reading as DECIMAL(9,2)) <= :temp AND CAST(t.reading as DECIMAL(9,2)) > 0)  OR t.reading = :reading) ",nativeQuery=true)
	List<Temperature> findAllLessThanGivenTemp(@Param("startDate") LocalDate startDate,@Param("endDate") LocalDate endDate,
													@Param("temp") int temp,@Param("reading") String reading);
	*/
}
 