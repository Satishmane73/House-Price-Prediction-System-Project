package org.techhub.repository;

import java.sql.SQLException;

import org.techhub.model.CityModel;

public class CityRepositoryImpl extends DBState implements CityRepository {

	@Override
	public boolean isAddNewCity(CityModel model) {
		try {
			cstmt = conn.prepareCall(Query.callProcedureOfCity);
			cstmt.setString(1, model.getCityName());
			cstmt.setInt(2, model.getStateId());
			cstmt.setInt(3, model.getDistId());
			boolean b = cstmt.execute();
			return !b;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int getCityIdByCityName(String cityName, int stateId, int distId) {
		try {
			stmt = conn.prepareStatement(Query.getCityIdByCityName);
			stmt.setString(1, cityName);
			stmt.setInt(2, stateId);
			stmt.setInt(3, distId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
}
