package genericCheckpointing.Strategy;

import genericCheckpointing.util.SerializableObject;


public interface SerStrategy{
	public void processInput(SerializableObject sObject);
}
