
package primeThreads.util;

public class Logger{
	private static DebugLevel Level;

    public static enum DebugLevel { OUTPUT,DATASTRUCTURE,RESULT,THREAD,CONSTRUCTOR };

    public static void writeMessage (String message,DebugLevel levelIn ) 
    {
        
        if (levelIn==Level)
        {
            System.out.println(message);
        }
    }
    public static void setDebugValue (int levelIn) {
    
        if(levelIn == 0)
        {
            Level = DebugLevel.OUTPUT;
        }
        
        else if(levelIn == 1)
        {
            Level = DebugLevel.DATASTRUCTURE;
        }
        else if(levelIn == 2)
        {
            Level = DebugLevel.RESULT;
        }
        else if(levelIn == 3)
            {
                Level = DebugLevel.THREAD; 
            }
        else if(levelIn == 4)
        {
            Level = DebugLevel.CONSTRUCTOR; 
        }
         
    }

    public String toString() 
    {
    	return "Debug Level is " + Level;
    }
}
