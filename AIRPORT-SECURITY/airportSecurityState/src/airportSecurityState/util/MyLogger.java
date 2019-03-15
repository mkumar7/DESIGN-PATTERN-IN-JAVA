package airportSecurityState.util;

import airportSecurityState.util.Results;

public class MyLogger{

    
    private static DebugLevel debugLevel;
    public static enum DebugLevel {RELEASE, INPUTS, PARAMETERS, STATE_CHANGE, CONSTRUCTOR};

    
    private static Results output;

    
    public MyLogger(int levelIn)
    {
    this.setDebugValue(levelIn);
    output = new Results(this);
    }

    
    public static void setDebugValue (int levelIn) 
    {
      
     if(levelIn == 0){
        debugLevel = DebugLevel.RELEASE;
     }
     else if(levelIn == 1){
        debugLevel = DebugLevel.INPUTS;
     }
     else if(levelIn == 2){
        debugLevel = DebugLevel.PARAMETERS;
     }
     else if(levelIn == 3){
        debugLevel = DebugLevel.STATE_CHANGE;
     }
     else if(levelIn == 4){
        debugLevel = DebugLevel.CONSTRUCTOR;
     }
    }

    
    public static void setDebugValue (DebugLevel levelIn) 
    {
    debugLevel = levelIn;
    }

    public static void writeMessage (String message, DebugLevel levelIn ) {
    if (levelIn == debugLevel)
        output.writeToStdout(message);
    }

   
    public static DebugLevel converToDebugVal(int levelIn){
    DebugLevel level = null;
    
        
        if(levelIn == 0){
            level = DebugLevel.RELEASE;

        }
        else if(levelIn == 1){
            level = DebugLevel.INPUTS;
        }
        else if(levelIn == 2){
            level = DebugLevel.PARAMETERS;
        }
        else if(levelIn == 3){
            level = DebugLevel.STATE_CHANGE;
        }
        else if(levelIn == 4){
            level = DebugLevel.CONSTRUCTOR;
        }
   
    return level;
    }

   
    public String toString() {
    return "Debug Level is " + debugLevel;
    }

}

