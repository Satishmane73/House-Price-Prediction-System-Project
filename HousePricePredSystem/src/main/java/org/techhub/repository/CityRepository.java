package org.techhub.repository;

import org.techhub.model.CityModel;

public interface CityRepository {
	public boolean isAddNewCity(CityModel model);

	public int getCityIdByCityName(String cityName, int stateId, int distId);
}
