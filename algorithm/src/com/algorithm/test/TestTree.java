package com.algorithm.test;

import com.algorithm.tree.BinarySelectTree;
import com.algorithm.tree.MyTree;
import com.algorithm.tree.TreeNode;

/**
 * @author Zijian Liao
 * @date 2020/6/6 17:22
 * @description
 */
public class TestTree {

    public static void main(String[] args) {
        BinarySelectTree<Integer> binarySelectTree = new BinarySelectTree();
        binarySelectTree.insert(5,5);
        binarySelectTree.insert(3,3);
        binarySelectTree.insert(0,0);
        binarySelectTree.remove(5);
        binarySelectTree.insert(4,4);
        binarySelectTree.insert(6,6);
        binarySelectTree.insert(9,9);
        binarySelectTree.mid();
        Integer integer = binarySelectTree.find(9);
        System.out.println(integer);
        System.out.println();
        System.out.println(binarySelectTree.size());
    }

    public static void testMyTree(){
        TreeNode<String> D = new TreeNode<>(null,"D",null);
        TreeNode<String> C = new TreeNode<>(D,"C",null);
        TreeNode<String> M = new TreeNode<>(null,"M",null);
        TreeNode<String> B = new TreeNode<>(M,"B",C);
        TreeNode<String> H = new TreeNode<>(null,"H",null);
        TreeNode<String> K = new TreeNode<>(null,"K",null);
        TreeNode<String> G = new TreeNode<>(H,"G",K);
        TreeNode<String> F = new TreeNode<>(G,"F",null);
        TreeNode<String> I = new TreeNode<>(null,"I",null);
        TreeNode<String> E = new TreeNode<>(I,"E",F);
        TreeNode<String> A = new TreeNode<>(B,"A",E);
        MyTree<String> myTree = new MyTree<>();
        myTree.level(A);
        System.out.println();
        myTree.pre(A);
        System.out.println();
        myTree.mid(A);
        System.out.println();
        myTree.post(A);
    }
}
