package com.casperdaris;

public class Node {

    private String data;
    private Node left, right;

    public Node(String data) {
        this.data = data;
        left = null;
        right = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node node) {
        if (left == null) {
            this.left = node;
        }
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node node) {
        if (right == null) {
            this.right = node;
        }
    }

    public boolean isLeaf() {
        return (left == null) && (right == null);
    }
}
