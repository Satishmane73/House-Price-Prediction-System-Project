package org.techhub.service;

import org.techhub.model.CityModel;

public interface CityService {
	public boolean isAddNewCity(CityModel model);

	public int getCityIdByCityName(String cityName, int stateId, int distId);
}
