package bugelli;

/**
* Sales Item: Name, cost, and how many
*
* @author  Lauren Bugelli
* @version 1.0
* @since   09-13-2020 
* 
*/
public class SalesItem {
	/**
	 * Item's name.
	 */
	public String name;
	/**
	 * Item's cost.
	 */
	public double cost;
	/**
	 * Quantity of Item in cart
	 */
	public int quant;
	/**
	 * Returns a "pretty" list of items in the cart
	 * @return
	 */
	public String toFinalString() {
		return name + "\t" + "$" + Double.toString(cost) + "\t" + Integer.toString(quant) + "\n";
	}	
}
