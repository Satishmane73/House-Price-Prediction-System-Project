package org.techhub.repository;

import java.io.BufferedReader;
import java.io.FileReader;
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

	@Override
	public boolean isUpdateState(String currName, String newName) {
		try {
			int stateId = this.getStateIdByName(currName);
			if (stateId != -1) {
				stmt = conn.prepareStatement(Querys.updateStateName);
				stmt.setString(1, newName);
				stmt.setInt(2, stateId);
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
	public boolean isAssociateDistToState(String stateName, String distName) {
		try 
		{
			cstmt=conn.prepareCall(Querys.callProcedure);
			cstmt.setString(1, stateName);
			cstmt.setString(2, distName);
			boolean b=cstmt.execute();
			return !b;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean addBultDist(String stateName) {
		try
		{
			boolean b=false;
			FileReader fr=new FileReader("D:\\House-Price-Prediction-System-Project\\HousePricePredSystem\\Files\\DistFile.txt");
			BufferedReader br=new BufferedReader(fr);
			String distName;
			while((distName=br.readLine())!=null)
			{
				cstmt=conn.prepareCall(Querys.callProcedure);
				cstmt.setString(1, stateName);
				cstmt.setString(2, distName);
				b=cstmt.execute();
			}
			return !b;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
}
