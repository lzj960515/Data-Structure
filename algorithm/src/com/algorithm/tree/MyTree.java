package com.algorithm.tree;

import com.algorithm.queue.MyQueue;

/**
 * @author Zijian Liao
 * @date 2020/6/6 17:14
 * @description
 */
public class MyTree<E> {

    public void print(TreeNode<E> treeNode) {
        System.out.print(treeNode.getData());
    }

    //前序遍历 根 左 右
    public void pre(TreeNode<E> treeNode) {
        print(treeNode);
        if (treeNode.getLeftNode() != null)
            pre(treeNode.getLeftNode());
        if (treeNode.getRightNode() != null)
            pre(treeNode.getRightNode());
    }

    //中序遍历 左 根 右
    public void mid(TreeNode<E> treeNode) {
        if (treeNode.getLeftNode() != null) {
            mid(treeNode.getLeftNode());
        }
        print(treeNode);
        if (treeNode.getRightNode() != null)
            mid(treeNode.getRightNode());
    }

    //后序遍历 左 右 根
    public void post(TreeNode<E> treeNode) {
        if (treeNode.getLeftNode() != null) {
            post(treeNode.getLeftNode());
        }
        if (treeNode.getRightNode() != null) {
            post(treeNode.getRightNode());
        }
        print(treeNode);
    }

    //层序遍历
    public void level(TreeNode<E> treeNode) {
        MyQueue<TreeNode<E>> queue = new MyQueue<>(20);
        levelRecursion(queue, treeNode);
    }

    private void levelRecursion(MyQueue<TreeNode<E>> queue, TreeNode<E> treeNode) {
        print(treeNode);
        if (treeNode.getLeftNode() != null) {
            queue.push(treeNode.getLeftNode());
        }
        if (treeNode.getRightNode() != null) {
            queue.push(treeNode.getRightNode());
        }
        while (!queue.isEmpty()) {
            levelRecursion(queue, queue.pop());
        }
    }
}


