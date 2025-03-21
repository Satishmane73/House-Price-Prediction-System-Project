package org.techhub.clientapp;

import java.util.*;

import org.techhub.model.CityModel;
import org.techhub.model.DistModel;
import org.techhub.model.StateModel;
import org.techhub.service.*;
import org.techhub.repository.*;

//It is a main class of our Project
public class HousePricePredClientApp {
	static int count = 0;

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scr = new Scanner(System.in);
		StateService stateService = new StateServiceImpl();
		CityService cityService = new CityServiceImpl();
		do {
			System.out.println();
			System.out.println("1 : Enter State");
			System.out.println("2 : Display All States");
			System.out.println("3 : Search State");
			System.out.println("4 : Delete State");
			System.out.println("5 : Update State");
			System.out.println("6 : Add single district in state");
			System.out.println("7 : Add more than one districts in state");
			System.out.println("8 : Search,Update, delete district");
			System.out.println("9 : Enter City");
			System.out.println("10 : Exit");
			System.out.println("Enter your choice");
			int ch = scr.nextInt();
			System.out.println();

			switch (ch) {
			case 1:
				// In this case we are adding a state in detabase
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
				String currName = scr.nextLine();

				System.out.println("Enter state new name");
				String newName = scr.nextLine();

				b = stateService.isUpdateState(currName, newName);
				if (b) {
					System.out.println("State updates Successfully..");
				} else {
					System.out.println("Something Wrong...");
				}

				break;
			case 6:
				System.out.println("Enter State name");
				scr.nextLine();
				stateName = scr.nextLine();

				System.out.println("Enter dist name");
				String distname = scr.nextLine();

				b = stateService.isAssociateDistToState(stateName, distname);
				if (b) {
					System.out.println("District added in state Successfully...");
				} else {
					System.out.println("Something Wrong...");
				}
				break;
			case 7:
				System.out.println("Enter state name");
				scr.nextLine();
				stateName = scr.nextLine();
				b = stateService.addBultDist(stateName);
				if (b) {
					System.out.println("Districts added successfully...");
				} else {
					System.out.println("Something Wrong...");
				}
				break;
			case 8:
				int choice;
				DistServices distService = new DistServicesImpl();
				boolean flag = true;
				do {
					System.out.println();
					System.out.println("1 : Search dist by name");
					System.out.println("2 : Update dist");
					System.out.println("3 : Delete dist");
					System.out.println("9 : Exit");
					System.out.println("Enter your choice");
					choice = scr.nextInt();
					System.out.println();
					switch (choice) {
					case 1:
						System.out.println("Enter dist name to search dist");
						scr.nextLine();
						String distName = scr.nextLine();
						DistModel distModel = distService.getDistByName(distName);
						if (distModel != null) {
							System.out.println(distModel.getDistId() + "\t" + distModel.getDistName());
						} else {
							System.out.println("District Not Found...");
						}
						break;
					case 2:
						System.out.println("Enter current district name");
						scr.nextLine();
						currName = scr.nextLine();
						System.out.println("Enter new District Name");
						newName = scr.nextLine();
						b = distService.updateDistName(currName, newName);
						if (b) {
							System.out.println("Dist name updated Successfully...");
						} else {
							System.out.println("Something wrong...");
						}
						break;

					case 3:
						System.out.println("Enter district name to delete district");
						scr.nextLine();
						distName = scr.nextLine();
						b = distService.deleteDist(distName);
						if (b) {
							System.out.println("Dist Deleted successfully");
						} else {
							System.out.println("Something wrong");
						}
						break;

					case 9:
						flag = false;
						break;
					default:
						System.out.println("Wrong Input");
						break;
					}
				} while (flag);
				break;
			case 9:
				list = stateService.getAllStates();

				if (list != null) {
					DistServices distServices = new DistServicesImpl();
					count = 0;
					list.forEach((s) -> System.out.println((++count) + "\t" + s.getStateName()));
					System.out.println("Enter State Name to add city in that state");
					scr.nextLine();
					stateName = scr.nextLine();
					System.out.println("District Names");
					System.out.println("-------------------------");
					List<DistModel> distList = distServices.getDistByStateName(stateName);
					if (distList != null) {
						distList.forEach((dist) -> System.out.println(dist.getDistId() + "\t" + dist.getDistName()));
						System.out.println("Enter Dist name in which city want to add");
						String distName = scr.nextLine();
						int stateId = stateService.getStateIdByName(stateName);
						int distId = distServices.getDistIdByName(distName);

						System.out.println("Enter City Name");
						String cityName = scr.nextLine();

						CityModel cityModel = new CityModel();

						cityModel.setDistId(distId);
						cityModel.setStateId(stateId);
						cityModel.setCityName(cityName);
						b = cityService.isAddNewCity(cityModel);
						if (b) {
							System.out.println("City Added Successfully...");
						} else {
							System.out.println("City Not added...");
						}

					} else {
						System.out.println("Do you want to add " + stateName + " in database");
						String msg = scr.nextLine();
						if (msg.equals("yes")) {
							b = stateService.isAddNewState(new StateModel(0, stateName));
							if (b) {
								System.out.println("State Added Succesfully...");
							} else {
								System.out.println("Something Wroing...");
							}
						} else {
							System.out.println("No");
						}
					}
				} else {
					System.out.println("There will be nothing to display...");
				}
				break;
			case 10:
				System.exit(0);
				break;
			default:

				System.out.println("Wrong input");
				break;
			}
		} while (true);
	}
}
