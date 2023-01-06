package com.algorithm.time;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShowMeBug {
    public static class Node {
        public int value;
        public Node[] childNodes;

        public Node(int value, Node[] childNodes) {
            this.value = value;
            this.childNodes = childNodes;
        }
    }

    public static int[] solution(Node root) {
        // Write your code here
        List<Integer> list = new LinkedList<>();
        Queue<Node> queue = new ArrayDeque<>();
        list.add(root.value);
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (node.childNodes != null && node.childNodes.length != 0){
                for (Node childNode : node.childNodes) {
                    list.add(childNode.value);
                    queue.add(childNode);
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Node node4 = new Node(4, null);
        Node node5 = new Node(5, null);
        Node node6 = new Node(6, null);
        Node node7 = new Node(7, null);
        Node node2 = new Node(2, new Node[]{node4, node5, node6});
        Node node3 = new Node(3, new Node[]{node7});

        Node root = new Node(1, new Node[]{node2, node3});
        int[] solution = solution(root);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}