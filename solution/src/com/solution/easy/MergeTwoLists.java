package com.solution.easy;

/**
 * @author Zijian Liao
 * @since
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        if(l1.val < l2.val){
            head = l1;
            cur1 = l1.next;
        }else {
            head = l2;
            cur2 = cur2.next;
        }
        ListNode cur = head;
        while (cur1 != null && cur2 != null){
            while (cur1 != null && cur1.val <= cur2.val){
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            }

            while (cur1 != null && cur2 != null && cur2.val < cur1.val ){
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            }
        }
        if(cur1 != null){
            cur.next = cur1;
        }
        if(cur2 != null) {
            cur.next = cur2;
        }

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
