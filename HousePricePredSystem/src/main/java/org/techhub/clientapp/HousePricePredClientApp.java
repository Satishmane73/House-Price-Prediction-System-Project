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
			System.out.println();
			System.out.println("1 : Enter State");
			System.out.println("2 : Display All States");
			System.out.println("3 : Search State");
			System.out.println("4 : Delete State");
			System.out.println("5 : Update State");
			System.out.println("9 : Exit");
			System.out.println("Enter your choice");
			int ch = scr.nextInt();
			System.out.println();
			
			switch (ch) {
			case 1:
				// In this case we are adding a state in detabase
				System.out.println("Enter New State");
				scr.nextLine();
				String result = stateService.isAddNewState(new StateModel(0, scr.nextLine()))
						? "State Added Succsessfully..."
						: "" + "State Not Added...";
				System.out.println(result);
				break;
			case 2:
				List<StateModel> list = stateService.getAllStates();

				if (list != null) {
					list.forEach((s) -> System.out.println(s.getStateId() + "\t" + s.getStateName()));
				} else {
					System.out.println("There will be nothing to display...");
				}
				break;
			case 3:
				System.out.println("Enter state name to search state");
				scr.nextLine();
				String stateName = scr.nextLine();
				StateModel model = stateService.getSateByName(stateName);
				if (model != null) {
					System.out.println(model.getStateId() + "\t" + model.getStateName());
				} else {
					System.out.println("State Not Found...");
				}
				break;
			case 4:
				System.out.println("Enter state name to delete state");
				scr.nextLine();
				stateName = scr.nextLine();
				boolean b = stateService.isDeleteStateById(stateName);
				if (b) {
					System.out.println("State Deleted Successfully...");
				} else {
					System.out.println("Something Wrong...");
				}
				break;
			case 5:
				System.out.println("Enter State current name");
				scr.nextLine();
				String currName=scr.nextLine();
				
				System.out.println("Enter state new name");
				String newName=scr.nextLine();
				
				b=stateService.isUpdateState(currName, newName);
				if(b)
				{
					System.out.println("State updates Successfully..");
				}
				else
				{
					System.out.println("Something Wrong...");
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
