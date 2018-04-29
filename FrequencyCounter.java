import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class TextGenerator {

    public static void main(String[] args) throws FileNotFoundException {
	// TODO Auto-generated method stub
	// @@@@ added reading from the command line.
	// @@@@ Changed variable String fileName to String file to comply with the lab
	// instructions.
	int k = Integer.parseInt(args[0]);
	int M = Integer.parseInt(args[1]);
	String file = args[2];

	// @@@@ file becomes fileReader.
	try {
	    FileReader fileReader = new FileReader(file);

	    MyHashMap<String, StringBuffer> mMap = FrequencyCounter.generateMap(k, file);
	    StringBuffer starter = new StringBuffer();
	    for (int j = 0; j < k; j++) {

		// @@@@ added (char) to convert int to char.
		starter.append((char) fileReader.read());
	    }

	    String key = starter.toString();
	    // ???? I don't understand what output is for.
	    // @@@@ changed this while loop to if block because the console is printing
	    // floppyflopp floppyflopp for M = 10.
	    if (mMap.get(key) != null) {
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

		    // @@@@ Changed this from (wordLength - k, wordLength) to (wordLength - k).
		    key = starter.substring(wordLength - k);
		}
		System.out.print(starter + " ");

	    }
	    System.out.println();
	} catch (FileNotFoundException e) {
	    System.err.println(file + " is not found.");
	    System.exit(2);
	} catch (IOException e) {
	    System.err.println("Error reading from file " + file + ": " + e.getMessage());
	    System.exit(4);
	}
    }
}
