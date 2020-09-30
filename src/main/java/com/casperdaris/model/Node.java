package com.casperdaris.model;

public class Node {

    private String data;
    private Node left, right;
    private Integer left_id, right_id;

    public Node(String data) {
        this.data = data;
        left = null;
        left_id = null;
        right = null;
        right_id = null;
    }

    public Integer getLeft_id() {
        return left_id;
    }

    public void setLeft_id(Integer left_id) {
        this.left_id = left_id;
    }

    public Integer getRight_id() {
        return right_id;
    }

    public void setRight_id(Integer right_id) {
        this.right_id = right_id;
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

    public boolean isSqlLeaf() {
        return (left_id == null) && (right_id == null);
    }
}
