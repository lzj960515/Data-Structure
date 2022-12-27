package com.solution.medium;

import java.util.*;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
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
 *   [20,9],
 *   [15,7]
 * ]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 */
public class LevelOrder3 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>(0);
        }
        // 二叉树的层序遍历
        // 一层一层的来
        // 使用递归特性来处理是顺序还是倒序添加值
        Deque<TreeNode> deque = new ArrayDeque<>();

        List<List<Integer>> resultList = new ArrayList<>();
        deque.add(root);
        boolean flag = false;
        while (!deque.isEmpty()){
            List<Integer> result = new ArrayList<>(deque.size());
            loop(deque, result, flag = !flag, deque.size());
            resultList.add(result);
        }

        return resultList;
    }

    private void loop(Deque<TreeNode> deque, List<Integer> result, boolean flag, int size){
        if(deque.isEmpty() || size == 0) return;
        TreeNode node = deque.poll();
        if(node.left != null){
            deque.add(node.left);
        }
        if(node.right != null){
            deque.add(node.right);
        }
        if(flag){
            result.add(node.val);
        }
        loop(deque, result, flag, --size);
        if(!flag){
            result.add(node.val);
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
        LevelOrder3 levelOrder = new LevelOrder3();
        System.out.println(levelOrder.levelOrder(node1));
    }
}
