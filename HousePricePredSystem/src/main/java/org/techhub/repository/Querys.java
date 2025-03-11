package org.techhub.repository;


//this class is used to write all queries which is related to database
public class Querys {
	//query to store state in database
	public static String enterState="insert into statemaster values('0',?)";
	
	//query to get all state from database
	public static String getAllStates="select *from statemaster";
	
	//query to search state by name
	public static String getStateByName="select * from statemaster where statename=?";
	
	//query to get state name by state id
	public static String getIdByStateName="select stateid from statemaster where statename=?";
	
	//query to delete state from database by id
	public static String deleteStateById="delete from statemaster where stateid=?";
	
	//query to update state by id
	public static String updateStateName="update statemaster set statename=? where stateid=?";
}
