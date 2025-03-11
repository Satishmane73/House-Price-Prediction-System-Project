package org.techhub.repository;

import java.util.*;

import org.techhub.model.StateModel;

public class StateRepositoryImpl extends DBState implements StateRepository {

	List<StateModel> list;

	// this method used to store state in database
	@Override
	public boolean isAddNewState(StateModel model) {
		try {
			stmt = conn.prepareStatement(Querys.enterState);
			stmt.setString(1, model.getStateName());
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// this method used to fetch all states from database
	// we are use List Collection to fetch data and this data is only of type
	// statemodel
	@Override
	public List<StateModel> getAllStates() {
		list = new ArrayList<StateModel>();
		try {
			stmt = conn.prepareStatement(Querys.getAllStates);
			rs = stmt.executeQuery();
			while (rs.next()) {
				StateModel model = new StateModel(rs.getInt(1), rs.getString(2));
				list.add(model);
			}
			return list.size() > 0 ? list : null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public StateModel getSateByName(String stateName) {
		try {
			stmt = conn.prepareStatement(Querys.getStateByName);
			stmt.setString(1, stateName);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return new StateModel(rs.getInt(1), rs.getString(2));
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean isDeleteState(String stateName) {
		try {
			int stateId = this.getStateIdByName(stateName);
			if (stateId != -1) {
				stmt = conn.prepareStatement(Querys.deleteStateById);
				stmt.setInt(1, stateId);

				int value = stmt.executeUpdate();

				return value > 0 ? true : false;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int getStateIdByName(String stateName) {

		try {
			stmt = conn.prepareStatement(Querys.getIdByStateName);
			stmt.setString(1, stateName);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
