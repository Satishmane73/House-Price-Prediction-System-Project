package org.techhub.repository;

import org.techhub.model.StateModel;

public class StateRepositoryImpl extends DBState implements StateRepository {

	@Override
	public boolean isAddNewState(StateModel model) {
		try {
			stmt = conn.prepareStatement("insert into statemaster values('0',?)");
			stmt.setString(1, model.getStateName());
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
