package org.olddriver.learnjava.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=Hongkong","root","123456");

            System.out.println(connection);
        } catch (Exception ex) {
            // handle the error

            ex.printStackTrace();
        }
    }

}
