package com.fis.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.fis.app.exce.NoDeviceFoundException;
import com.fis.app.model.ElectrnoicDevice;


public class ElectronicDeviceDAOImpl implements IElectronicDeviceDAO{
	
	Connection con = null;

	String insertElectronicDeviceQuery = "insert into fisapp.electronicDevice values(?,?,?,?,?,?,?)";
	String selectAllElecronicDevice = "select * from fisapp.electronicDevice";
	String selectEmployeeBasedOnBrandNameandType = "select * from fisapp.electronicDevice where deviceType = ? AND brandName = ?";
	String countDeviceType = "SELECT COUNT(deviceType) FROM fisapp.electronicDevice where deviceType = ?";
	String getSumBasedOnType = "SELECT SUM(cost) FROM fisapp.electronicDevice GROUP BY ?";
	@Override
	public boolean addDevice(ElectrnoicDevice device) throws Exception {		
		con = DatabaseUtil.getConnection();
		boolean isInserted = false;
		if (con != null) {

			int deviceId = device.getDeviceId();
			String deviceType = device.getDeviceType();
			String brandName = device.getBrandName();
			int cost = device.getCost();
			int power = device.getPower();
			int starRatings = device.getStarRatings();
			String color = device.getColor();

			PreparedStatement ps = con.prepareStatement(insertElectronicDeviceQuery);
			ps.setInt(1, deviceId);
			ps.setString(2, deviceType);
			ps.setString(3, brandName);
			ps.setInt(4, cost);
			ps.setInt(5, power);
			ps.setInt(6,starRatings);
			ps.setString(7,color);

			int i = ps.executeUpdate(); 

			if (i > 0)
				isInserted = true;
		}

		return isInserted;
	}
	@Override
	public List<ElectrnoicDevice> getAllDevices() throws Exception{
		con = DatabaseUtil.getConnection();
		List<ElectrnoicDevice> eleList = new ArrayList<>();
		if (con != null) {

			PreparedStatement ps = con.prepareStatement(selectAllElecronicDevice);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ElectrnoicDevice temp = new ElectrnoicDevice();

				temp.setDeviceId(rs.getInt("idelectronicDevice"));
				temp.setDeviceType(rs.getString("deviceType"));
				temp.setBrandName(rs.getString("brandName"));
				temp.setCost(rs.getInt("cost"));
				temp.setPower(rs.getInt("power"));
				temp.setStarRatings(rs.getInt("starRating"));
				temp.setColor(rs.getString("color"));

				eleList.add(temp);
			}

		}
		return eleList;
	}
	@Override
	public List<ElectrnoicDevice> getDevicesBasedOnBrandNameAndType(String brandName, String type) throws Exception {
		
		con = DatabaseUtil.getConnection();
		List<ElectrnoicDevice> eleList2 = new ArrayList<>();
		if (con != null) {

			PreparedStatement ps = con.prepareStatement(selectEmployeeBasedOnBrandNameandType);
			ps.setString(1, type);
			ps.setString(2, brandName);

			ResultSet rs = ps.executeQuery();
			boolean isFound = false;
			while (rs.next()) {
				isFound = true;
				ElectrnoicDevice temp = new ElectrnoicDevice();

				temp.setDeviceId(rs.getInt("idelectronicDevice"));
				temp.setDeviceType(rs.getString("deviceType"));
				temp.setBrandName(rs.getString("brandName"));
				temp.setCost(rs.getInt("cost"));
				temp.setPower(rs.getInt("power"));
				temp.setStarRatings(rs.getInt("starRating"));
				temp.setColor(rs.getString("color"));

				eleList2.add(temp);
			}

			if (!isFound)
				throw new NoDeviceFoundException(brandName,type);

		}
		return eleList2;
	}
	@Override
	public int countDeviceType(String type) throws Exception {
		con = DatabaseUtil.getConnection();
		int e = 0;
		if (con != null) {

			PreparedStatement ps = con.prepareStatement(countDeviceType);
			ps.setString(1, type);

			//ResultSet rs = ps.executeQuery();
			ResultSet rs = ps.executeQuery();
			boolean isFound = false;
			while (rs.next()) {
				isFound = true;
				ElectrnoicDevice temp = new ElectrnoicDevice();
				
				e = rs.getInt("COUNT(deviceType)");
			}

			if (!isFound)
				throw new NoDeviceFoundException(type,"xx");

		}
		return e;
	}
	@Override
	public int getSumofPriceBasedOnType(String type) throws Exception {
		con = DatabaseUtil.getConnection();
		int e2 = 0;
		if (con != null) {

			PreparedStatement ps = con.prepareStatement(getSumBasedOnType);
			ps.setString(1, type);

			ResultSet rs = ps.executeQuery();
			boolean isFound = false;
			while (rs.next()) {
				isFound = true;
				ElectrnoicDevice temp = new ElectrnoicDevice();
				e2 = rs.getInt("SUM(cost)");
			}

			if (!isFound)
				throw new NoDeviceFoundException(type,"xx");

		}
		return e2;
	}
	@Override
	public List<ElectrnoicDevice> getDevicesBasedOnPriceRangeandType(int range1, int range2, String type, List<ElectrnoicDevice> ls) {
		
		
		return null;
	}
	@Override
	public ElectrnoicDevice changeDevicePrice(int deviceId, int newPrice) throws NoDeviceFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ElectrnoicDevice changeDeviceRating(int deviceId, int newRating) throws NoDeviceFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean deleteDevice(int deviceId) throws NoDeviceFoundException {
		// TODO Auto-generated method stub
		return false;
	}
}
