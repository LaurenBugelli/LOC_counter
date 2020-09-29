package bugelli;

import java.util.Scanner;

import javax.swing.JFileChooser;
/**
 * JFileChooser class to choose and read a file
 * @author Lauren
 * @since 9/27/20
 */
public class ReadFile {
	JFileChooser fileChooser = new JFileChooser();
	public String test;
	public int value;
	public Queue list;
	public String finalM;
	public String finalSD;
	public boolean good2go;
	public boolean backup;
	/**
	 * Method to read file and grab mean and sd from queue class
	 * @throws Exception will throw error if a file isn't selected
	 */
	public void pickMe() throws Exception{
		//TEST IF A FILE IS SELECTED
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			//GET FILE
			java.io.File file = fileChooser.getSelectedFile();
			
			//SCANNER TO READ FILE TO QUEUE
			Scanner in = new Scanner(file);
			
			
		
			//TEST FILE LENGTH AND PRINT REASON TO CONSOL
			if(file.length() == 0) {		
				System.out.println("File is empty");
				good2go = false;
			}else if (file.length() == 1) {
				System.out.println("File has only one line");
				good2go = false;
			}else
				good2go = true;
			
			//CREATE QUEUE TO POPULATE WITH VALUES
			list = new Queue();
			//READ TEXT FROM FILE INTO QUEUE 
			while(in.hasNext()) {
				test = in.next();
			//TRY CATCH TO MAKE SURE INPUTS ARE VALID NUMBERS AND NO CHARS
			      try 
			        { 
			            Integer.parseInt(test); 
			            backup = true;
			        }  
			        catch (NumberFormatException e)  
			        { 
			            backup = false;
			        } 
			      value = Integer.parseInt(test);
			      //ADD VALID VALUE TO QUEUE
			      list.addNode(value);
			}
			
			in.close();
			
		}else {
			System.out.print("No File Selected");
		}
		
		//INT VALUE OF MEAN
		double mean = list.FindM();
		
		//STRING VALUES TO PRINT
		finalM = String.valueOf(list.FindM());
		finalSD = String.valueOf(list.findSD(mean));
		
	}
}
