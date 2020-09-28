package bugelli;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Window {

	private JFrame frame;
	private JTextField textField;
	JButton btnNewButton;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
		createEvent();
	}
	public void createEvent() {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buildOutput();
			}
		});
	}
	public void buildOutput() {
		ReadFile rf = new ReadFile();
		try {
			rf.pickMe();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		textField.setText("Mean: " + rf.finalM + "\nStandard Deviation: " + rf.finalSD);
		//textField.setText();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("File Chooser");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(165, 11, 147, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("This will give you mean and standard deviation of integers in a file");
		lblNewLabel_1.setBounds(47, 39, 377, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		btnNewButton = new JButton("Select File");
		btnNewButton.setBounds(177, 66, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 97, 414, 153);
		frame.getContentPane().add(scrollPane);
		
		textField = new JTextField();
		scrollPane.setViewportView(textField);
		textField.setColumns(10);
	}

}
