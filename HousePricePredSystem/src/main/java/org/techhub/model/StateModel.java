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

	public String toString() {
		return "[" + stateId + "," + stateName + "]";
	}

	@Override
	public boolean equals(Object obj) {
		StateModel model = (StateModel) obj;
		if (model.getStateId() == this.stateId && model.getStateName().equals(this.stateName)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {

		return stateId * 10000;
	}
}
