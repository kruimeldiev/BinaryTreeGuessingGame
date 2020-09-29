package com.casperdaris.netwerk;

import java.sql.*;

public class DatabaseHelper {

    public static void ConnectieMaken() {

        try {

            Class.forName("org.postgresql.Driver");

            Connection conn = DriverManager.getConnection(DataKeys.CONN_URL, DataKeys.CONN_USER, DataKeys.CONN_PASS);

            if (conn != null) {
                System.out.println("Connectie met database gemaakt");
            } else {
                System.out.println("Geen database connectie mogelijk");
            }

            conn.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
