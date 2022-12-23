package com.solution.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个next指针指向下一个节点，还有一个random指针指向链表中的任意节点或者null。
 * </p>
 * <img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/09/e1.png"/>
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof
 */
public class CopyRandomList {

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        // 记录下标
        Map<Integer, Integer> map = new HashMap<>(8);
        List<Node> list = new ArrayList<>();
        Node copyHead = new Node(head.val);
        Node cur = head;
        Node curCopy = copyHead;

        int i = 0;
        map.put(cur.hashCode(), i++);
        list.add(curCopy);

        while(cur.next != null){
            curCopy.next = new Node(cur.next.val);
            curCopy = curCopy.next;
            cur = cur.next;
            map.put(cur.hashCode(), i++);
            list.add(curCopy);
        }
        cur = head;
        curCopy = copyHead;
        while (cur != null){
            if(cur.random != null){
                curCopy.random = list.get(map.get(cur.random.hashCode()));
            }
            curCopy = curCopy.next;
            cur = cur.next;
        }

        return copyHead;
    }

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;
        CopyRandomList copyRandomList = new CopyRandomList();
        Node node = copyRandomList.copyRandomList(node1);
        while (node != null) {
            System.out.println(node.val + ":" + (node.random != null ? node.random.val : null));
            node = node.next;
        }
    }
}
