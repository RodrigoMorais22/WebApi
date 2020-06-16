package ftt.ec.control;

import java.math.BigInteger;

public class BigIntControl {
	
	BigInteger bigA;
	BigInteger bigB;
	
	//Default constructor
	public BigIntControl() {
		
	}
	
	//Alternative constructor
	public BigIntControl(String a, String b) {
		this.setA(a);
		this.setB(b);
	}
	
	public void setA(String a) {
		this.bigA = new BigInteger(a);
	}
	
	public void setB(String b) {
		this.bigB = new BigInteger(b);
	}
	
	public String getSum() {
		return bigA.add(bigB).toString();
	}
	
}
