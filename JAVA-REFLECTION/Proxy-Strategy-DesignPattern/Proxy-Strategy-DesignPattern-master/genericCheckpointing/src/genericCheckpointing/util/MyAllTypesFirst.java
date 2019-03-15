package genericCheckpointing.util;

public class MyAllTypesFirst extends SerializableObject{
	
	private int myInt;
	private long myLong;
	private String myString;
	private boolean myBool;
	
	public MyAllTypesFirst(){
		
	}
	
	public MyAllTypesFirst(int my_Int, long my_Long, String my_String, boolean my_Bool){
		myInt = my_Int;
		myLong = my_Long;
		myString = my_String;
		myBool = my_Bool;
	}

	

	public int getMyInt() {
		return myInt;
	}

	public void setMyInt(int var) {
		myInt = var;
	}

	public long getMyLong() {
		return myLong;
	}

	public void setMyLong(long var) {
		myLong = var;
	}

	public String getMyString() {
		return myString;
	}

	public void setMyString(String var) {
		myString = var;
	}

	public boolean getMyBool() {
		return myBool;
	}

	public void setMyBool(boolean var) {
		myBool = var;
	}

	@Override
    public boolean equals(Object second){
		if(second==null){
			return false;
		}
		if(!(second instanceof MyAllTypesFirst)){
			return false;
		}
		MyAllTypesFirst first =(MyAllTypesFirst)second;
		
		if(this.hashCode()==first.hashCode()){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		
		return 
		"myInt: "+ myInt 
		+"\nmyLong: "+ myLong
		+"\nmyString:"+ myString 
		+"\nmyBool:"+ myBool;
		
	}
	
	@Override
	public int hashCode(){
		int temp;
		String s;
		s=String.valueOf(myInt)
		+ String.valueOf(myLong)
		+ myString 
		+ String.valueOf(myBool);
		temp = s.hashCode();
		return temp;
	}
	
	
}

