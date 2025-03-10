package org.techhub.service;

import org.techhub.model.StateModel;

import org.techhub.repository.*;

public class StateServiceImpl implements StateService {

	StateRepository stateRepo = new StateRepositoryImpl();

	@Override
	public boolean isAddNewState(StateModel model) {

		return stateRepo.isAddNewState(model);
	}

}
