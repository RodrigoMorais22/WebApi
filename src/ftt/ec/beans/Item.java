package ftt.ec.beans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//JavaBean
//POJO

public class Item {
	
	private int id;
	private String name;
	private int rarity;
	
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
	public Int getRarity() {
		return this.rarity;
	}
	public void setRarity(Int rarity) {
		this.rarity = rarity;
	}	
}