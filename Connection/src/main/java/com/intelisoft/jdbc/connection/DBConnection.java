package com.intelisoft.jdbc.connection; /**
 * Created by Pavel on 09.07.2017.
 */

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;



public  class DBConnection {
    private static final Logger logger = Logger.getLogger(DBConnection.class);
    static Connection conn = null;
    private DBConnection(){
    }
    public static Connection getDBConnection() {
        try {
            if (conn == null) {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?verifyServerCertificate=false&useSSL=true", "root","root");
            }
        } catch (Exception e) {
           logger.error("Connection Error", e);
        }
        return conn;
    }
}
