package org.techhub.repository;

import java.util.List;

import org.techhub.model.DistModel;

public interface DistRepository {
	public DistModel getDistByName(String distName);

	public int getDistIdByName(String distName);

	public boolean updateDistName(String currName, String newName);

	public boolean deleteDist(String distName);

	public List<DistModel> getDistByStateName(String stateName);
}
