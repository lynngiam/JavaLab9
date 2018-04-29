import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class FrequencyCounter {

	public static void main(String[] args) {
		Map<StringBuffer, StringBuffer> mMap = new MyHashMap<String, StringBuffer>();
		int k  = Integer.parseInt(args[0]);
		System.out.print("Enter your file name: ");
		Scanner input = new Scanner(System.in);
		String inputFileName = input.next();
		
		
		int nextChar;
		char char1;
		char char2;
		char char3;
		try {
			FileReader reader = new FileReader(inputFileName);
			if ((nextChar = reader.read()) != -1) char1 = (char) nextChar;
			if ((nextChar = reader.read()) != -1) char2 = (char) nextChar;
			
			while ((nextChar = reader.read()) != -1) {
				char3 = (char) nextChar;
				StringBuffer key = new StringBuffer();
				key.append(char1);
				key.append(char2);
				StringBuffer value = new StringBuffer();
				value
			}
		} catch (FileNotFoundException e){
			System.err.println(inputFileName + " is not found.");
		} catch (IOException e) {
			System.err.println("Error reading from file " + inputFileName +
					": " + e.getMessage());
		}
	}

}
