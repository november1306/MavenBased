package sql;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class MySqlTest {
    Logger log = LoggerFactory.getLogger(MySqlTest.class);


    @Test
    void dbConnectionTest() throws SQLException {
        /**
         * edit this URL credentials to match your DB
         */
        String url = "jdbc:mysql://127.0.0.1:3306/hl";
        String user = "root";
        String password = "Qq74108520-";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null)
                log.info("connected to the db");


            log.info("add new User to 'user' table");
            Statement statement = connection.createStatement();
            int rs = statement.executeUpdate("INSERT INTO `hl`.`user`" +
                    "(`username`," +
                    "`email`," +
                    "`password`," +
                    "`create_time`)" +
                    "VALUES" +
                    "('German'," +
                    "'aaaar@mail.com'," +
                    "12345," +
                    "current_timestamp());");

            log.info("inserted " + rs);


            log.info("print content of 'user' table");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM hl.user");
            while (resultSet.next()) {
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    if (i > 1) ;// System.out.print(",  ");
                    String columnValue = resultSet.getString(i);
                    System.out.println(resultSet.getMetaData().getColumnName(i) + " " + columnValue);

                }
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connection.close();
        }

    }

}
