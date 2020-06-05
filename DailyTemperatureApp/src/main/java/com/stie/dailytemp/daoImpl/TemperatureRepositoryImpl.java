package com.stie.dailytemp.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.stie.dailytemp.customdao.TemperatureCustom;
import com.stie.dailytemp.model.Search;
import com.stie.dailytemp.model.Temperature;
import com.stie.dailytemp.util.Constants;

@Repository
public class TemperatureRepositoryImpl implements TemperatureCustom {

	@PersistenceContext
	EntityManager em;
	
	
	@Override
	public List<Temperature> getTemperaturesOnSearch(Search search) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Temperature> cq = cb.createQuery(Temperature.class);
		Root<Temperature> root =cq.from(Temperature.class);
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		if(search.getShift()!=null){
			if(!search.getShift().isEmpty())
				predicates.add(cb.equal(root.get("shift"),search.getShift().trim()));
		}
		
		if(search.getGroupBy()!=null){
			if(search.getGroupBy().equals(Constants.GREATER_THAN_38)){
				Predicate and1 = cb.greaterThan(root.get("reading"),38);
				Predicate or1 = cb.equal(root.get("noReading"),Constants.DEC_GREATER_THAN_38);
				
				Predicate grpBy = cb.or(and1,or1);
				predicates.add(grpBy);
			}
			else if(search.getGroupBy().equals(Constants.LESS_THAN_38)){
				Predicate and1 = cb.lessThanOrEqualTo(root.get("reading"),38);
				Predicate or1 = cb.equal(root.get("noReading"),Constants.DEC_LESS_THAN_38);
				
				Predicate grpBy = cb.or(and1,or1);
				predicates.add(grpBy);
				 
			}
		}
		
		if(search.getStartDate()!=null){
			predicates.add(cb.greaterThanOrEqualTo(root.get("date"),search.getStartDate()));
		}
		
		if(search.getEndDate()!=null){
			predicates.add(cb.lessThanOrEqualTo(root.get("date"),search.getEndDate()));
		}
		cq.select(root).where(cb.and(predicates.toArray(new Predicate[] {})));
		cq.distinct(true);
		
		return em.createQuery(cq).getResultList();
	}

}
