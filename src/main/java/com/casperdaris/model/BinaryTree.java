package com.casperdaris.model;

public class BinaryTree {

    private Node root, huidigeNode;

    public BinaryTree() {
        root = null;
        huidigeNode = null;
    }

    public void setRoot(Node node) {
        this.root = node;
    }

    public Node getRoot() {
        return root;
    }

    public void setHuidigeNode(Node node) {
        this.huidigeNode = node;
    }

    public Node getHuidigeNode() {
        return huidigeNode;
    }

    // Functie om een gehele boom in Pre-Order volgorde uit te printen
    public static void printPreOrder(Node node) {

        // Base case aanmaken
        if (node == null) {
            return;
        }

        System.out.println(node.getData() + " ");
        printPreOrder(node.getLeft());
        printPreOrder(node.getRight());
    }

    // Functie om een gehele boom in Post-Order volgorde uit te printen
    public static void printPostorder(Node node) {

        if(node == null) {
            return;
        }

        printPostorder(node.getLeft());
        printPostorder(node.getRight());
        System.out.print(node.getData() + " ");
    }

    // Functie om een gehele boom In-Order volgorde uit te printen
    public void printInorder(Node node) {

        if(node == null) {
            return;
        }

        printInorder(node.getLeft());
        System.out.print(node.getData() + " ");
        printInorder(node.getRight());
    }

}
