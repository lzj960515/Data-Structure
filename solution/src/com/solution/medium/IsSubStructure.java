package com.solution.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *     3
 *    / \
 *   4  5
 *  / \
 * 1  2
 * 给定的树 B：
 *
 *   4
 *  /
 * 1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 *
 * 示例 2：
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof
 */
public class IsSubStructure {

    public boolean isSubStructure(TreeNode a, TreeNode b) {
        if(b==null) return false;
        // 前序遍历 根左右
        return preLoop(a, b);
    }

    public boolean isSubStructure2(TreeNode a, TreeNode b) {
        if(b==null) return false;
        int rootB = b.val;
        // 先通过层序遍历找到子树的根结点
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(a);
        while (!deque.isEmpty()){
            TreeNode node = deque.poll();
            if (node.val == rootB) {
                // 等于b的根结点，尝试比对
                if(compare(node, b)){
                    return true;
                }
            }
            if(node.left != null){
                deque.add(node.left);
            }
            if(node.right != null){
                deque.add(node.right);
            }
        }
        return false;
    }

    private boolean preLoop(TreeNode a, TreeNode b){
        if(a.val == b.val){
            if(compare(a.left, b.left) && compare(a.right, b.right)){
                return true;
            }
        }
        return a.left != null ? (preLoop(a.left, b) || (a.right != null && preLoop(a.right, b))) :
                (a.right != null && preLoop(a.right, b));
    }

    private boolean compare(TreeNode a, TreeNode b){
        if(a != null && b != null){
            if(a.val != b.val){
                return false;
            }
            return compare(a.left, b.left) && compare(a.right, b.right);
        }
        return b == null;
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
        test2();
    }

    public static void test1(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node3.left = node4;
        node3.right = node5;
        node4.left = node1;
        node4.right = node2;

        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(4);
        node7.left = node6;

        IsSubStructure isSubStructure = new IsSubStructure();
        System.out.println(isSubStructure.isSubStructure(node3, node7));
    }

    public static void test2(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;

        TreeNode node7 = new TreeNode(3);

        IsSubStructure isSubStructure = new IsSubStructure();
        System.out.println(isSubStructure.isSubStructure(node1, node7));
    }
}
