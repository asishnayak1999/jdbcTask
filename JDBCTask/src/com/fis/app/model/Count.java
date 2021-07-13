package com.fis.app.model;
import java.util.Objects;

public class Count {
	
	private String DevType;
	private int num;
	public Count() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Count(String devType, int num) {
		super();
		DevType = devType;
		this.num = num;
	}
	public String getDevType() {
		return DevType;
	}
	public void setDevType(String devType) {
		DevType = devType;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "Count [DevType=" + DevType + ", num=" + num + "]";
	}
	
	

}
