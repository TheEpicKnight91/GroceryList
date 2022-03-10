package models;

public class GroceryList
{
    private Integer id;
    private String name;
    private Integer userId;

    public GroceryList()
    {

    }

    public GroceryList(String name, Integer id)
    {
        this.id = null;
        this.name = name;
        this.userId = id;
    }

    public GroceryList(Integer id, String name, Integer userId)
    {
        this.id = id;
        this.name = name;
        this.userId = userId;
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

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    @Override
    public String toString()
    {
        return "GroceryList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                '}';
    }
}
