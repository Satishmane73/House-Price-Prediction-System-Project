package org.techhub.clientapp;

import java.util.*;

import org.techhub.model.StateModel;
import org.techhub.service.*;

//It is a main class of our Project
public class HousePricePredClientApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scr = new Scanner(System.in);
		StateService stateService = new StateServiceImpl();

		do {
			System.out.println("1 : Enter State");
			System.out.println("2 : Display All States");
			System.out.println("9 : Exit");
			System.out.println("Enter your choice");
			int ch = scr.nextInt();
			switch (ch) {
			case 1:
				// In this case we are adding a state in detabase
				System.out.println("Enter New State");
				scr.nextLine();
				String stateName = scr.nextLine();
				String result = stateService.isAddNewState(new StateModel(0, stateName)) ? "State Added Succsessfully"
						: "" + "State Not Added";
				System.out.println(result);

				break;
			case 2:
					List<StateModel> list=stateService.getAllStates(); 
					
					if(list!=null)
					{
						list.forEach((s)->System.out.println(s.getStateId()+"\t"+s.getStateName()));
					}
					else
					{
						System.out.println("There will be nothing to display");
					}
				break;
			case 9:

				System.exit(0);
				break;
			default:

				System.out.println("Wrong input");
				break;
			}
		} while (true);
	}

}
