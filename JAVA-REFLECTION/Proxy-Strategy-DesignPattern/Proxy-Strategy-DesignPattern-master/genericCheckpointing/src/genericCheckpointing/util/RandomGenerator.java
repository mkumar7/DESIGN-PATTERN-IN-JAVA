package genericCheckpointing.util;

import java.util.Random;

public class RandomGenerator 
{
	
	private Random rand=null;
	public RandomGenerator() 
	{
		rand = new Random();
	}
	public int Int()
	{  
		int x;
		x = (rand.nextInt(100)+1);
		return x;
	}
	
	
	public float Float()
	{ 
		float y;
		y = (float)((Math.random() * 50) + 1);
		return y;

	}
	
	public double Double()
	{ 
		double z;
		z = ((Math.random() * 500) + 1);
		return z;
	}
	
	public short Short()
	{ 
		short a;
		a = (short)(rand.nextInt(100)+1);
		return a;
	}
	
	public long Long()
	{ 
		long b;
		b = (rand.nextInt(1000)+1);
		return b;

	}
	
	public boolean Bool()
	{ 
		return rand.nextBoolean();
	}
}
