package org.techhub.service;

import java.util.List;

import org.techhub.model.DistModel;

public interface DistServices {
	public DistModel getDistByName(String distName);

	public boolean updateDistName(String currName, String newName);

	public boolean deleteDist(String distName);

	public List<DistModel> getDistByStateName(String stateName);

	public int getDistIdByName(String distName);
}
