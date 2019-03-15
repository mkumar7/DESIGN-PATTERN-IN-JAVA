package airportSecurityState.util;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import airportSecurityState.util.FileDisplayInterface;
import airportSecurityState.util.StdoutDisplayInterface;
import airportSecurityState.util.MyLogger;

public class Results implements StdoutDisplayInterface, FileDisplayInterface {
	private String result;
	private String FILENAME = "output.txt";
	private String[] store;
	

	private BufferedWriter BufferedWriter = null;
	private FileWriter FileWriter = null;
    public Results(MyLogger logger){
    	result = null;
    	this.FILENAME = null;
    }
	
	public Results(String string, MyLogger logger) 
	{    result = "";
		FILENAME = string;
		this.FILENAME = string;
		logger.writeMessage("constructed Results class", logger.converToDebugVal(4));

		try{
		
			FileWriter = new FileWriter(FILENAME);
		}catch(IOException f){
			f.printStackTrace();
		}
		finally
		{
			BufferedWriter = new BufferedWriter(FileWriter);
			
		}
		
		
}
     public void writeToStdout(String inputLine) 
     {
		System.out.println(inputLine);
	}

	public void writeToFile(String inputLine) {

		try {
			BufferedWriter.write(inputLine);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		try {
			BufferedWriter.newLine();
		} catch (IOException f) {
			f.printStackTrace();
		}
	}

    public String getResults(){
    	return this.result;

    }

	


	public void storeToOutput(String outputValue) {
		this.result += outputValue;

	}
	
	public void closeFile() {
		try {
			BufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{

		}
	}
}
