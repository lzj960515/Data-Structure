package com.algorithm.tree;

public class TreeNode<E> {
    private TreeNode<E> leftNode;
    private Integer key;
    private E data;
    private TreeNode<E> rightNode;
    private TreeNode<E> parentNode;

    public TreeNode(Integer key, E data) {
        this.key = key;
        this.data = data;
    }

    public TreeNode(TreeNode<E> leftNode, E data, TreeNode<E> rightNode) {
        this.leftNode = leftNode;
        this.data = data;
        this.rightNode = rightNode;
    }

    public TreeNode<E> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode<E> leftNode) {
        this.leftNode = leftNode;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public TreeNode<E> getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode<E> rightNode) {
        this.rightNode = rightNode;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public void setParentNode(TreeNode<E> parentNode) {
        this.parentNode = parentNode;
    }

    public TreeNode<E> getParentNode() {
        return parentNode;
    }
}