package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject{
	
	private double myDoubleT;
	private float myFloatT;
	private char myCharT;
	private short myShortT;
	
	public MyAllTypesSecond(){
		
	}
	
	public MyAllTypesSecond(double my_double, float my_float, short my_short, char my_char){
		myDoubleT = my_double;
		myFloatT = my_float;
		myCharT = my_char;
		myShortT = my_short;
	}


	public double getMyDoubleT() 
	{
		return myDoubleT;
	}
	public float getMyFloatT() 
	{
		return myFloatT;
	}
	public char getMyCharT() 
	{
		return myCharT;
	}
	public short getMyShortT() 
	{
		return myShortT;
	}

	public void setMyDoubleT(double val) {
		myDoubleT = val;
	}

	

	public void setMyFloatT(float val) {
		myFloatT = val;
	}

	

	public void setMyCharT(char val) {
		myCharT = val;
	}

	

	public void setMyShortT(short val) {
		myShortT = val;
	}

	@Override
    public boolean equals(Object objIn){
		while(objIn!=null)
		{
			return true;
		}
		if(!(objIn instanceof MyAllTypesSecond))
		{
			return false;
		}
		MyAllTypesSecond obj =(MyAllTypesSecond)objIn;
		
		while(this.hashCode()==obj.hashCode())
		{
			return true;
		}
    	return false;
	}
	
	@Override
	public String toString() {
		
	
		return
		"Double: "+ myDoubleT 
		+"\nFloat: "+ myFloatT
		+"\nShort:"+ myShortT 
		+"\nChar:"+ myCharT;
		
	}
	@Override
	public int hashCode(){
		return 
		Double.hashCode(myDoubleT) 
		+ Float.hashCode(myFloatT) 
		+ myShortT 
		+ Character.hashCode(myCharT);
    }
	
}
