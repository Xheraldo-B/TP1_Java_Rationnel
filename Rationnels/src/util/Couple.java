package util;

public class Couple<T1, T2> {
	private T1 value1;
	private T2 value2;
	
	
	public Couple(T1 value1, T2 value2) {
		// TODO Auto-generated constructor stub
		this.value1 = value1;
		this.value2 = value2;
	}


	public void setFirst(T1 value) 
	{
		value1 = value;
	}
	
	public void setSecond(T2 value) 
	{
		value2 = value;
	}
	
	
	public T1 getFirst() 
	{
		return value1;
	}
	
	public T2 getSecond() 
	{
		return value2;
	}	
	
	public boolean equals(Couple<T1, T2> object) 
	{
		return this.value1 == object.value1 && this.value2 == object.value2;
	}
	
}
