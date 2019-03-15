package airportSecurityState.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import airportSecurityState.util.MyLogger;
import java.io.File;

public class FileProcessor {

	private FileInputStream file_r;
	private BufferedReader buffer_r;
	PrintStream out;
	private String fileName;

		
   
	public FileProcessor(String fileName, MyLogger logger) 
	{
      try{
	  
	  logger.writeMessage("constructed FileProcessor class", logger.converToDebugVal(4));
	  file_r = new FileInputStream(fileName);
	 
	  buffer_r = new BufferedReader(new InputStreamReader(file_r));
	}catch(IOException e){
		e.printStackTrace();
		System.exit(1);
	}finally{
		
	}
			 
	}

	private BufferedReader getBufferedReader()
    {
	return buffer_r;
    }
	public void fileClose() throws IOException
	{
		 
	      buffer_r.close();
	      file_r.close();
	}
	

   public String readLine() {
   	try{
		return buffer_r.readLine();
   	}

   	catch (IOException e)
   	{
   		System.err.println("cannot read from input file, Please check");
   		e.printStackTrace();
   		System.exit(1);
   	}
   	 finally{

   	 }
   	 return null;

	}
	

}