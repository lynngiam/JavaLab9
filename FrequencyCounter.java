import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class FrequencyCounter {

    public static MyHashMap<String, StringBuffer> generateMap(int k, String file) {
	MyHashMap<String, StringBuffer> mMap = new MyHashMap<String, StringBuffer>();

	int nextChar;
	StringBuffer key = new StringBuffer();
	try {
	    FileReader reader = new FileReader(file);
	    // TODO: add exception handling for k values larger than string length.
	    for (int i = 0; i < k; i++) {
		key.append((char) reader.read());
		if (key.charAt(key.length() - 1) == (char) -1) {
		    System.err.println("k exceeds file string length.");
		    break;
		}
	    }

	    while ((nextChar = reader.read()) != -1) {
		char currentChar = (char) nextChar;

		String keyString = key.toString();
		if (mMap.get(keyString) == null) {
		    StringBuffer value = new StringBuffer();
		    value.append(currentChar);
		    mMap.put(keyString, value);
		} else {
		    mMap.get(keyString).append(currentChar);
		}
		// Update key by removing the first char and adding new char.
		key.deleteCharAt(0);
		key.append(currentChar);
	    }
	} catch (FileNotFoundException e) {
	    System.err.println(file + " is not found.");
	    System.exit(2);
	} catch (IOException e) {
	    System.err.println("Error reading from file " + file + ": " + e.getMessage());
	    System.exit(4);
	}

	return mMap;
    }

    public static void main(String[] args) {
	int k = Integer.parseInt(args[0]);
	System.out.print("Enter your file name: ");
	Scanner input = new Scanner(System.in);
	String inputFileName = input.next();

	MyHashMap<String, StringBuffer> mMap = generateMap(k, inputFileName);

	System.out.println(mMap.size() + " distinct keys");
	Iterator<Map.Entry<String, StringBuffer>> it = mMap.entries();
	while (it.hasNext()) {
	    Map.Entry<String, StringBuffer> entry = it.next();
	    StringBuffer values = entry.getValue();
	    System.out.println(values.length() + " " + entry.getKey());
	}
    }

}
