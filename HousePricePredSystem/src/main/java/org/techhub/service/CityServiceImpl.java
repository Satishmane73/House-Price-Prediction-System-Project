package org.techhub.service;

import org.techhub.model.CityModel;
import org.techhub.repository.CityRepository;
import org.techhub.repository.CityRepositoryImpl;

public class CityServiceImpl implements CityService {

	CityRepository cityRepo=new CityRepositoryImpl();
	
	
	@Override
	public boolean isAddNewCity(CityModel model) {
		return cityRepo.isAddNewCity(model);
	}
}
