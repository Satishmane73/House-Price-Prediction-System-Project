package org.techhub.service;

import java.util.List;

import org.techhub.model.StateModel;

public interface StateService {
	public boolean isAddNewState(StateModel model);
	public List<StateModel> getAllStates() ;
	public StateModel getSateByName(String stateName);
	public boolean isDeleteStateById(String stateName);
}
