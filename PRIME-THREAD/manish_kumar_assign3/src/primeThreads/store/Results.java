
package primeThreads.store;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import java.util.List;
import primeThreads.util.Logger;
import primeThreads.util.Logger.DebugLevel;

public class Results implements ResultsInterface
 {
    
	
	Vector<Integer> list = new Vector<>();
	public Results()
	{
		Logger.writeMessage("Constructor getCreated", DebugLevel.CONSTRUCTOR);
		 
	}
	
    // total sum on screen
    public void displayResult() 
    {
      	int result = 0;
    	int j = 0;

    	do
    	{
    		
    		result +=  list.get(j);
    		j++;
		}
		while(j < list.size());
    	
    	Logger.writeMessage("Total prime numbers sum is:"+result,DebugLevel.OUTPUT);
	}
	//Inserting the data elements
	public void insert(int number)
	{
		list.add(number);

	}
	// Display the stored data of vector
    public void displayValue()
    {  
    	int j = 0;
		while(j<list.size())
		{
			Logger.writeMessage("Display Data store Value:"+ list.get(j),DebugLevel.DATASTRUCTURE);
			j++;
		}
		
	}	
}



