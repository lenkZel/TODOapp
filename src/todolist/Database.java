package todolist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private Connection connection;

    public Database(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoapp", "root","123456789");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void close(){
        try{
            //uzavretie spojenia s databazou
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}


