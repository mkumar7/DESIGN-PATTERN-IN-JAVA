
package genericCheckpointing.driver;

import java.lang.reflect.InvocationHandler;
import java.util.Vector;

import genericCheckpointing.util.*;
import genericCheckpointing.xmlStoreRestore.*;
import genericCheckpointing.server.*;

public class Driver {

	public static void main(String[] args) {
	     try{
		if (args.length != 3) {
			System.err.println("No of argument should be 3. <1>Mode <2>No of Objects <3>Input/Output File Name");
			System.exit(0);
		}
		String MODE = args[0].toString();
		if (!MODE.equals("serdeser") && !MODE.equals("deser")) 
			throw new IllegalArgumentException("MODE should be 'deser' or 'serdeser'");
		
	}catch(IllegalArgumentException e){
		e.printStackTrace();
		System.exit(1);
	}
		int NUM_OF_OBJECTS = 0;
		try {
			NUM_OF_OBJECTS = Integer.parseInt(args[1].toString());
		} catch (NumberFormatException e) {
			System.err.println("Please enter integer value");
			e.printStackTrace();
			System.exit(1);
		}

		String fileName = args[2].toString();
		FileProcessor fp = new FileProcessor(fileName); 
		ProxyCreator pc = new ProxyCreator(); 
		InvocationHandler handler = new StoreRestoreHandler(fp);  
		StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(new Class[] { StoreI.class, RestoreI.class }, handler);
		RandomGenerator rand = new RandomGenerator(); 
		SerializableObject flag = null;
		Vector<SerializableObject> Vector = null; 
		Vector<SerializableObject> temp = null; 
		MyAllTypesFirst myFirst;
		MyAllTypesSecond mySecond;
		String MODE = args[0].toString();
		if (MODE.equals("serdeser")) {
			fp.createWriter();
			Vector = new Vector<>();
			temp = new Vector<>();
			int j = 0;
			do
			{
				myFirst = new MyAllTypesFirst(rand.Int(),rand.Long(),"Design Patterns",rand.Bool());
				mySecond = new MyAllTypesSecond(rand.Double(), rand.Float(), rand.Short(), 'P');
				
				Vector.add(myFirst);
				Vector.add(mySecond);
				
				((StoreI) cpointRef).writeObj(myFirst, "XML");
				((StoreI) cpointRef).writeObj(mySecond, "XML");
				j++;
			}while(j < NUM_OF_OBJECTS);
			
			fp.closeWriter();
		} 
		if (MODE.equals("serdeser")||MODE.equals("deser")) 
		{ 
			fp.createReader();
			temp = new Vector<>();
			int i = 0; 
			do
			{
				flag = ((RestoreI) cpointRef).readObj("XML");
				if (flag!=null)
				{
					temp.addElement(flag);
				}
				i++;
			}while(i < 2 * NUM_OF_OBJECTS);
			fp.closeReader();
		}
		
		
		
		if(MODE.equals("serdeser"))
		{	
			if (Vector.size() != temp.size()) 
			{
				System.out.println((2 * NUM_OF_OBJECTS) + " Mismatched Object");
				System.exit(0);
			} else 
			{
				int cnt = 0;
				int j = 0;
				do 
				{
					if (temp.get(j).equals(Vector.get(j))) 
					{
						cnt++;
					}
					else
					{
						SerializableObject object1 = temp.get(j);
						SerializableObject object2 = Vector.get(j);
						System.out.println("Wrong Serialize Object\n"+ object2.toString());
						System.out.println("Wrong Deserialize Object\n"+ object1.toString());
					}
					j++;
				}while(j < temp.size());
				System.out.println((temp.size() - cnt) + " Object Mismatched");

			}
		}
		
		if(MODE.equals("deser")){
			int cnt=1;
			for(int i=0; i< temp.size();i++) 
			{
				System.out.println("Deserilized Object:"+ (cnt++) +" \n"+temp.get(i).toString());
			}
		}

		}
	}