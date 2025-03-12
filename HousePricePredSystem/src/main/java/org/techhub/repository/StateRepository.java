package org.techhub.repository;

import java.util.*;

import org.techhub.model.StateModel;

public interface StateRepository {
	public boolean isAddNewState(StateModel model);
	public List <StateModel> getAllStates(); 
	public int getStateIdByName(String stateName);
	public StateModel getSateByName(String stateName);
	public boolean isDeleteState(String stateName);
	public boolean isUpdateState(String currName, String newName);
	public boolean isAssociateDistToState(String stateName,String distName);
	public boolean addBultDist(String stateName);
}
