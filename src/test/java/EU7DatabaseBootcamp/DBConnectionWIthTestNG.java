package EU7DatabaseBootcamp;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.sql.*;

public class DBConnectionWIthTestNG {

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    String query = "select name from spartans";
    @BeforeMethod
    public void connectToDB() throws SQLException {
        connection = DriverManager.getConnection(ConfigurationReader.get("spartan.DBUrl"),
                ConfigurationReader.get("spartan.DBusername"), ConfigurationReader.get("spartan.DBpassword"));
        statement = connection.createStatement();
        resultSet = statement.executeQuery(query);
    }

    @AfterMethod
    public void closeDBConnections() throws SQLException {
        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test
    public void Test1(){

    }

}
