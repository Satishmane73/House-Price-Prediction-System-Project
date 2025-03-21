package org.techhub.model;

public class CityModel extends DistModel {
	private int CityId;
	private String CityName;

	public CityModel() {

	}

	public CityModel(int CityId, String CityName) {
		this.CityId = CityId;
		this.CityName = CityName;
	}

	public void setCityId(int id) {
		this.CityId = id;
	}

	public int getCityId() {
		return CityId;
	}

	public void setCityName(String cityName) {
		this.CityName = cityName;
	}

	public String getCityName() {
		return CityName;
	}
}
