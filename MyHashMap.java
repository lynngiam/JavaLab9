import java.util.AbstractMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MyHashMap<K, V> implements MapADT<K, V> {
    LinkedList<Map.Entry<K, V>>[] table;
    int size; // current number of items in the table (not number of buckets)
    private int capacity;
    double maxLoadFactor = size / capacity; // load factor = (number of keys in the table) / (number of slots in the
					    // table)
    float userMaxLoadFactor;

    MyHashMap(int capacity, float maxLoadFactor) {
	this.userMaxLoadFactor = maxLoadFactor;
	this.capacity = capacity;
	table = (LinkedList<Map.Entry<K, V>>[]) new LinkedList[capacity]; // capacity is the number of buckets
	for (int i = 0; i < table.length; i++) {
	    table[i] = new LinkedList<Map.Entry<K, V>>();
	}
    }

    MyHashMap() {
	this(11, (float) 0.75);
    }

    public V put(K key, V value) {
	// TODO Auto-generated method stub
	V retValue = null;
	if (value == null || key == null) { // if value or key is null, throw exception
	    throw new NullPointerException();
	}
	int hashKey = Math.abs(key.hashCode()) % size;
	if (table[hashKey].contains(key)) { // if key is present
	    int index = table[hashKey].indexOf(key);
	    retValue = table[hashKey].get(index).getValue(); // get original value
	    table[hashKey].get(index).setValue(value); // set new value
	} else {
	    table[hashKey].add(new AbstractMap.SimpleEntry<K, V>(key, value)); // create new node for key and value pair
	    size++; // increment size
	}
	if (maxLoadFactor > userMaxLoadFactor) {
	    resize();
	}
	// TODO write resize when maxLoadFactor is met

	return retValue; // return original value; null if key is not present

    }

    public V get(K key) {
	// TODO Auto-generated method stub
	V retValue = null;
	int hashKey = Math.abs(key.hashCode()) % size;
	if (table[hashKey].contains(key)) { // check if key is present
	    int index = table[hashKey].indexOf(key);
	    retValue = table[hashKey].get(index).getValue(); // get original value
	}
	return retValue;
    }

    @Override
    public boolean isEmpty() {
	// TODO Auto-generated method stub
	if (size == 0) {
	    return true;
	}
	return false;
    }

    @Override
    public void clear() {
	// TODO Auto-generated method stub
	for (int i = 0; i < table.length; i++) {
	    table[i].clear();
	}
	size = 0;
    }

    @Override
    public int size() {
	// TODO Auto-generated method stub
	return size;
    }

    public Iterator<K> keys() {
	// TODO Auto-generated method stub
	List<K> list = new LinkedList<K>();
	addKeysToList(list);
	return list.iterator();
    }

    private void addKeysToList(List<K> list) {
	for (int i = 0; i < table.length; i++) {
	    if (!table[i].isEmpty()) {
		for (Map.Entry<K, V> entries : table[i]) {
		    list.add(entries.getKey());
		}
	    }
	}
    }

    public Iterator<Entry<K, V>> entries() {
	List<Map.Entry<K, V>> l = new LinkedList<Map.Entry<K, V>>();
	addEntriesToList(l);
	return l.iterator();
    }

    private void addEntriesToList(List<Map.Entry<K, V>> l) {
	for (int i = 0; i < table.length; i++) {
	    if (!table[i].isEmpty()) {
		for (Map.Entry<K, V> entries : table[i]) {
		    l.add(new AbstractMap.SimpleEntry<K, V>(entries.getKey(), entries.getValue()));
		}
	    }
	}

    }

    private void resize() {
	this.capacity = generatePrime(capacity);
	LinkedList<Map.Entry<K, V>>[] newTable = (LinkedList<Map.Entry<K, V>>[]) new LinkedList[capacity];
	for (int i = 0; i < table.length; i++) {
	    if (!table[i].isEmpty()) {
		for (Map.Entry<K, V> entries : table[i]) {
		    int newHashKey = Math.abs(entries.getKey().hashCode()) % size;
		    newTable[newHashKey].add(new AbstractMap.SimpleEntry<K, V>(entries.getKey(), entries.getValue()));
		}
	    }
	}
	this.table = newTable;

    }

    private int generatePrime(int i) {
	boolean testPrime = false;
	int prime = 2 * i - 1;
	while (!testPrime) {
	    prime++;
	    if (prime % Math.sqrt(prime) == 0) {
		continue;
	    } else {
		int division = 2;
		while (division < prime) {
		    if ((prime % division) != 0 && !(division < Math.sqrt(prime))) {
			testPrime = true;
			break;
		    } else {
			division++;
		    }
		}
	    }
	}
	return prime;
    }
}
