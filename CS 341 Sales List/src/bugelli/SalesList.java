package bugelli;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
/**
* Sales List: Main class that will run a calculator app to show prices and totals in your cart
*
* @author  Lauren Bugelli
* @version 1.0
* @since   09-13-2020 
* 
*/
public class SalesList {

	private JFrame frame;
	private JTextField textItem;
	private JTextField textCost;
	private JTextField textQ;
	private JButton btnAdd;
	private JTextArea textCartOutput;
	private JTextArea textTotalOutput;
	private Double total = 0.00;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesList window = new SalesList();
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
	public SalesList() {
		initialize();
		createEvents();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitleLabel = new JLabel("Shopping Cart");
		lblTitleLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		lblTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleLabel.setBounds(95, 11, 253, 22);
		frame.getContentPane().add(lblTitleLabel);
		
		JLabel lblItemLabel = new JLabel("Item:");
		lblItemLabel.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		lblItemLabel.setBounds(10, 36, 65, 14);
		frame.getContentPane().add(lblItemLabel);
		
		JLabel lblCostLabel = new JLabel("Cost: $");
		lblCostLabel.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		lblCostLabel.setBounds(10, 61, 65, 14);
		frame.getContentPane().add(lblCostLabel);
		
		JLabel lblQLabel = new JLabel("Quantity: ");
		lblQLabel.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		lblQLabel.setBounds(10, 92, 83, 14);
		frame.getContentPane().add(lblQLabel);
		
		textItem = new JTextField();
		textItem.setBounds(154, 33, 203, 20);
		frame.getContentPane().add(textItem);
		textItem.setColumns(10);
		
		textCost = new JTextField();
		textCost.setBounds(154, 58, 154, 20);
		frame.getContentPane().add(textCost);
		textCost.setColumns(10);
		
		textQ = new JTextField();
		textQ.setBounds(154, 89, 116, 20);
		frame.getContentPane().add(textQ);
		textQ.setColumns(10);
		
		btnAdd = new JButton("Add Item to Shopping Cart");
		btnAdd.setFont(new Font("Sitka Small", Font.PLAIN, 11));
		btnAdd.setBounds(131, 120, 189, 23);
		frame.getContentPane().add(btnAdd);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 154, 414, 64);
		frame.getContentPane().add(scrollPane);
		
		textCartOutput = new JTextArea();
		textCartOutput.setColumns(3);
		textCartOutput.setRows(100);
		scrollPane.setViewportView(textCartOutput);
		
		JLabel lblTotalLabel = new JLabel("Total:");
		lblTotalLabel.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		lblTotalLabel.setBounds(10, 236, 65, 14);
		frame.getContentPane().add(lblTotalLabel);
		
		JScrollPane totalViewPane = new JScrollPane();
		totalViewPane.setBounds(151, 229, 130, 21);
		frame.getContentPane().add(totalViewPane);
		
		textTotalOutput = new JTextArea();
		totalViewPane.setViewportView(textTotalOutput);
	}
	/**
	 * Method to perform action of adding items to cart and producing a total
	 */
	private void createEvents() {
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buildOutput();
			}
		});
	}
	/**
	 * Method to produce output
	 */
	private void buildOutput() {
		
		//SalesItem Object 
		 
		SalesItem s1 = new SalesItem();
		s1.name = textItem.getText();
		s1.cost = Double.parseDouble(textCost.getText());
		s1.quant = Integer.parseInt(textQ.getText());
		
		
		//SalesSlip ArrayList
		 
		SalesSlip slip = new SalesSlip();
		slip.cart.add(s1);
		
		//Calculate total cost
		
		total += (s1.cost * s1.quant);
		new DecimalFormat("#.##").format(total);
		
		//Produce outputs for app
		
		textCartOutput.append(slip.getCart());
		
		textTotalOutput.setText(Double.toString(total));
		
	}
}
