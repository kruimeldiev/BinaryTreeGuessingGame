package com.casperdaris.netwerk;

import com.casperdaris.model.BinaryTree;
import com.casperdaris.model.Node;

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

    public static BinaryTree BoomLaden() {

        BinaryTree boom = new BinaryTree();

        boom.setRoot(NodeLaden(1));

        boom.setHuidigeNode(boom.getRoot());

        return boom;
    }

    public static Node NodeLaden(int nodeId) {

        Node returnNode = new Node("");

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(DataKeys.CONN_URL, DataKeys.CONN_USER, DataKeys.CONN_PASS);
            String query = "SELECT * FROM \"public\".\"nodes\" where node_id = " + nodeId;
            Statement stat = conn.createStatement();
            ResultSet result = stat.executeQuery(query);
            while (result.next()) {
                returnNode = new Node(result.getString("node_data"));
                if (result.getInt("left_child") > 0) {
                    returnNode.setLeft_id(result.getInt("left_child"));
                } else {
                    returnNode.setLeft_id(null);
                }
                if (result.getInt("right_child") > 0 ) {
                    returnNode.setRight_id(result.getInt("right_child"));
                } else {
                    returnNode.setRight_id(null);
                }
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return returnNode;
    }
}
