package com.parkinglot.resources;

import java.io.*;
import java.util.List;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Main {
	static Parking parking = new Parking();
	public static void main(String[] args)
	{
		
		//if(args.length!=0)
		{
			System.out.println("Type exit to quit");
			while(true)
			{
                    try {
                        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                        String inputString = bufferRead.readLine();
                        //System.out.println(inputString);
                        if (inputString.equalsIgnoreCase("exit")) {
                            break;
                        } else if ((inputString == null) || (inputString.isEmpty())) {
                            // Do nothing
                        } else {
                        	Command(inputString);
                        }
                    } catch(IOException e) {
                        System.out.println("Oops! Error in reading the input from console.");
                        e.printStackTrace();
                    }
			}
		}
		/*else 
		{
			 File inputFile = new File(args[0]);
		        try {
		            BufferedReader br = new BufferedReader(new FileReader(inputFile));
		            String line;
		            try {
		                while ((line = br.readLine()) != null) {
		                    Commands.Command(line.trim());
		                }
		            } catch (IOException ex) {
		                System.out.println("Error in reading the input file.");
		                ex.printStackTrace();
		            }
		        } catch (FileNotFoundException e) {
		            System.out.println("File not found in the path specified.");
		            e.printStackTrace();
		        }
		}*/
	}
	static void Command(String command) {
		String [] subCommands = command.split(" ");
		//System.out.println(subCommands[0]);
	
			if( subCommands[0].equals("create_parking_lot" )) { 
				System.out.println(parking.createParkingLot(Integer.parseInt(subCommands[1])));
			}
			else if(subCommands[0].equals("park" )) {
				Car car = new Car(subCommands[1],subCommands[2]);
				System.out.println(parking.park(car));
			}
			else if( subCommands[0].equals("leave" )) {
				System.out.println(parking.leave(Integer.parseInt(subCommands[1])));
			}
			else if( subCommands[0].equals("status" )) {
				System.out.println("Slot​ ​No. Registration​ ​No Colour");
				TreeMap<Integer , Car> parkingLot =  parking.status();
				for (Entry<Integer , Car> object : parkingLot.entrySet()) {
					System.out.println(object.getKey()+" "+object.getValue().getCarId()+" "+object.getValue().getColor());
				}
			}
			else if( subCommands[0].equals("registration_numbers_for_cars_with_colour")) {
				List<String>cars = parking.carWithColor(subCommands[1]);
				String outputString = "";
				int i = 1;
				for (String regNo : cars) {
					outputString += regNo;
					if(i!=cars.size())
					{
						outputString += ", ";
					}
					i++;
				}
				System.out.println(outputString);
			}
			else if( subCommands[0].equals("slot_numbers_for_cars_with_colour" )) {	
				List<Integer>slots = parking.slotWithColor(subCommands[1]);
				String outputSlots = "";
				int i = 1;
				for (int slotNo : slots) {
					outputSlots += String.valueOf(slotNo);
					if(i!=slots.size())
					{
						outputSlots += ", ";
					}
					i++;
				}
				System.out.println(outputSlots);
			}
			else if( subCommands[0].equals("slot_number_for_registration_number" )) {
				System.out.println(parking.slotWithCar(subCommands[1]));
			}
	}
}
