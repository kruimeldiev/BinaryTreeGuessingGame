package com.casperdaris;

public class BTController {

    public static Node boomMaken() {

        Node root, child;

        // Instellen van de root node
        root = new Node("Is rood een van de clubkleuren?");

        // Instellen van de left child node
        child = new Node("Zit de club in de traditionele top 3?");
        child.setLeft(new Node("PSV"));
        child.setRight(new Node("AZ"));
        root.setLeft(child);

        // Instellen van de right child node
        child = new Node("Komt je club uit het noorden van het land?");
        child.setLeft(new Node("Groningen"));
        child.setRight(new Node("Vitesse"));
        root.setRight(child);

        return root;
    }

    public static void beginSpel() {
        printPreOrder(boomMaken());
    }

    public static void printPreOrder(Node node) {

        // Base case aanmaken
        if (node == null) {
            return;
        }

        System.out.println(node.getData());
        printPreOrder(node.getLeft());
        printPreOrder(node.getRight());
    }

}
