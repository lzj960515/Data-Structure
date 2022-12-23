package com.solution.easy;

import java.util.Arrays;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class ReversePrint {

    public int[] reversePrint(ListNode head) {
        Result result = new Result();
        add(head, result, 0);
        return result.res;
    }

    private int add(ListNode head, Result result, int length) {
        if (head == null) {
            result.res = new int[length];
            return 0;
        }
        int index = add(head.next, result, ++length);
        result.res[index] = head.val;
        return ++index;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static class Result {
        int[] res;

    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ReversePrint reversePrint = new ReversePrint();
        int[] ints = reversePrint.reversePrint(listNode1);
        System.out.println(Arrays.toString(ints));
    }
}
