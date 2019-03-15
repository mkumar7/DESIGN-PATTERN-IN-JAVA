
package primeThreads.threadMgmt;

import primeThreads.util.FileProcessor;
import primeThreads.store.Results;
import primeThreads.util.IsPrime;
import primeThreads.util.Logger;
import primeThreads.util.Logger.DebugLevel;
import java.io.IOException;

public class CreateWorkers  {
	FileProcessor x= null;
	IsPrime Prime=null;
	Results sum =null;
	
	
    public CreateWorkers(FileProcessor FileProcessor, IsPrime IsPrimeNumber, Results Results )
    {
        x = FileProcessor;
        Prime = IsPrimeNumber;
        sum = Results;
    	Logger.writeMessage(" Called Constructor Worker ", DebugLevel.CONSTRUCTOR);
    	
    	 
    }
    
    public void startWorkers(int noOfThreads)
    {
        Thread [] thread = new Thread[noOfThreads];
    	
    
    	int j = 0;
        
        do 
        {

    		thread[j] = new Thread(new WorkerThread(x,Prime,sum));
    		thread[j].setName("Thread"+j);
    		thread[j].start();
    		Logger.writeMessage("Thread Creation:"+j, DebugLevel.THREAD);
			j++;
		}
    	 while(j < noOfThreads);
     
        
         int k = 0;
         do
         {
            
    		try
            {
    			thread[k].join();
    		}
            catch (NullPointerException e)
           {
              e.printStackTrace();
           }
    		catch(InterruptedException e)
            {
                System.out.println("Unexcepted Exception");
    			e.printStackTrace();
               System.exit(1);
    	    }
            k++;
        
    	
    }
        while(k < thread.length);
    
    	
    }

}