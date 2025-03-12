package org.techhub.service;

import org.techhub.model.DistModel;

public interface DistServices {
	public DistModel getDistByName(String distName);
	public boolean updateDistName(String currName,String newName);
	public boolean deleteDist(String distName);
}
