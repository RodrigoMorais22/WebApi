package ftt.ec.beans;

public class Pokemon {
	private int id;
	private String name;
	private int number;
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
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void setNumber(String number) {
		try {
			if (number == null) setNumber(0);
			else setNumber(Integer.valueOf(number));			
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
