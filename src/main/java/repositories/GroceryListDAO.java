package repositories;

import models.GroceryList;

import java.util.List;

public interface GroceryListDAO
{
    List<GroceryList> getAllListGivenUserId(Integer userId);

    void createList(GroceryList groceryList);

    void deleteList(Integer listId);
}
