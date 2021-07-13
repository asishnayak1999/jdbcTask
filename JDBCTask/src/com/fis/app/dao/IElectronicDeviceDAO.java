package com.fis.app.dao;

import java.util.List;

import com.fis.app.exce.NoDeviceFoundException;
import com.fis.app.model.ElectrnoicDevice;

public interface IElectronicDeviceDAO {

	
	public boolean addDevice(ElectrnoicDevice device) throws Exception;
	public List<ElectrnoicDevice> getAllDevices() throws Exception;
	
	public ElectrnoicDevice changeDevicePrice(int deviceId,int newPrice)throws NoDeviceFoundException;
	public ElectrnoicDevice changeDeviceRating(int deviceId,int newRating)throws NoDeviceFoundException;
	
	public boolean deleteDevice(int deviceId)throws NoDeviceFoundException;
	
	public List<ElectrnoicDevice> getDevicesBasedOnBrandNameAndType(String brandName,String type) throws Exception;
	public int countDeviceType(String type) throws Exception;
	public int getSumofPriceBasedOnType(String type) throws Exception;
	
	public List<ElectrnoicDevice> getDevicesBasedOnPriceRangeandType(int range1, int range2, String type, List<ElectrnoicDevice> ls);
	
}
