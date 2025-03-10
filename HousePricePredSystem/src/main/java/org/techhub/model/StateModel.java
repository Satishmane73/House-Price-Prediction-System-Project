package org.techhub.model;

public class StateModel {
	private int stateId;
	private String stateName;

	public StateModel() {

	}

	public StateModel(int stateId, String stateName) {
		this.stateId = stateId;
		this.stateName = stateName;
	}

	public int getStateId() {
		return stateId;
	}

	public String getStateName() {
		return stateName;
	}
}
