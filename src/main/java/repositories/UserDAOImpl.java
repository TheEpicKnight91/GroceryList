package repositories;

import models.User;

import java.sql.*;


/*

What is JDBC?
    Java Database Connectivity
        - allows us to connect to a database and run sql commands

What is needed to connect to ou postgressql database on AWS using JDBC?
    - url (location of ou database)
        - syntax: jdbc:postgresql://[AWS_RDS_ENDPOINT]/[DATABASE_NAME]
    - username for our qws database
    - password for our aws database
    - driver (need

    Interfaces and classes of JDBC:
    - connection (interface) : active connection with the database
    - DriverManage : retrieves the connection from our database
    - Statement : object representation of the sql statement (does not prevent SQL injection)
        -PreparedStatement : object representation of the sql statement (prevents SQL injection)
    - Result set : object representation of the result set

    The most common errorI see connecting to JDBC is
        no suitable driver found
            - you dont have the driver
            - url string is incorrect
 */
public class UserDAOImpl implements UserDAO
{

    String url = "jdbc:postgresql://zs-fsj-db.cazgz2ad1khb.us-east-1.rds.amazonaws.com/grocerylist";
    String username = "postgres";
    String password = "p4ssw0rd";

    @Override
    public User getUserGivenUsername(String username)
    {
        User user = null;

        try
        {
            //DQL : Database Query language
            //retrieve active connection from our database
            Connection conn = DriverManager.getConnection(url,this.username,password);
            String sql = "select * from users where user_username = ?;";

            //preparing our sql statement
            PreparedStatement ps = conn.prepareStatement(sql);

            //we are adding the username into the question mark in the sql statement
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                user = new User(rs.getInt(1),rs.getString(2),
                                rs.getString(3),rs.getString(4),
                                rs.getString(5),rs.getTimestamp(6));
            }
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
        }
        return user;
    }

    @Override
    public void createUser(User user)
    {
        try
        {
            //DML: Database Manipulation
            Connection conn = DriverManager.getConnection(url,this.username,password);

            String sql = "insert into users (user_username, user_password, user_firstname, user_lastname) values (?, ?, ?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getFirstname());
            ps.setString(4,user.getLastname());

            ps.executeUpdate();
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
        }
    }
}
