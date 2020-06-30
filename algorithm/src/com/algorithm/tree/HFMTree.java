package com.algorithm.tree;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class HFMTree {

    private final PriorityQueue<Node> priorityQueue;
    private final List<Node> nodeList;
    private final Map<Character, String> dictionary;
    private final Map<String, Character> deDictionary;

    private Node root;

    public HFMTree(Map<Character, Integer> dictionary) {
        priorityQueue = new PriorityQueue<>(dictionary.size());
        nodeList = new ArrayList<>(dictionary.size());
        this.dictionary = new HashMap<>(dictionary.size());
        this.deDictionary = new HashMap<>(dictionary.size());
        dictionary.forEach((chars, weight) -> {
            Node node = new Node(chars.toString(), weight);
            priorityQueue.add(node);
            nodeList.add(node);
        });
    }

    public String decode(String binary) {
        char[] chars = binary.toCharArray();
        StringBuilder message = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (Character aChar : chars) {
            sb.append(aChar);
            Character character = deDictionary.get(sb.toString());
            if (character != null){
                message.append(character);
                sb = new StringBuilder();
            }
        }
        return message.toString();
    }

    public String encode(String message) {
        char[] chars = message.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            sb.append(dictionary.get(aChar));
        }
        return sb.toString();
    }

    public void code() {
        nodeList.forEach(node -> {
            String chars = node.chars;
            String code = "";
            do {
                if (node.parent.left == node) {
                    code = "0" + code;
                } else
                    code = "1" + code;
                node = node.parent;
            } while (node.parent != null);
            dictionary.put(chars.charAt(0), code);
            deDictionary.put(code, chars.charAt(0));
            System.out.println(chars + ":" + code);
        });
    }

    public void create() {
        int length = priorityQueue.size();
        for (int i = 0; i < length - 1; i++) {
            Node node1 = priorityQueue.poll();
            Node node2 = priorityQueue.poll();
            Node parent = new Node(node1.chars + node2.chars, node1.weight + node2.weight);
            parent.left = node1;
            parent.right = node2;
            node1.parent = parent;
            node2.parent = parent;
            priorityQueue.add(parent);
        }
        root = priorityQueue.poll();
    }


    private static class Node implements Comparable<Node> {
        Node left;
        Node right;
        Node parent;
        int weight;
        String chars;

        public Node(String chars, int weight) {
            this.chars = chars;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) {
        //a:7 b:10 c:3 d:20 e:6 f:15 g:22
        Map<Character, Integer> dictionary = new HashMap<>();
        dictionary.put('a', 7);
        dictionary.put('b', 10);
        dictionary.put('c', 3);
        dictionary.put('d', 20);
        dictionary.put('e', 6);
        dictionary.put('f', 15);
        dictionary.put('g', 22);
        HFMTree hfmTree = new HFMTree(dictionary);
        hfmTree.create();
        hfmTree.code();
        String binary = hfmTree.encode("abcdefg");
        System.out.println(binary);
        System.out.println(hfmTree.decode(binary));
    }
}
