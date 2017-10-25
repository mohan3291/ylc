package com.ylc.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylc.dao.InMateDao;
import com.ylc.domain.InMate;
import com.ylc.util.YlcUtils;

@Service
public class InMateService {

	@Autowired
	InMateDao inMateDao;
	@Autowired
	private CustomerLineService customerLineService;

	public void saveInMate(com.ylc.model.InMate inMate)
			throws IllegalAccessException, InvocationTargetException {

		inMateDao.saveInMate(YlcUtils.copy(inMate));
	}

	public List<com.ylc.model.InMate> getInmateByByFirstAndLastName(
			com.ylc.model.InMate inmate) {
		List<InMate> inmates = inMateDao.getInmateByByFirstAndLastName(YlcUtils
				.copy(inmate));
		return copyDomainToModelList(inmates);
	}

	public List<com.ylc.model.InMate> getInmateForCustomer(
			com.ylc.model.Customer customer) {
		Set<Integer> inMateSet = new HashSet<Integer>();
		Map<Integer, com.ylc.model.InMate> inMateMap = new HashMap<Integer, com.ylc.model.InMate>();
		List<com.ylc.model.CustomerLine> customerLines = customerLineService
				.getCustomerLineByCustomer(customer);
		for (com.ylc.model.CustomerLine custLine : customerLines) {
			inMateSet.add(custLine.getInMate().getInmateID());
			inMateMap.put(custLine.getInMate().getInmateID(),
					custLine.getInMate());
		}
		List<com.ylc.model.InMate> returnList = new ArrayList<com.ylc.model.InMate>();
		for (Integer inMateID : inMateSet)
			returnList.add(inMateMap.get(inMateID));

		return returnList;
	}

	public List<com.ylc.model.InMate> getInmateByCode(
			com.ylc.model.InMate inmate) {
		List<InMate> inmates = inMateDao.getInmateByCode(YlcUtils.copy(inmate));
		return copyDomainToModelList(inmates);
	}

	public List<com.ylc.model.InMate> getInmateByBOP(com.ylc.model.InMate inmate) {
		List<InMate> inmates = inMateDao.getInmateByBOP(YlcUtils.copy(inmate));
		return copyDomainToModelList(inmates);
	}

	private List<com.ylc.model.InMate> copyDomainToModelList(
			List<InMate> inmates) {
		List<com.ylc.model.InMate> inmatesM = new ArrayList<com.ylc.model.InMate>();
		for (InMate inmate : inmates) {
			inmatesM.add(YlcUtils.copy(inmate));
		}
		return inmatesM;

	}

}
