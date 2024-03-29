/*
This program will find a word or sentence in a .txt file you want to search and will output the line number,index (start)
of the word and print out the entire line the target word occurs on.

in order to run this open terminal(mac) or commad line (windows) and cd into the file that the program is on, then enter 
"java fileSearch "word or sentence you like the search" file-you-want-to-search.txt"  also the .txt file had to be in the same
folder as the program
*/
package fileSearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class fileSearch {

	public static void main(String[] args) throws FileNotFoundException {
		String target = args[0];
		String fileName = args[1];
		
		File file = new File(fileName);
		Scanner inputFile = new Scanner(file);
	
		int lineNum = 0;  // need int variable to keep track of line number
		
		while(inputFile.hasNextLine()) {
		    String line = inputFile.nextLine();
		    lineNum++;
		    
		    int index = 0;  //need int variable to keep track of index
			
			while(line.indexOf(target, index) != -1) {
				index = line.indexOf(target, index); //indexOf returns the first match found				
				System.out.println(lineNum + ":" + index + "\t" + line);				
				index += target.length();  //increase the index by the length of the target string in order to search the remaining part of the line after the match
		   
			}
		inputFile.close();
		}
	}
}
