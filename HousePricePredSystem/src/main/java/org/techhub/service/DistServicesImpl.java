package org.techhub.service;

import java.util.List;

import org.techhub.model.DistModel;
import org.techhub.repository.*;

public class DistServicesImpl implements DistServices {
	DistRepository distRepo = new DistRepositoryImpl();

	@Override
	public DistModel getDistByName(String distName) {
		return distRepo.getDistByName(distName);
	}

	@Override
	public boolean updateDistName(String currName, String newName) {
		return distRepo.updateDistName(currName, newName);
	}

	@Override
	public boolean deleteDist(String distName) {
		return distRepo.deleteDist(distName);
	}

	@Override
	public List<DistModel> getDistByStateName(String stateName) {
		return distRepo.getDistByStateName(stateName);
	}

	@Override
	public int getDistIdByName(String distName) {
		// TODO Auto-generated method stub
		return distRepo.getDistIdByName(distName);
	}
}
