package com.parkinglot.resources;

import java.util.*;
import java.util.Map.Entry;

public class Parking {
	private TreeMap<Integer,Car> parkingLot = new TreeMap<Integer,Car>();
	private TreeSet<Integer> vacantLot = new TreeSet<Integer>();
	//private TreeMap<String, ArrayList<Car > > colorMap = null;
	public String createParkingLot(int parkingLotSize)
	{
		String ret = "";
		if(parkingLotSize > 0)
		{
			for(int i  = 1 ; i <= parkingLotSize ; i++)
				vacantLot.add(i);
			//System.out.println(vacantLot.size());
			ret = "Created a​ parking ​slot​ with​ "+ String.valueOf(parkingLotSize) +" slots ";
		}
		else 
			ret = "Invalid size pf Parking lot";
		return ret;
	}
	
	public String park(Car car)
	{
		String ret = "";
		//System.out.println("asdsad"+car);
		//System.out.println(vacantLot.size());
			if(vacantLot.size()>0)
			{
				int location = vacantLot.first();
				vacantLot.remove(location);
				parkingLot.put(location,car);
				ret = "Allocated slot number: " + String.valueOf(location);
			}
			else 
				ret = "Sorry, ​parking lot is full";
				
		
		return ret;
	}
	
	public String leave(int location)
	{
		String ret = "";
		vacantLot.add(location);
		parkingLot.remove(location);
		ret = "Slot number ​"+ String.valueOf(location) +"​ is free" ;
		return ret;
	}
	
	public  TreeMap<Integer,Car> status(){
		return parkingLot;
	}
	
	public List<Integer> slotWithColor(String color){
		List<Integer> ret = new ArrayList<Integer>();
		for (Entry<Integer , Car> object : parkingLot.entrySet()) {
			if(object.getValue().getColor().equals(color))
				ret.add(object.getKey());
		}
		return ret;
	}
	
	public String slotWithCar(String regNo){
		String ret = "Not found";
		for (Entry<Integer , Car> object : parkingLot.entrySet()) {
			if(object.getValue().getCarId().equals(regNo))
			{
				ret = String.valueOf(object.getKey());
			}
		}
		return ret;
	}
	
	public List<String> carWithColor(String color){
		List<String> ret = new ArrayList<String>();
		for (Entry<Integer , Car> object : parkingLot.entrySet()) {
			if(object.getValue().getColor().equals(color))
				ret.add(object.getValue().getCarId());
		}
		return ret;
	}
	
	
}
