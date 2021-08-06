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
            DriverManager.getConnection("");
        } catch (Exception ex) {
            // handle the error
        }
    }

}
