package primeThreads.util;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import primeThreads.util.Logger;
import primeThreads.util.Logger.DebugLevel;




public class FileProcessor 
{
	private FileInputStream file_r;
	private BufferedReader buffer_r;
	PrintStream out;
	private String fileName;
	
    public String readLineFromFile() 
{
	try
           {
             return getBufferedReader().readLine();
	   } 
          catch (IOException e) 
          {
            System.err.println("cannot read from input file, Please check. ");
	    e.printStackTrace();
	    System.exit(1);
	   
	  } 
           finally
           {
		    
	       }
           return null;
}

	
	
	public FileProcessor(String fileName) throws IOException
	{
	
				
	  file_r = new FileInputStream(fileName);
	  Logger.writeMessage("File Processor Constructor Called", Logger.DebugLevel.CONSTRUCTOR);
	  buffer_r = new BufferedReader(new InputStreamReader(file_r));
				 
				 
	}

	private BufferedReader getBufferedReader()
    {
	return buffer_r;
    }
	public void fileClose() throws IOException
	{
		 
	      buffer_r.close();
	}
	
	
	
}
