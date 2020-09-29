package com.casperdaris.netwerk;

import com.casperdaris.model.BinaryTree;
import com.casperdaris.model.Node;

import javax.swing.plaf.nimbus.State;
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

    public static void NodeLaden() {

        Node returnNode;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(DataKeys.CONN_URL, DataKeys.CONN_USER, DataKeys.CONN_PASS);
            String query = "SELECT * FROM \"public\".\"nodes\" where node_id = 1";
            Statement stat = conn.createStatement();
            ResultSet result = stat.executeQuery(query);
            while (result.next()) {
                returnNode = new Node(result.getString("node_data"));
                System.out.println(returnNode.getData());
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
