package com.fis.app;

import java.util.List;

import com.fis.app.dao.ElectronicDeviceDAOImpl;
import com.fis.app.dao.IElectronicDeviceDAO;
import com.fis.app.model.*;


public class UserCode {
	
public static void main(String[] args) {
		
		try {

			IElectronicDeviceDAO dao = new ElectronicDeviceDAOImpl();

			ElectrnoicDevice mockeld1 = new ElectrnoicDevice(10,"Mobile","Samsung",20000,40,8,"PhantomBlack");
			ElectrnoicDevice mockeld2 = new ElectrnoicDevice(11,"Mobile","Apple",100000,60,9,"Silver");
			ElectrnoicDevice mockeld3 = new ElectrnoicDevice(12,"Laptop","Dell",40000,100,9,"Black");
			ElectrnoicDevice mockeld4 = new ElectrnoicDevice(13,"Laptop","HP",50000,90,6,"Grey");
			ElectrnoicDevice mockeld5 = new ElectrnoicDevice(14,"Mobile","Redmi",10000,20,5,"Blue");
			ElectrnoicDevice mockeld6 = new ElectrnoicDevice(15,"Mobile","OnePlus",40000,70,7,"SandStone");
			
//----------------------------------------------------------------------//
			//boolean a = dao.addDevice(mockeld1);
			//System.out.println(a);
			//boolean a1 = dao.addDevice(mockeld2);
			//System.out.println(a);
			//boolean a2 = dao.addDevice(mockeld3);
			//System.out.println(a1);
			//boolean a3 = dao.addDevice(mockeld4);
			//System.out.println(a2);
			//boolean a4 = dao.addDevice(mockeld5);
			//System.out.println(a4);
			//boolean a5 = dao.addDevice(mockeld6);
			//System.out.println(a5);
//------------------------------------------------------------------------//		
			
			 // List<ElectrnoicDevice> list = dao.getAllDevices();
			 // list.stream().forEach((ele)->System.out.println(ele));
			 
//-------------------------------------------------------------------------//		
			
				//List<ElectrnoicDevice> e =
				//dao.getDevicesBasedOnBrandNameAndType("Apple","Mobile");
				//e.stream().forEach((el)->System.out.println(el));
//			 
//--------------------------------------------------------------------------//
			
//			List<Count> cc = dao.countDeviceType();
//			cc.stream().forEach((el)->System.out.println(el));
			

//--------------------------------------------------------------------------//
			
			 //int totCost = dao.getSumofPriceBasedOnType("Laptop");
			 // System.out.println(totCost);
			 
			
//------------------------------------------------------------------------//
			
			 // List<ElectrnoicDevice> list = dao.getAllDevices();
			 //
			 //List<ElectrnoicDevice> filterList =
			 //dao.getDevicesBasedOnPriceRangeandType(20000, 120000, "Mobile",list);
			 // for(ElectrnoicDevice filteredWithRangeAndType : filterList) {
			  
			 //System.out.println(filteredWithRangeAndType); }
			
		} catch (Exception e) {
			System.out.println(" Problem "+e);
		}
}
}
