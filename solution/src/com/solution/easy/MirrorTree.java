package com.solution.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        // 前序遍历，交换左右结点
        mirrorNode(root);
        return root;
    }

    private void mirrorNode(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left != null){
            mirrorTree(root.left);
        }
        if(root.right != null){
            mirrorTree(root.right);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(5);
        TreeNode node7 = new TreeNode(5);

        node3.left = node4;
        node3.right = node5;
        node4.left = node1;
        node4.right = node2;
        node5.left = node6;
        node5.right = node7;
        printTree(node3, 10);
        MirrorTree mirrorTree = new MirrorTree();
        TreeNode treeNode = mirrorTree.mirrorTree(node3);
        printTree(treeNode, 10);


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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

}
