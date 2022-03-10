package repositories;

import models.GroceryItem;

import java.util.List;

public interface GroceryItemDAO
{
    List<GroceryItem> getAllItemsGivenListId(Integer ListId);

    void markItemInCart(Integer itemId);

    void createItemForListWithQuantity(GroceryItem item);

    void deleteItemFromList(Integer itemId);

    void createItemForListWithOutQuantity(GroceryItem item);
}
