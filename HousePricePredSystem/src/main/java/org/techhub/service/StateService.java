package org.techhub.service;

import java.util.List;

import org.techhub.model.StateModel;

public interface StateService {
	public boolean isAddNewState(StateModel model);

	public List<StateModel> getAllStates();

	public StateModel getSateByName(String stateName);

	public boolean isDeleteStateById(String stateName);

	public boolean isUpdateState(String currName, String newName);

	public boolean isAssociateDistToState(String stateName, String distName);

	public boolean addBultDist(String stateName);

	public int getStateIdByName(String stateName);
}
