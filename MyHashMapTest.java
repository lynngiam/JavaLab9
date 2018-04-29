import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;

public class MyHashMapTest {

    @Test
    public void testPut() {
	MyHashMap<String, Integer> test = new MyHashMap<String, Integer>(10, (float) 0.5);
	HashMap<String, Integer> standard = new HashMap<String, Integer>(10, (float) 0.5);
	test.put("A", 1);
	test.put("B", 2);
	test.put("D", 4);
	standard.put("A", 1);
	standard.put("B", 2);
	standard.put("D", 4);
	Iterator<String> itKeys = test.keys();
	while (itKeys.hasNext()) {
	    assertTrue(standard.containsKey(itKeys.next()));
	}
	// if put() method replaces an existing value
	assertEquals("Returned value: ", 4, (int) test.put("D", 5));
	standard.put("D", 5);
	assertEquals("Changed value: ", standard.get("D"), test.get("D"));

    }

    @Test
    public void testGet() {
	MyHashMap<String, Integer> test = new MyHashMap<String, Integer>(10, (float) 0.5);
	HashMap<String, Integer> standard = new HashMap<String, Integer>(10, (float) 0.5);
	test.put("A", 1);
	test.put("B", 2);
	test.put("D", 4);
	standard.put("A", 1);
	standard.put("B", 2);
	standard.put("D", 4);
	assertEquals("Value: ", standard.get("A"), test.get("A"));
    }

    @Test
    public void testIsEmpty() {
	MyHashMap<String, Integer> test = new MyHashMap<String, Integer>(10, (float) 0.5);
	HashMap<String, Integer> standard = new HashMap<String, Integer>(10, (float) 0.5);
	assertEquals("Size: ", standard.size(), test.size());
    }

    @Test
    public void testClear() {
	MyHashMap<String, Integer> test = new MyHashMap<String, Integer>(10, (float) 0.5);
	HashMap<String, Integer> standard = new HashMap<String, Integer>(10, (float) 0.5);
	test.put("A", 1);
	test.put("B", 2);
	test.put("D", 4);
	test.clear();
	standard.put("A", 1);
	standard.put("B", 2);
	standard.put("D", 4);
	standard.clear();
	assertEquals("Size: ", standard.size(), test.size());

    }

    @Test
    public void testSize() {
	MyHashMap<String, Integer> test = new MyHashMap<String, Integer>(10, (float) 0.5);
	HashMap<String, Integer> standard = new HashMap<String, Integer>(10, (float) 0.5);
	test.put("A", 1);
	test.put("B", 2);
	test.put("D", 4);
	standard.put("A", 1);
	standard.put("B", 2);
	standard.put("D", 4);
	assertEquals("Size: ", standard.size(), test.size());
	assertEquals("Size: ", 3, test.size());
    }

    @Test
    public void testToString() {
	MyHashMap<String, Integer> test = new MyHashMap<String, Integer>(10, (float) 0.5);
	test.put("A", 1);
	test.put("B", 2);
	test.put("D", 4);
	assertEquals("Convert to string: ", " Hash code: 5 | Keys: A | Value: 1\n"
		+ " Hash code: 6 | Keys: B | Value: 2\n" + " Hash code: 8 | Keys: D | Value: 4\n" + "",
		test.toString());
    }

    @Ignore
    @Test
    public void testGeneratePrime() { // tested this method by converting method to public
	MyHashMap<String, Integer> test = new MyHashMap<String, Integer>();
	// assertEquals("Next prime: ", 23, test.generatePrime(11));
	// assertEquals("Next prime: ", 47, test.generatePrime(23));
    }

    @Test
    public void testResize() {
	MyHashMap<String, Integer> test = new MyHashMap<String, Integer>(10, (float) 0.5);
	HashMap<String, Integer> standard = new HashMap<String, Integer>(10, (float) 0.5);
	test.put("A", 1);
	test.put("B", 2);
	test.put("C", 3);
	test.put("D", 4);
	test.put("E", 5);
	test.put("F", 6);
	test.put("G", 7);
	standard.put("A", 1);
	standard.put("B", 2);
	standard.put("C", 3);
	standard.put("D", 4);
	standard.put("E", 5);
	standard.put("F", 6);
	standard.put("G", 7);
	Iterator<String> itKeys = test.keys();
	while (itKeys.hasNext()) {
	    assertTrue(standard.containsKey(itKeys.next()));
	}
	assertEquals("Size: ", standard.size(), test.size());
	assertEquals("Size: ", 7, test.size());
    }

    @Test
    public void testIterator() {
	MyHashMap<String, Integer> test = new MyHashMap<String, Integer>(10, (float) 0.5);
	HashMap<String, Integer> standard = new HashMap<String, Integer>(10, (float) 0.5);
	test.put("A", 1);
	test.put("B", 2);
	test.put("D", 4);
	standard.put("A", 1);
	standard.put("B", 2);
	standard.put("D", 4);
	// Test keys iterator
	Set<String> standardKeys = standard.keySet();
	Iterator<String> itStandardKeys = standardKeys.iterator();
	Iterator<String> itTestKeys = test.keys();
	while (itTestKeys.hasNext()) {
	    assertEquals("Keys: ", itStandardKeys.next(), itTestKeys.next());
	}
	// Test entries iterator
	Set<Map.Entry<String, Integer>> standardEntries = standard.entrySet();
	Iterator<Map.Entry<String, Integer>> itStandardEntries = standardEntries.iterator();
	Iterator<Map.Entry<String, Integer>> itTestEntries = test.entries();
	while (itTestEntries.hasNext()) {
	    assertEquals("Entries: ", itStandardEntries.next(), itTestEntries.next());
	}

    }

}
