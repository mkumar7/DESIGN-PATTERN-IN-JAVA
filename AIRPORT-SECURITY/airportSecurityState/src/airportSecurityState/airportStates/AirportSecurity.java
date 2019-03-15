package airportSecurityState;

import airportSecurityState.util.Results;
import airportSecurityState.util.MyLogger;
import airportSecurityState.util.FileProcessor;
public class AirportSecurity {

	private AirportStateInterface LowRisk;
	private AirportStateInterface ModerateRisk;
	private AirportStateInterface HighRisk;
	private AirportStateInterface CurrentState;
	private Results results;
    private MyLogger logger;
    private FileProcessor inputFile;
	private StateHelper StateHelper = new StateHelper(logger);

	public void lineProcessing(String fileLine) 
	{

		CurrentState.tightenOrLoosenSecurity(StateHelper, fileLine);
	}

	public AirportSecurity(Results res, MyLogger loggerIn)
	 {  try{
	 	logger = loggerIn;
	 	logger.writeMessage("constructed AirportSecurity class",logger.converToDebugVal(4));
	   
		setResults(res);
		LowRisk = new LowRisk(this, logger);
		ModerateRisk = new ModerateRisk(this, logger);
		HighRisk = new HighRisk(this, logger);
		setCurrentState(LowRisk);
	}catch(RuntimeException e){
		e.printStackTrace();
		System.exit(1);
	}finally{

	}
		
	
	}
     public Results getResults() 
	{
		return results;
	}
     public Results getLine()
     {
     	return results;
     }
	public void setResults(Results results) 
	{
		this.results = results;
	}
	public AirportStateInterface getCurrentState() 
	{
		return CurrentState;
	}

	
	public void setCurrentState(AirportStateInterface currentState) 
	{
		CurrentState = currentState;
	}

	
	public AirportStateInterface getLowRisk() 
	{
		return LowRisk;
	}

	public void setLowRisk(AirportStateInterface lowRisk) 
	{
		LowRisk = lowRisk;
	}

	public AirportStateInterface getModerateRisk() 
	{
		return ModerateRisk;
	}

	public void setModerateRisk(AirportStateInterface moderateRisk) 
	{
		ModerateRisk = moderateRisk;
	}

	public AirportStateInterface getHighRisk() 
	{
		return HighRisk;
	}

	public void setHighRisk(AirportStateInterface highRisk) 
	{
		HighRisk = highRisk;
	}

	
	}
