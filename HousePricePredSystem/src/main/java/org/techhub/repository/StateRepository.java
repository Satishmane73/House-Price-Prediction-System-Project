package org.techhub.repository;

import java.util.*;

import org.techhub.model.StateModel;

public interface StateRepository {
	public boolean isAddNewState(StateModel model);
	public List <StateModel> getAllStates(); 
	public StateModel getSateByName(String stateName);
	public boolean isDeleteState(String stateName);
	public int getStateIdByName(String stateName);
}
