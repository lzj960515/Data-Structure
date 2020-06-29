package com.algorithm.tree;

import com.algorithm.queue.MyQueue;

/**
 * @author Zijian Liao
 * @date 2020/6/6 19:58
 * @description 二叉搜索树
 */
public class BinarySelectTree<E> {
    private int size;
    private TreeNode<E> rootNode;

    public void insert(Integer key, E data) {
        if (rootNode == null) {
            rootNode = new TreeNode<>(key, data);
            size++;
            return;
        }
        insert(rootNode, key, data);
        size++;
    }

    private void insert(TreeNode<E> treeNode, Integer key, E data) {
        Integer rootKey = treeNode.getKey();
        TreeNode<E> leafNode = new TreeNode<>(key, data);
        if (rootKey >= key) {
            if (treeNode.getLeftNode() != null) {
                insert(treeNode.getLeftNode(), key, data);
            } else {
                treeNode.setLeftNode(leafNode);
                leafNode.setParentNode(treeNode);
            }
        } else {
            if (treeNode.getRightNode() != null) {
                insert(treeNode.getRightNode(), key, data);
            } else {
                treeNode.setRightNode(leafNode);
                leafNode.setParentNode(treeNode);
            }
        }
    }

    public E find(Integer key) {
        if (rootNode != null) {
            TreeNode<E> eTreeNode = find(rootNode, key);
            if (eTreeNode != null)
                return eTreeNode.getData();
        }
        return null;
    }

    private TreeNode<E> find(TreeNode<E> treeNode, Integer key) {
        Integer rootKey = treeNode.getKey();
        if (rootKey > key) {
            if (treeNode.getLeftNode() != null) {
                return find(treeNode.getLeftNode(), key);
            }
        } else if (rootKey < key) {
            if (treeNode.getRightNode() != null) {
                return find(treeNode.getRightNode(), key);
            }
        } else
            return treeNode;
        return null;
    }


    public int size() {
        return size;
    }

    public void print(TreeNode<E> treeNode) {
        System.out.print(treeNode.getData());
    }

    public void pre() {
        if (rootNode != null)
            pre(rootNode);
    }

    //前序遍历 根 左 右
    public void pre(TreeNode<E> treeNode) {
        print(treeNode);
        if (treeNode.getLeftNode() != null)
            pre(treeNode.getLeftNode());
        if (treeNode.getRightNode() != null)
            pre(treeNode.getRightNode());
    }

    public void mid() {
        if (rootNode != null)
            mid(rootNode);
    }


    //中序遍历 左 根 右
    private void mid(TreeNode<E> treeNode) {
        if (treeNode.getLeftNode() != null) {
            mid(treeNode.getLeftNode());
        }
        print(treeNode);
        if (treeNode.getRightNode() != null)
            mid(treeNode.getRightNode());
    }

    public void post() {
        if (rootNode != null)
            post(rootNode);
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

    public void remove(Integer key) {
        //1.找到该key
        //2.找到该key的后继结点
        //3.替换
        TreeNode<E> node = find(rootNode, key);
        if (node == null) return;

        TreeNode<E> postNode ;
        if (node.getLeftNode() != null && node.getRightNode() != null) {
            //此时需寻找后继结点 右子树的最小结点
            postNode = findPostNode(node.getRightNode());
            TreeNode<E> postParentNode = postNode.getParentNode();
            postParentNode.setLeftNode(postNode.getRightNode());
            postNode.setLeftNode(node.getLeftNode());
            postNode.setRightNode(node.getRightNode());
        }else {
            //至少有一个为空
            postNode = node.getLeftNode() != null ? node.getLeftNode() : node.getRightNode();
        }
        //判断删除的是左结点还是右结点
        TreeNode<E> parentNode = node.getParentNode();
        if(parentNode==null){
            //删除的是根结点
            rootNode = postNode;
            rootNode.setParentNode(null);
            return;
        }
        TreeNode<E> leftNode = parentNode.getLeftNode();
        if (leftNode != null && leftNode == node) {
            parentNode.setLeftNode(postNode);
        } else {
            parentNode.setRightNode(postNode);
        }
        postNode.setParentNode(parentNode);
    }

    public TreeNode<E> findPostNode(TreeNode<E> node) {
        if (node.getLeftNode() != null) {
            findPostNode(node.getLeftNode());
        }
        return node;
    }
}
