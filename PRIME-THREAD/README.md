

PURPOSE: Pasrsing input file and get the maximum value of checked prime number and other debug values which set using thread and debug value.

FILES: Driver.java, Results.java, ResultInterface.java, StdoutInterface.java, StoreDataInterface.java, CreateWorker.java, WorkerThread.java, FileProcessor.java, IsPrime.java, Logger.java.

SAMPLE OUTPUT: Depends upon Input, However:   ”The sum of all the prime numbers is:251699515".

COMPILE THE CODE: ant -buildfile src/build.xml all

RUN THE CODE: ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=5 <-No of thread> -Darg2=0 <Debug Value>

No of thread should be in between 1 to 5 (inclusive)

The DEBUG_VALUE, read from the command line, should be set in the Logger class. 
Use the DEBUG_VALUE in the following way:
DEBUG_VALUE=4 [Print to stdout everytime a constructor is called] 
DEBUG_VALUE=3 [Print to stdout everytime a thread's run() method is called] 
DEBUG_VALUE=2 [Print to stdout everytime an entry is added to the Results data structure]
DEBUG_VALUE=1 [Print to stdout the contents of the data structure in the store] 
DEBUG_VALUE=0 [No output should be printed from the application, except the line "The sume of all the prime numbers is: XYZ" ]

CHOICE OF DATA STRUCTURE: Vector
->Complexity of Data Structure:
		
Space	O(n)
Search	O(n)
Insert	O(1) [Amortized]
Delete	O(n)
->Vector is synchronized and it is thread safe.
->Lock supports with locking an entir vector. 
->Size increment by doubled. So for larger number reduce an overhead for copying the data from past array into the new array.
