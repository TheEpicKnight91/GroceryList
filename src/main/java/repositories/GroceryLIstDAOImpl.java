package repositories;

import models.GroceryList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroceryLIstDAOImpl implements GroceryListDAO
{

    String url = "jdbc:postgresql://zs-fsj-db.cazgz2ad1khb.us-east-1.rds.amazonaws.com/grocerylist";
    String username = "postgres";
    String password = "p4ssw0rd";

    @Override
    public List<GroceryList> getAllListGivenUserId(Integer userId)
    {
        List<GroceryList> lists = new ArrayList<>();

        try
        {
            Connection conn = DriverManager.getConnection(url,username,password);
            String sql = "select * from lists where user_id_fk = ? order by list_id;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                lists.add(new GroceryList(rs.getInt(1),rs.getString(2),rs.getInt(3)));
            }
            return lists;
        }
        catch (SQLException sqle)
        {

        }
        return null;
    }

    @Override
    public void createList(GroceryList groceryList)
    {
        try
        {
            Connection conn = DriverManager.getConnection(url,username,password);
            String sql = "insert into lists (list_name, user_id_fk) values (?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,groceryList.getName());
            ps.setInt(2,groceryList.getUserId());

            ps.executeUpdate();
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
        }
    }

    @Override
    public void deleteList(Integer listId)
    {
        try
        {
            Connection conn = DriverManager.getConnection(url,username,password);
            String sql = "delete from lists where list_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,listId);

            ps.executeUpdate();
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
        }
    }
}
