import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class FrequencyCounter {
//    public static MyHashMap<StringBuffer, StringBuffer> generateMap (int k, String file){
//	//TODO: Implement this.
//    }
//    
//    public static String fileName() {
//	//TODO: Implement this.
//    }
	public static void main(String[] args) {
		MyHashMap<String, StringBuffer> mMap = new MyHashMap<String, StringBuffer>();
		int k  = Integer.parseInt(args[0]);
		System.out.print("Enter your file name: ");
		Scanner input = new Scanner(System.in);
		String inputFileName = input.next();
		
		
		int nextChar;
		StringBuffer key = new StringBuffer();
		try {
			FileReader reader = new FileReader(inputFileName);
			// TODO: add exception handling for k values larger than string length.
			for (int i = 0; i < k; i++) {
				key.append((char)reader.read());
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
		} catch (FileNotFoundException e){
			System.err.println(inputFileName + " is not found.");
		} catch (IOException e) {
			System.err.println("Error reading from file " + inputFileName +
					": " + e.getMessage());
		}
		
		System.out.println(mMap.size() + " distinct keys:");
		Iterator<Map.Entry<String, StringBuffer>> it = mMap.entries();
		while (it.hasNext()) {
			Map.Entry<String, StringBuffer> entry = it.next();
			StringBuffer values = entry.getValue();
			System.out.println(values.length() + " " + entry.getKey());			
		}
	}

}
