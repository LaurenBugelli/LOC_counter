package bugelli;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import javax.swing.JFileChooser;
/**
 * The ReadFile class is used to read the file chosen and perform the needed counts. The only value passed to the main as of version 1 is the total count of executable lines 
 * @since 10/5/2020
 * @author Lauren Bugelli
 * @version 1
 */
public class ReadFile {
	JFileChooser fileChooser = new JFileChooser();
	//MADE VARIABLES OPEN SO THE MAIN COULD CALL AND SHOW THE OUTPUT TO USER IF DESIRED
	public int count;
	public int singleLineC;
	public int multiLineC;
	public int emptyLineC;
	public int countIfs;
	public int countFor;
	public int countWhile;
	public int countTry;
	public int countOpen;
	public int countClose;
	
	/**
	 * pickMe method handles if a file selected is the correct type
	 * @throws Exception
	 */
	public void pickMe() throws Exception{
		//TEST IF A FILE IS SELECTED
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			//GET FILE
			java.io.File file = fileChooser.getSelectedFile();
			//SEND FILE TO COUNTLINES
			countLines(file);
	
			
		}else {
			System.out.print("No File Selected");
		}
	}
	/**
	 * This method performs line count and counts comments as well as control structures
	 * @param file File this is the file being read in and the lines of which are being counted
	 * @return count int this will return the total number of executable lines of code
	 * @throws IOException
	 */
	public int countLines(File file) throws IOException {
	    InputStream br = new BufferedInputStream(new FileInputStream(file));
	    Scanner in = new Scanner(file);
	    try {
//READ AND COUNT EVERY LINE IN THE FILE AS FAST AND EFFICIENTLY AS POSSIBLE
	        byte[] c = new byte[1024];
	        Integer readChars = 0;
	        boolean endsWithoutNewLine = false; //Make sure every line is counted
	        while ((readChars = br.read(c)) != -1) {
	            for (int i = 0; i < readChars; ++i) {
	                if (c[i] == '\n')
	                    count++;
	              
	            }
	            endsWithoutNewLine = (c[readChars - 1] != '\n');
	        }
	        if(endsWithoutNewLine) {
	            count++;
	        }
//SUBTRACT COMMENTED LINES FROM TOTAL COUNT
   //USING A SEPERATE SCANNER TO PEFORM THIS ENSURES ACCURACY 
	        while(in.hasNextLine()){
	            String line = in.nextLine();
   //REMOVES EMPTY SPACES BEFORE LINES IN THE FILE
	            line = line.trim();
   //SUBTRACT FROM TOTAL IF LINE IS EMPTY
	            if(line.isEmpty()){
	                count--;
	                emptyLineC++;
   //SUBTRACT FROM TOTAL IF LINE IS A SINGLE LINE COMMENT
	            }else if (line.startsWith("//")) {
	            	singleLineC++;
	            	count--;
   //SUBTRACT FROM TOTAL IF LINE IS A MULTI LINE COMMENT -works if file code is correctly formated and variable names always appear first
	            }else if (line.startsWith("/*") || line.startsWith("*") || line.startsWith("*/")) {
	            	multiLineC++;
	            	count--;
	            }
//COUNT CONTROL STRUCTURES
	            if(line.startsWith("if") ||line.startsWith("else") || line.startsWith("else if")||line.startsWith("}else") || line.startsWith("}else if")) {
	            	countIfs++;
	            }else if (line.startsWith("for")) {
	            	countFor++;
	            }else if (line.startsWith("while") || line.startsWith("do")) {
	            	countWhile++;
	            }else if (line.startsWith("try")) {
	            	countTry++;
	            }
	        }
	        
//PRINT # AND TYPE OF CONTROL STRUCTURE TO CONSOLE
	        System.out.println("Try/Catch statements: " + countTry); //1
	        System.out.println("For statements: " + countFor); //1
	        System.out.println("While/Do statements: " + countWhile); //0
	        System.out.println("if statements: " + countIfs); //4
//PRINT NUMBER OF EMPTY AND COMMENTED OUT LINES TO CONSOLE
	        System.out.println("Empty Lines: " + emptyLineC); //22
	        System.out.println("Single Comment Lines: " + singleLineC); //4
	        System.out.println("Multi Comment Lines: " + multiLineC); //42
	        return count;
	    } finally {
	        br.close();
	        in.close();
	    }
	}
}
