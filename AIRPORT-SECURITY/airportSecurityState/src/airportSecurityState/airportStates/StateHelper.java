package airportSecurityState;

import java.util.ArrayList;
import airportSecurityState.util.MyLogger;
public class StateHelper {
     
	private int tempDayNumber;
	private int flight = 0;
	private int prohItem = 0;
	private String store;
	private double aveTraffic = 0;
	private double aveProhItems = 0;
	private MyLogger logger;
    public StateHelper(MyLogger loggerIn) 
    {
    	logger = loggerIn;
	logger.writeMessage("constructed StateHelper class", logger.converToDebugVal(4));
    }
	public int getflight() 
	{
		return flight;
	}
    
	
	public void setflight(int flight) 
	{
		this.flight = flight;
	}

	public double getProhItems() 
	{
		return aveProhItems;
	}

	public void setProhItems(double prohItems) 
	{
		this.aveProhItems = prohItems;
	}
	public int getTempDayNumber() 
	{
		return tempDayNumber;
	}

	public void setTempDayNumber(int tempDayNumber) 
	{
		this.tempDayNumber = tempDayNumber;
	}
    public double calulateAverageTraffic(int dayNum, int flights) 
	{
		return ((double) flights) / ((double) dayNum);
		
	}

	public double calculateProhibitedItems(int itemCount, int dayNumber) 
	{
		return ((double) itemCount) / ((double) dayNumber);
	
	}
	

	public double getAveTraffic() 
	{
		return aveTraffic;
	}

	
	public void setAveTraffic(double aveTraffic) 
	{
		this.aveTraffic = aveTraffic;
	}

	
	public String getstore() 
	{
		return store;
	}

	public void setstore(String tempItem) 
	{
		this.store = store;
	}
     public int getProhItem() 
	{
		return prohItem;
	}

	public void setProhItem(int prohItem) 
	{
		this.prohItem = prohItem;
	}
	

	public double getAveProhItems() 
	{
		return aveProhItems;
	}

	public void setAveProhItems(double aveProhItems) 
	{
		this.aveProhItems = aveProhItems;
	}

	
	

public StateHelper returnFactors(StateHelper cf, String line) {
		
		String[] split_string = line.split(";");
		cf.setTempDayNumber(Integer.parseInt(split_string[0].split(":")[1]));
		int tempPI = cf.getProhItem();
		ArrayList<String> Item = new ArrayList<String>();
		Item.add("Grains");
		Item.add("NailCutters");
		Item.add("Plants");
		Item.add("EndangeredAnimals");
		cf.setProhItem(tempPI);
		cf.setflight(cf.getflight() + 1);
		cf.setAveTraffic(calulateAverageTraffic(cf.getTempDayNumber(), cf.getflight()));
		cf.setAveProhItems(calculateProhibitedItems(cf.getProhItem(), cf.getTempDayNumber()));
		return cf;
	}
}
