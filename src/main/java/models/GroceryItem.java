package models;

public class GroceryItem
{
    private Integer id;
    private String name;
    private Integer quantity;
    private Boolean inCart;
    private Integer listId;

    public GroceryItem()
    {

    }

    public GroceryItem(String name, Integer quantity, Integer listId)
    {
        this.name = name;
        this.quantity = quantity;
        this.listId = listId;
    }

    public GroceryItem(Integer id, String name, Integer quantity, Boolean inCart, Integer listId)
    {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.inCart = inCart;
        this.listId = listId;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getQuantity()
    {
        return quantity;
    }

    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }

    public Boolean getInCart()
    {
        return inCart;
    }

    public void setInCart(Boolean inCart)
    {
        this.inCart = inCart;
    }

    public Integer getListId()
    {
        return listId;
    }

    public void setListId(Integer listId)
    {
        this.listId = listId;
    }

    @Override
    public String toString()
    {
        return "GroceryItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", inCart=" + inCart +
                ", listId=" + listId +
                '}';
    }
}
