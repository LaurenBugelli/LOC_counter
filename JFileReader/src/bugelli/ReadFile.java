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
	public int value;
	public Queue list;
	public String finalM;
	public String finalSD;
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
			
		
			//TEST FILE AND PRINT REASON OF ERROR TO CONSOL
			if(file.length() == 0) {		
				System.out.println("File is empty");
			}else if (file.length() < 2) {
				System.out.println("File holds only one value");
			}
			
			//CREATE QUEUE TO POPULATE WITH VALUES
			list = new Queue();
			//READ TEXT FROM FILE INTO QUEUE - only integers will be read correctly. 
			while(in.hasNextInt()) {
				value = in.nextInt();
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
