package bugelli;

import java.util.Scanner;

import javax.swing.JFileChooser;

public class ReadFile {
	JFileChooser fileChooser = new JFileChooser();
	public int value;
	public Queue list;
	public String finalM;
	public String finalSD;
	
	public void pickMe() throws Exception{
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			//GET FILE
			java.io.File file = fileChooser.getSelectedFile();
			
			//SCANNER TO READ
			Scanner in = new Scanner(file);
			
			list = new Queue();
					
			//READ TEXT FROM FILE
			while(in.hasNextInt()) {
				value = in.nextInt();
				list.addNode(value);
			}
			
			in.close();
		}else {
			System.out.print("No File Selected");
		}
		
		double mean = list.FindM();
		finalM = String.valueOf(list.FindM());
		finalSD = String.valueOf(list.findSD(mean));
		
	}
}
