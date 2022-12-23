package com.solution.easy;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 */
public class ReverseList {

    ListNode result = null;

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode cur = head.next;
        ListNode last = head;
        head.next = null;
        while (cur != null){
            ListNode tmp = last;
            last = cur;
            cur = cur.next;
            last.next = tmp;
        }

        return last;

        /*reverse(head);
        return result;*/
    }

    public ListNode reverse(ListNode cur){
        if(cur.next == null){
            result = cur;
            return cur;
        }
        ListNode last = reverse(cur.next);
        last.next = cur;
        cur.next = null;
        return cur;
    }
    
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ReverseList reverseList = new ReverseList();
        ListNode listNode = reverseList.reverseList(listNode1);
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

}
