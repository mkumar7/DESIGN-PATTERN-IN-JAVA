package airportSecurityState;

import airportSecurityState.util.Results;
import airportSecurityState.util.MyLogger;
public class LowRisk implements AirportStateInterface {

	private AirportSecurity newState;
    private MyLogger logger;
	public LowRisk(AirportSecurity lowState, MyLogger loggerIn) {
		 logger = loggerIn;
		logger.writeMessage("constructed LowRiskState class", logger.converToDebugVal(4));
		newState = lowState;
	}

	
	public StateHelper tightenOrLoosenSecurity(StateHelper cf, String inputline) {
		StateHelper temp = cf;
		temp = temp.returnFactors(cf, inputline);
		int flag = 1;
	
		if ((temp.getAveTraffic() >= 0) && (temp.getAveTraffic() < 4)
				|| (temp.getAveProhItems() >= 0) && (temp.getAveProhItems() < 1)) {

			newState.setCurrentState(newState.getLowRisk());
			flag = 1;
		}

		if ((temp.getAveTraffic() >= 4 && temp.getAveTraffic() < 8)
				|| (1 <= temp.getAveProhItems() && temp.getAveProhItems() < 2)) {
			newState.setCurrentState(newState.getModerateRisk());
			flag = 2;
		}
		
		if (temp.getAveTraffic() >= 8 || temp.getAveProhItems() >= 2) {
			newState.setCurrentState(newState.getHighRisk());
			flag = 3;
		}
         if(flag==1)
         {
	    logger.writeMessage("low risk state -> moderate risk state",logger.converToDebugVal(3));	    
	     }
	     else if(flag==2)
	     {
	    logger.writeMessage("low risk state -> high risk state",logger.converToDebugVal(3));
	     }
		
		Results w = newState.getResults();
		if (flag == 1) {
			w.writeToFile("1 3 5 7 9");
		} else if (flag == 2) {
			w.writeToFile("2 3 5 8 9");
		} else {
			w.writeToFile("2 4 6 8 10");
		}
		return temp;
	}
}