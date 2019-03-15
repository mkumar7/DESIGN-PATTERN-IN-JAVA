package genericCheckpointing.Strategy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;


public class XMLSerialization implements SerStrategy
{
	
	public FileProcessor file_reader;
	
	public XMLSerialization(FileProcessor fp) 
	{
		
		file_reader = fp;
	}
	
	public void processInput(SerializableObject  Obj)
	{
		ArrayList<String> list;
		list = new ArrayList<String>();
		String Name;
		Class<?> c = Obj.getClass();
		Method Method = null;
		String store =null;
		Object i=null;
		String Type;
		
		Field[] fields = c.getDeclaredFields();
		
		list.add("<DPSerialization>\n");
		list.add(" <complexType xsi:type=\"" 
			+ c.getCanonicalName() 
			+ "\">\n");
		
		for (Field f : fields) 
		{
			Type = f.getType().getSimpleName().toLowerCase();
			Name = f.getName();
			store = "get"
			+Name.substring(0, 1).toUpperCase() 
			+ Name.substring(1); 
			
			
			try {
				Method = c.getMethod(store);
			} 
			catch (NoSuchMethodException | SecurityException e) 
			{
				e.printStackTrace();
				System.exit(1);
			}finally
			{

			}
			
			
			try {
				i = Method.invoke(Obj);
			} 
			catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) 
			{
				e.printStackTrace();
				System.exit(1);
			}
		     finally{
				list.add(serialize(Name,Type,i));
			}
			
		}

		list.add(" </complexType>\n");
		list.add("</DPSerialization>\n");
		
		for(int j =0; j<list.size();j++) 
		{
		
			file_reader.storeLine(list.get(j));
		}
		
	}
	
	
	private String serialize(String field,String Type,Object i)
	{
		
		return "  <"
		+field
		+" xsi:type=\"xsd:"
		+Type+"\">"
		+i.toString() 
		+"</"+field+">\n";
	
	}
}
