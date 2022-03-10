import models.GroceryItem;
import models.GroceryList;
import models.User;
import repositories.*;

public class MainDriver
{
    public static void main(String[] args)
    {
        UserDAO userDAO = new UserDAOImpl();
        GroceryListDAO groceryListDAO =  new GroceryLIstDAOImpl();
        GroceryItemDAO groceryItemDAO = new GroceryItemDAOImpl();
        //userDAO.createUser(new User("kev123", "pass123", "Kevin", "Childs"));
        //System.out.println(userDAO.getUserGivenUsername("kev123"));

        //groceryListDAO.createList(new GroceryList("Costco",5));

        //groceryListDAO.deleteList(5);

        //groceryItemDAO.createItemForListWithOutQuantity(new GroceryItem("Banana", null, 6));

        //groceryItemDAO.createItemForListWithQuantity(new GroceryItem("Grapes", 12, 6));

        //groceryItemDAO.markItemInCart(3);

        groceryItemDAO.deleteItemFromList(3);
        System.out.println(groceryItemDAO.getAllItemsGivenListId(6));
    }
}
