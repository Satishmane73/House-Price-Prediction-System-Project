package org.techhub.service;

import java.util.List;

import org.techhub.model.StateModel;

import org.techhub.repository.*;

public class StateServiceImpl implements StateService {

	StateRepository stmtRepo = new StateRepositoryImpl();

	@Override
	public boolean isAddNewState(StateModel model) {
		return stmtRepo.isAddNewState(model);
	}

	@Override
	public List<StateModel> getAllStates() {
		return stmtRepo.getAllStates();
	}

	@Override
	public StateModel getSateByName(String stateName) {
		return stmtRepo.getSateByName(stateName);
	}

	@Override
	public boolean isDeleteStateById(String stateName) {
		return stmtRepo.isDeleteState(stateName);
	}

	@Override
	public boolean isUpdateState(String currName, String newName) {
		return stmtRepo.isUpdateState(currName, newName);
	}

	@Override
	public boolean isAssociateDistToState(String stateName, String distName) {
		return stmtRepo.isAssociateDistToState(stateName, distName);
	}

	@Override
	public boolean addBultDist(String stateName) {
		return stmtRepo.addBultDist(stateName);
	}

	@Override
	public int getStateIdByName(String stateName) {
		return stmtRepo.getStateIdByName(stateName);
	}
}
