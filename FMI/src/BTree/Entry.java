package BTree;

public class Entry {
	//Data
   	private Object key;
	private Object value;

	//Constructor
	public Entry(Object key) throws NullPointerException {
		if(key == null) throw new NullPointerException();
		this.key = key;
	}

	//Methods
	public Object getKey() { return key; }
	public Object getValue() { return value; }
	public Object setValue(Object newValue) throws NullPointerException {
		if(newValue == null) throw new NullPointerException();
		Object old = value;
		value = newValue;
		return old;
	}
	
	public boolean equals(Object obj) {
		Entry t = (Entry)obj;
		return key.equals(t.getKey()) && value.equals(t.getValue());
	}

	public String toString() { return "(" + key + "," + value + ")"; }
}