package org.techhub.model;

public class DistModel {
	private int distId;
	private String distName;

	public DistModel() {

	}

	public DistModel(int distId, String distName) {
		this.distId = distId;
		this.distName = distName;
	}

	public int getDistId() {
		return distId;
	}

	public String getDistName() {
		return distName;
	}

	@Override
	public String toString() {
		return "[" + this.distId + "," + this.distName + "]";
	}

	@Override
	public boolean equals(Object obj) {
		DistModel model = (DistModel) obj;
		if (model.getDistId() == this.distId && model.getDistName().equals(this.distName)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return distId * 1000;
	}
}
