import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyHashMap<K, V> implements MapADT<K, V> {
    LinkedList<Map.Entry<K, V>>[] table;
    int size; // current number of items in the table (not number of buckets)
    private int capacity;
    float maxLoadFactor;

    MyHashMap(int capacity, float maxLoadFactor) {
	this.maxLoadFactor = maxLoadFactor;
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
	boolean keyPresent = false;
	if (value == null || key == null) { // if value or key is null, throw exception
	    throw new NullPointerException();
	}
	int hashKey = hash(key);
	for (Map.Entry<K, V> entries : table[hashKey]) {
	    if (entries.getKey().equals(key)) {
		keyPresent = true;// if key is present
		retValue = entries.getValue();
		entries.setValue(value);
	    } // set new value
	}
	if (!keyPresent) {
	    table[hashKey].add(new AbstractMap.SimpleEntry<K, V>(key, value)); // create new node for key and value pair
	    size++; // increment size
	}

	// TODO write resize when maxLoadFactor is met
	float currentLoadFactor = (float) size / capacity;
	if (currentLoadFactor > maxLoadFactor) {
	    resize();
	}

	return retValue; // return original value; null if key is not present

    }

    public V get(K key) {
	// TODO Auto-generated method stub
	V retValue = null;
	int hashKey = hash(key);
	for (Map.Entry<K, V> entries : table[hashKey]) {
	    if (entries.getKey().equals(key)) { // check if key is present
		retValue = entries.getValue(); // get original value
	    }
	}
	return retValue;
    }

    public boolean isEmpty() {
	// TODO Auto-generated method stub
	if (size == 0) {
	    return true;
	}
	return false;
    }

    public void clear() {
	// TODO Auto-generated method stub
	for (int i = 0; i < table.length; i++) {
	    table[i].clear();
	}
	size = 0;
    }

    public int size() {
	// TODO Auto-generated method stub
	return size;
    }

    public String toString() {
	String s;
	List<String> toStringList = new ArrayList<String>();
	toStringList.add("");
	for (int i = 0; i < table.length; i++) {
	    if (table[i] != null) {
		for (Map.Entry<K, V> entries : table[i]) {
		    s = "Hash code: " + i + " | Keys: " + entries.getKey() + " | Value: " + entries.getValue() + "\n";
		    toStringList.add(s);
		}
	    }
	}
	return toStringList.toString().replace(",", "").replace("[", "").replace("]", "");
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

    public Iterator<Map.Entry<K, V>> entries() {
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
	for (int i = 0; i < newTable.length; i++) {
	    newTable[i] = new LinkedList<Map.Entry<K, V>>();
	}
	for (int i = 0; i < table.length; i++) {
	    if (!table[i].isEmpty()) {
		for (Map.Entry<K, V> entries : table[i]) {
		    int newHashKey = hash(entries.getKey());
		    newTable[newHashKey].add(new AbstractMap.SimpleEntry<K, V>(entries.getKey(), entries.getValue()));
		}
	    }
	}
	this.table = newTable;

    }

    private int generatePrime(int i) {
	int result = 0;
	int[] primeList = new int[] { 11, 23, 47, 97, 197, 397, 797, 1597, 3203, 6421, 12853, 25717, 51437, 102877,
		205759, 411527, 823117, 1646237, 3292489, 6584983, 13169977, 26339969, 52679969, 105359939, 210719881,
		421439783, 842879579, 1685759167 };
	for (int compare : primeList) {
	    if (compare > 2 * i) {
		result = compare;
		break;
	    }
	}
	return result;
    }

    private int hash(K key) {
	int hashKey = Math.abs(key.hashCode()) % capacity;
	return hashKey;
    }
}
