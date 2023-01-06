package com.solution.easy;

/**
 * 链表中倒数第k个节点
 *
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetKthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null) return null;
        ListNode cur = head;
        int len = 1;
        while (cur.next != null){
            cur = cur.next;
            len++;
        }
        cur = head;
        while (cur.next != null && len != k){
            len--;
        }
        return cur;
    }
    // 双指针解法
    public ListNode getKthFromEnd2(ListNode head, int k) {
        // 指针1和指针2相距k，则当指针2到达尾端时，指针1即指向倒数第k个结点
        ListNode cur = head;
        ListNode kNode = head;
        // 指针2先走k步
        while (cur != null &&  k != 0){
            k--;
            cur = cur.next;
        }
        // 指针1和指针2同时移动
        while (cur != null){
            cur = cur.next;
            kNode = kNode.next;
        }
        return kNode;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
