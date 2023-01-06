package com.solution;

import com.solution.easy.MirrorTree;

import java.util.ArrayDeque;
import java.util.Deque;

public class PrintTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }    
    public static void printTree(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            printSpace(level);
            level = level - 2;
            StringBuilder sb = new StringBuilder(getSpace(level+1));
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if(node == null) break;
                System.out.print(node.val);
                printSpace(4);
                if(node.left != null){
                    sb.append("/");
                    deque.add(node.left);
                }else {
                    sb.append(" ");
                }
                sb.append(getSpace(3));
                if(node.right != null){
                    sb.append("\\");
                    deque.add(node.right);
                }else {
                    sb.append(" ");
                }
                sb.append("    ");
            }
            System.out.println();
            System.out.println(sb);
        }
    }

    private static void printSpace(int num){
        System.out.print(getSpace(num));
    }

    private static String getSpace(int num){
        return " ".repeat(Math.max(0, num));
    }
}
