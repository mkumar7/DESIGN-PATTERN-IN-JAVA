package genericCheckpointing.Strategy;

import genericCheckpointing.util.SerializableObject;


public interface DeserStrategy{
	public SerializableObject getDeserObject();
}
