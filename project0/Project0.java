import javax.swing.*;

public class Project0{
	
	public static void main(String[] args) {
	
		String inputWord;
		while(true){	
			// This line asks the user for input by popping out a single window
			// with text input
			inputWord = JOptionPane.showInputDialog(null, "Enter a word:");
		    	if(inputWord.equalsIgnoreCase("STOP")) System.exit(0);
		
			// Output to a JOptionPane window how many 'E' are in the input. 
			int eAmount = eTotal(inputWord);
			int EAmount = ETotal(inputWord);
			System.out.println("There are " + EAmount + " E's and " + eAmount + " e's in the input of " + inputWord);
		}
	} //main

	public static int ETotal(String findMe) {
	    int ECounter = 0;
	    for(int i=0; i < findMe.length(); i++){
		    if(findMe.charAt(i) == 'E') ECounter++;
		} return ECounter;
	}
	public static int eTotal(String findMe) {
	    int eCounter = 0;
	    for(int i=0; i < findMe.length(); i++){
		    if(findMe.charAt(i) == 'e') eCounter++;
		} return eCounter;
	}
} // class project 0

