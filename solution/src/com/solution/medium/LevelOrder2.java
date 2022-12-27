package com.solution.medium;

import java.util.*;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 *
 *
 * 例如:
 * 给定二叉树:[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 */
public class LevelOrder2 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>(0);
        }
        // 二叉树的层序遍历
        // 一层一层的来
        // 两个队列轮番交替
        Deque<TreeNode> deque = new ArrayDeque<>();
        Deque<TreeNode> deque2 = new ArrayDeque<>();

        List<List<Integer>> resultList = new ArrayList<>();
        deque.add(root);
        while(!deque.isEmpty()){
            loop(deque2, deque, resultList);

            loop(deque, deque2, resultList);
        }


        return resultList;
    }

    private void loop(Deque<TreeNode> deque, Deque<TreeNode> deque2, List<List<Integer>> resultList) {
        List<Integer> result = new ArrayList<>(deque2.size());
        while (!deque2.isEmpty()) {
            TreeNode node = deque2.poll();
            result.add(node.val);
            if (node.left != null) {
                deque.add(node.left);
            }
            if (node.right != null) {
                deque.add(node.right);
            }
        }
        if(!result.isEmpty()){
            resultList.add(result);
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
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        LevelOrder2 levelOrder = new LevelOrder2();
        List<List<Integer>> lists = levelOrder.levelOrder(node1);
        System.out.println(lists.toString());
    }
}
