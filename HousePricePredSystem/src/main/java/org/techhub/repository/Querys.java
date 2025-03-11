package org.techhub.repository;

public class Querys {
	public static String enterState="insert into statemaster values('0',?)";
	public static String getAllStates="select *from statemaster";
	public static String getStateByName="select * from statemaster where statename=?";
	public static String getIdByStateName="select stateid from statemaster where statename=?";
	public static String deleteStateById="delete from statemaster where stateid=?";
}
