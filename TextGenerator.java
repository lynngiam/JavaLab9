import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TextGenerator {

    public static void main(String[] args) throws FileNotFoundException {
	// TODO Auto-generated method stub
	Scanner input = new Scanner(System.in);
	System.out.println("Enter the order of the Markov Model (k): ");
	int k = input.nextInt();
	System.out.println("Enter the number of characters to generate (M): ");
	int M = input.nextInt();
	System.out.println("Enter the file name: ");
	String fileName = input.next();
	FileReader file = new FileReader(fileName);
	MyHashMap<String, StringBuffer> mMap = FrequencyCounter.generateMap(k, fileName);
	ArrayList<StringBuffer> output = new ArrayList<StringBuffer>();
	StringBuffer starter = new StringBuffer();
	for (int j = 0; j < k; j++) {
	    try {
		starter.append(file.read());
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	String key = starter.toString();
	while (mMap.get(key) != null) {
	    int wordLength = k;
	    while (wordLength < M) {
		if (mMap.get(key) == null) {
		    break;
		}
		StringBuffer sChars = mMap.get(key);
		Random rand = new Random();
		int randomIndex = rand.nextInt(sChars.length());
		starter.append(sChars.charAt(randomIndex));
		wordLength++;
		key = starter.substring(wordLength - k, wordLength);
	    }
	    output.add(starter);
	}
	for (StringBuffer word : output) {
	    System.out.print(word + " ");
	}
	System.out.println(".");

    }

}
