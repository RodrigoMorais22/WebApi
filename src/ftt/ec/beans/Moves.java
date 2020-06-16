package ftt.ec.beans;

public class Moves {
	private int id;
	private String name;
	private int power;
	private int accuracy;
	private String type;
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setId(String id) {
		try {
			if (id == null)	setId(0);
			else setId(Integer.valueOf(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public void setPower(String power) {
		try {
			if (power == null) setPower(0);
			else setPower(Integer.valueOf(power));			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public void setAccuracy(String accuracy) {
		try {
			if (accuracy == null) 
				setAccuracy(0);
			else 
				setAccuracy(Integer.valueOf(accuracy));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
