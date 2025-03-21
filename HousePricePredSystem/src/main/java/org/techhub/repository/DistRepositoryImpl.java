package org.techhub.repository;

import java.sql.SQLException;
import java.util.*;

import org.techhub.customeException.StateException;
import org.techhub.model.DistModel;

public class DistRepositoryImpl extends DBState implements DistRepository {

	List<DistModel> distList = new ArrayList<DistModel>();

	@Override
	public DistModel getDistByName(String distName) {
		try {
			stmt = conn.prepareStatement(Query.getDistByName);
			stmt.setString(1, distName);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return new DistModel(rs.getInt(1), rs.getString(2));
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getDistIdByName(String distName) {
		try {
			stmt = conn.prepareStatement(Query.getDistIdByName);
			stmt.setString(1, distName);
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
	public boolean updateDistName(String currName, String newName) {
		try {
			int distId = this.getDistIdByName(currName);
			if (distId != -1) {
				stmt = conn.prepareStatement(Query.updateDistName);
				stmt.setString(1, newName);
				stmt.setInt(2, distId);
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
	public boolean deleteDist(String distName) {
		try {
			int distId = this.getDistIdByName(distName);
			if (distId != -1) {
				stmt = conn.prepareStatement(Query.deleteDist);
				stmt.setInt(1, distId);
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
	public List<DistModel> getDistByStateName(String stateName) {
		try {
			stmt = conn.prepareStatement(Query.getDistByStateName);
			stmt.setString(1, stateName);
			rs = stmt.executeQuery();
			while (rs.next()) {
				DistModel model = new DistModel(rs.getInt(1), rs.getString(2));
				this.distList.add(model);
			}
			if (this.distList.size() > 0) {
				return distList;
			} else {
				throw new StateException("State Not Found " + stateName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (StateException se) {
			se.printStackTrace();
			return null;
		}

	}
}
