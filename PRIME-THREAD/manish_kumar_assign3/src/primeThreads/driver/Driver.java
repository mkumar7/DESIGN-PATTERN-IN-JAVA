package primeThreads.driver;
import primeThreads.store.Results;
import primeThreads.store.ResultsInterface;
import primeThreads.threadMgmt.CreateWorkers;
import primeThreads.util.FileProcessor;
import primeThreads.util.IsPrime;
import primeThreads.util.Logger;

public class Driver{

	public static void main(String args[])throws Exception 
	{
        
			int NUM_THREADS=-1;
			int DEBUG_VALUE=-1;
			NUM_THREADS = Integer.parseInt(args[1].toString());
			DEBUG_VALUE = Integer.parseInt(args[2].toString());
			Logger.setDebugValue(DEBUG_VALUE);
			
			FileProcessor x =null;
			x = new FileProcessor(args[0].toString());
			Results sum = new Results();
			IsPrime Prime = new IsPrime();
			
			CreateWorkers file = new CreateWorkers(x,Prime,sum);
			file.startWorkers(NUM_THREADS);
			sum.displayValue();
			ResultsInterface store = sum;
			store.displayResult();
			x.fileClose();
		
	} 
}

