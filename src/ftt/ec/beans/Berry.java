package ftt.ec.beans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//JavaBean
//POJO

public class Berry {
	
	private int id;
	private String name;
	private int growth_time ;
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setId(String id) {
		if (id == null) {
			setId(0);
		} else {
		 setId(Integer.valueOf(id));
		}
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Int getGrowth() {
		return this.growth_time;
	}
	public void setGrowth(Int growth) {
		this.growth_time = growth;
	}	
}