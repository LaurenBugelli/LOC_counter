package bugelli;

import java.util.ArrayList;

/**
* SalesSlip: Models the list of Items, using an ArrayList to store SalesItem objects
*
* @author  Lauren Bugelli
* @version 1.0
* @since   09-13-2020 
* 
*/
public class SalesSlip {
	/**
	 * ArrayList to hold Shopping Cart items, each item will be a SalesItem object
	 */
	ArrayList<SalesItem> cart = new ArrayList<SalesItem>(); 
	/**
	 * String holding each item name, price, and quantity
	 */
	String item = "";	
	/**
	 * Method that will call the "pretty" method in our item class to print out each item in arraylist
	 * @return
	 */
	public String getCart() {
		for (int i = 0; i < cart.size(); i++) {
		      item += (cart.get(i).toFinalString());
		    }
		return item;
	}
	
}


