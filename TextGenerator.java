import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TextGenerator {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner input = new Scanner(System.in);
	System.out.println("Enter the order of the Markov Model (k): ");
	String k = input.next();
	System.out.println("Enter the number of characters to generate (M): ");
	int M = input.nextInt();
	String[] argument = new String[] { k };
	// FrequencyCounter main = FrequencyCounter.main(argument);
	// MyHashMap<StringBuffer, StringBuffer> mMap = main.generateMap();
	// FileReader file = new FileReader(main.fileName());
	ArrayList<StringBuffer> output = new ArrayList<StringBuffer>();
	StringBuffer starter = new StringBuffer();
	for (int j = 0; j < Integer.parseInt(k); j++) {
	    starter.append(file.reader());
	}
	int wordLength = 2;
	if (wordLength < M) {
	    String key = starter.toString();
	    StringBuffer sChars = mMap.get(key);
	    Random rand = new nextInt(sChar.size());

	}

    }

}
