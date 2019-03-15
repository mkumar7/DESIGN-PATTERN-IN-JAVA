package airportSecurityState.driver;

import airportSecurityState.AirportSecurity;
import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.Results;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import airportSecurityState.util.MyLogger;
public class Driver {
	public static void main(String[] args) throws IOException {
		try{
		while (args.length != 3) {
			System.err.println("Invalid arguments. Provide <input.txt> " + "<output.txt" + "<DebugLevel>");
			System.exit(1);
		}
         int loggerLevel = Integer.parseInt(args[2]);
         MyLogger logger = new MyLogger(loggerLevel);
		Results results = new Results(args[1], logger);
         AirportSecurity inputParams = new AirportSecurity(results,logger);
		
		
		String line;

          FileProcessor processor = new FileProcessor(args[0], logger);
			while ((line = processor.readLine()) != null) {
				inputParams.lineProcessing(line);
               }
               results.closeFile();
              }catch(RuntimeException e){
		e.printStackTrace();
		System.exit(2);
	}
	finally{
		
		
	}

	}
	  
	

}