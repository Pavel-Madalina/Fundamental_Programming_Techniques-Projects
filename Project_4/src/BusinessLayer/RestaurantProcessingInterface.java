package business_layer;

import java.util.Date;
import java.util.List;

public interface RestaurantProcessingInterface {
	/**
	 * @param menuItem
	 * @pre menuItem.getId()>0 && menuItem.getName()!=null &&
	 *      menuItem.computePrice()!=0
	 * @pre @forall i : [0 .. getMenu().getSize()-1] @
	 *      (getMenu().get(i).getId()!=menuItem.getId())
	 * @post getMenu().size() == getMenu().size()@pre + 1
	 */
	public void addNewMenuItem(MenuItem menuItem);

	/**
	 * @param id
	 * @pre id > 0
	 * @pre getMenu().size() > 0
	 * @post getMenu().size() == getMenu().size()@pre - 1
	 */
	public void deleteMenuItem(int id);

	/**
	 * @param id
	 * @param newName
	 * @pre id > 0 && newName != null
	 * @pre getMenu().size() > 0
	 * @pre @exists i : [0 .. getMenu().size()-1] @ (getMenu().get(i).getId() == id)
	 * @pre @forall i : [0 .. getMenu().getSize()-1] @
	 *      (!getMenu().get(i).getName().equals(newName))
	 * @post @exists i : [0 .. getMenu().size()-1] @ (getMenu().get(i).getId() ==
	 *       id) && (getMenu().get(i).getName().equals(newName))
	 */
	public void editMenuItemName(int id, String newName);

	/**
	 * @param id
	 * @param newPrice
	 * @pre id > 0 && newPrice > 0
	 * @pre @exists i : [0 .. getMenu().size()-1] @ (getMenu().get(i).getId() == id)
	 * @post @exists i : [0 .. getMenu().size()-1] @ (getMenu().get(i).getId() ==
	 *       id) && (getMenu().get(i).computePrice() == newPrice)
	 */
	public void editMenuItemPrice(int id, float newPrice);

	/**
	 * @param idOrder
	 * @param date
	 * @param tableNumber
	 * @param items
	 * @pre idOrder > 0 && date != null && tableNumber > 0 && items != null
	 * @pre @forall entry : [getOrders().entrySet()] @ (entry.getKey().getId() !=
	 *      idOrder)
	 * @post getOrders().size() == getOrders().size()@pre + 1
	 * @post getOrders().containsKey(new Order(idOrder,date,tableNumber))
	 */
	public void createNewOrder(int idOrder, Date date, int tableNumber, List<MenuItem> items);

	/**
	 * @param idToDelete
	 * @pre idToDelete > 0
	 * @pre getOrders().size() > 0
	 * @post getOrders().size() == getOrders().size()@pre - 1
	 */
	public void deleteOrder(int idToDelete);

	/**
	 * @param orderID
	 * @pre orderID > 0
	 * @post @result > 0
	 */
	public float computePriceForOrder(int orderID);

	/**
	 * @param fileName
	 * @param orderID
	 * @pre fileName!=null && orderID > 0
	 * @post @nochange
	 */
	public void generateBill(String fileName, int orderID);
}