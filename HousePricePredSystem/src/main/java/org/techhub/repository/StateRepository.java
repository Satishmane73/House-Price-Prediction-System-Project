package org.techhub.repository;

import java.util.*;

import org.techhub.model.StateModel;

public interface StateRepository {
	public boolean isAddNewState(StateModel model);
	public List <StateModel> getAllStates(); 
}
