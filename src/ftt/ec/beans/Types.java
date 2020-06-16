package ftt.ec.beans;

public class Types {
	private int id;
	private String name;
	private String biggest_weakness;
	private String biggest_advantage;
	
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
	
	public String getBiggest_weakness() {
		return biggest_weakness;
	}
	public void setBiggest_weakness(String biggest_weakness) {
		this.biggest_weakness = biggest_weakness;
	}
	
	public String getBiggest_advantage() {
		return biggest_advantage;
	}
	public void setBiggest_advantage(String biggest_advantage) {
		this.biggest_advantage = biggest_advantage;
	}
}
