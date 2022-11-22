import java.lang.*;
import java.io.*;
import java.util.*;


public class WordCompositionProblem {

	public static final int FACTOR_SEC = (int)1e9;
	public static final int FACTOR_MSEC = (int)1e6;

	public static void main(String[] args) throws FileNotFoundException {
		// for execution time.
		long programStart = System.nanoTime();

		// initiating words array for input
		ArrayList<String> words = new ArrayList<>();
		System.out.println("Enter 1 for Input_01 file");
		System.out.println("Enter 2 for Input_02 file");
		Scanner in = new Scanner(System.in);
		Scanner sc = null;
		File fl;
		int inputFile = in.nextInt();

		// reading input from file
		switch(inputFile){
		case 1:
			fl = new File("./Input_01.txt");
			sc = new Scanner(fl);
			break;
		case 2:
			fl = new File("./Input_02.txt");
			sc = new Scanner(fl);
			break;
		}
		while (sc != null && sc.hasNextLine()) {
			words.add(sc.nextLine());
		}
		System.out.println("Wait for few second");
		
		// tracking longest and second longest compounded word
		String longCompSeq = "";
		String scndLongCompSeq = "";

		// checking for each word in words list
		for (String chkStr : words) {

			if (chkStr.length() > scndLongCompSeq.length()) {

				// check wether the word is a compounded sequence or not
				Boolean isCompSeq = isCompoundedSeq(chkStr, words);

				// check if the word is longest & second longest compounded sequence
				if (isCompSeq && chkStr.length() > longCompSeq.length()) {

					scndLongCompSeq = longCompSeq;
					longCompSeq = chkStr;

				} else if ( (isCompSeq
				              && chkStr.length() > scndLongCompSeq.length())
				             && (scndLongCompSeq.length() < longCompSeq.length()) ) {

					scndLongCompSeq = chkStr;

				}
			}

		}
		System.out.println("Longest Compounded Word : " );
		System.out.println(longCompSeq);	
		System.out.println("Second Longest Compounded Word : " );
		System.out.println(scndLongCompSeq);	

		long programEnd = System.nanoTime();
		System.out.println("Time for Execution is : " 
			+ (programEnd - programStart)/FACTOR_SEC
			+ "sec "
			+ (programEnd - programStart)/FACTOR_MSEC
			+ "ms");
	}
	
	static boolean isCompoundedSeq(String chkStr, ArrayList<String> words) {

		// List, will be containing words from which compounded words are made
		ArrayList<String> trackCompoundWords = new ArrayList<>();
		
		// String singleWord = "";
		StringBuilder singleWord = new StringBuilder();
		int pos = 0;
		int totalLength = 0;

		// iterating till the words length
		while (pos < chkStr.length()) {

			// check wether current word is a singleWord
			// if it is add it to trackCompoundWords
			singleWord.append(chkStr.charAt(pos));
			if (words.contains(singleWord.toString())) {

				trackCompoundWords.add(singleWord.toString());
				singleWord.delete(0, singleWord.length());
				pos++;

			} else if (   (pos + 1 == chkStr.length())
			              && (trackCompoundWords.size() > 0
			              && !words.contains(singleWord.toString()))) {

				int skipPos = 0;
				singleWord.delete(0, singleWord.length());
				singleWord.append(trackCompoundWords.get(trackCompoundWords.size()-1));
				for (String word : trackCompoundWords) {
					skipPos += word.length();
				}
				pos = skipPos;
				trackCompoundWords.remove(trackCompoundWords.size()-1);

			} else {
				pos++;
			}
		}

		// check the total length of the each word in array
		// if it is equal to the given chkStr
		for (String word : trackCompoundWords) {
			totalLength += word.length();
		}

		return (totalLength == chkStr.length())
		       && (trackCompoundWords.size() > 1);
	}
}