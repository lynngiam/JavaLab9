import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Iterator;

import org.junit.Test;

public class MyHashMapTest {

    @Test
    public void testPut() {
	System.out.println("Test");
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
	test.put("D", 5);
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
	fail("Not yet implemented");
    }

    @Test
    public void testGeneratePrime() {
	MyHashMap<String, Integer> test = new MyHashMap<String, Integer>();
	assertEquals("Next prime: ", 23, test.generatePrime(11));
    }

    @Test
    public void testResize() {
	fail("Not yet implemented");
    }

}
