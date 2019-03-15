package genericCheckpointing.Strategy;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;

public class XMLDeserialization implements DeserStrategy
{
	private FileProcessor file_reader=null;
	public XMLDeserialization(FileProcessor fp) {
		file_reader = fp;
	}
	public SerializableObject getDeserObject(){
		
		String temp = null;
		Method m = null;
		try {
			Class<?> c = null;
			Object object = null;
			Pattern pattern = null;
			Matcher matcher = null;
			String Name;
			String Value;
			String type;
			String tag;
			temp = file_reader.readLineFromFile();
			while (temp != null) {

				if (temp.contains("xsi:type")) { 

					if (temp.contains("complexType")) 
					{  
						pattern = Pattern.compile("\"([^\"]*)\"");
						matcher = pattern.matcher(temp);
						while (matcher.find()) {

							String objectName = matcher.group(1);
								c = Class.forName(objectName);
								object = c.newInstance();

							
						}

					}
 
						if(temp.contains("xsd:")) { 
						pattern = Pattern.compile("\"xsd:([^\"]*)\">(s*.*s*)<\\/(s*.*s*)>");
						matcher = pattern.matcher(temp);
						while (matcher.find()) 
						{
							
							Name = matcher.group(1).toString(); 
							Value = matcher.group(2).toString(); 
							tag = matcher.group(3).toString();
							type = "set" 
							+ tag.substring(0, 1).toUpperCase() 
							+ tag.substring(1); 
							switch (Name) {
							case "int":
							    int int_val = Integer.parseInt(Value);
								m = c.getMethod(type, Integer.TYPE);
								m.invoke(object, int_val);
								break;
								case "char":
							    char ch_val = Value.charAt(0);
								m = c.getMethod(type, Character.TYPE);
								m.invoke(object, ch_val);
								break;
							case "short":
							    short s_val = Short.parseShort(Value);
								m = c.getMethod(type, Short.TYPE);
								m.invoke(object, s_val);
								break;
							case "long":
							    long l_val = Long.parseLong(Value);
								m = c.getMethod(type, Long.TYPE);
								m.invoke(object, l_val);
								break;
							case "double":
							    double d_val = Double.parseDouble(Value);
								m = c.getMethod(type, Double.TYPE);
								m.invoke(object, d_val );
								break;
							case "float":
							    float f_val = Float.parseFloat(Value);
								m = c.getMethod(type, Float.TYPE);
								m.invoke(object, f_val);
								break;
							case "boolean":
								Boolean b_val = Boolean.parseBoolean(Value);
								m = c.getMethod(type, Boolean.TYPE);
								m.invoke(object, b_val);
								break;
							case "string":							    
							    String c_val = Value;
								m = c.getMethod(type, String.class);
								m.invoke(object, c_val);
								break;
							
							   default:
							    System.err.println("Invalid type " + type + ". Ignoring it");
								break;
							}
						}

					}
				} else if (temp.equals("</DPSerialization>")) {
					return (SerializableObject) object;
				}
				temp = file_reader.readLineFromFile();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}
