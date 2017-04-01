/**
 * Created by cristobalvega on 4/1/17.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {

    public Connection Connect() {
        try {
            Connection conn =  DriverManager.getConnection("jdbc:mariadb://localhost:3306/bdvironchi?user=root&password=1234");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }//Constructor

}//Clas
