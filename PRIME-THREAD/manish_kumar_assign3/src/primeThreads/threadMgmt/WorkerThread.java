
package primeThreads.threadMgmt;

import primeThreads.store.Results;
import primeThreads.store.ResultsInterface;
import primeThreads.util.FileProcessor;
import primeThreads.util.IsPrime;
import primeThreads.util.Logger;
import primeThreads.util.Logger.DebugLevel;
import java.io.IOException;
public class WorkerThread implements Runnable 
{

	
	FileProcessor x = null;
	IsPrime Prime = null;
	ResultsInterface sum = null;
	public Thread result;
	public WorkerThread(FileProcessor fp, IsPrime isPrimes, Results results) 
	{
		Logger.writeMessage("Called Constructor WorkerThread  ", DebugLevel.CONSTRUCTOR);
		x = fp;
		Prime = isPrimes;
		sum = results;
	}
	
	public void run() 
	{
		 
		  String y;
			int j;
			int z;
			y = x.readLineFromFile();
		try 
		{
			while (y != null) {
				result = Thread.currentThread();
				Logger.writeMessage("Thread Running:" + Thread.currentThread().getName(), DebugLevel.THREAD);

			    z = Integer.parseInt(y);
			    j = Prime.Prime(z);

			    if (j == 1) 
				{
					
					Logger.writeMessage("Inserted Value:" + z + " for " + Thread.currentThread().getName(), DebugLevel.RESULT);
					sum.insert(z);
				} 
				
				y = x.readLineFromFile();
			

			}

		} 
		catch (NullPointerException e)
           {
              e.printStackTrace();
           }
		catch (Exception e) 
		
		{
			
			Logger.writeMessage("Thread " + Thread.currentThread().getName() + " interrupted.",DebugLevel.THREAD);
			System.out.println("Unexcepted Exception");
			e.printStackTrace();
			System.exit(1);
		}
		finally
		{
		 Logger.writeMessage("Thread " + Thread.currentThread().getName() + " exiting.",DebugLevel.THREAD);
		}
	}
}