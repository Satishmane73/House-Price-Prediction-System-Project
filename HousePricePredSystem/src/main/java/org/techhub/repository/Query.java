package org.techhub.repository;

//this class is used to write all queries which is related to database
public class Query {
	// query to store state in database
	public static String enterState = "insert into statemaster values('0',?)";

	// query to get all state from database
	public static String getAllStates = "select *from statemaster";

	// query to search state by name
	public static String getStateByName = "select * from statemaster where statename=?";

	// query to get state name by state id
	public static String getIdByStateName = "select stateid from statemaster where statename=?";

	// query to delete state from database by id
	public static String deleteStateById = "delete from statemaster where stateid=?";

	// query to update state by id
	public static String updateStateName = "update statemaster set statename=? where stateid=?";

	// query to call procedure to store dist dist table and statedist join in
	// database
	public static String callProcedureOfDist = "call saveDist(?,?)";

	// query to get dist by distname
	public static String getDistByName = "select *from distmaster where distname=?";

	// query to get distid by dist name
	public static String getDistIdByName = "select distid from distmaster where distname=?";

	// query to update dist name
	public static String updateDistName = "update distmaster set distname=? where distid=?";

	// query to delete dist
	public static String deleteDist = "delete from distmaster where distid=?";

	// Qery to get all dist's by state name
	public static String getDistByStateName = "select d.distid,d.distname from distmaster d inner join statedistjoin stj on d.distid=stj.distid inner join statemaster sm on sm.stateid=stj.stateid where sm.statename=?";

	// query to call procedure to store city in citymaster and city id ,dist id
	// ,state id in citidistjoin table
	public static String callProcedureOfCity = "call savecity(?,?,?)";
}
