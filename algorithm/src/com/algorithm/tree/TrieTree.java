package com.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * tire树， 字典输，前缀树
 *
 * @author Zijian Liao
 * @since 1.0.0
 */
public class TrieTree {

    TrieNode trieNode;

    public TrieTree() {
        this.trieNode = new TrieNode();
    }

    /**
     * 增加一个结点
     *
     * @param word 单词
     */
    public void add(String word) {
        char[] chars = word.toLowerCase().toCharArray();
        TrieNode next = trieNode;
        for (char c : chars) {
            TrieNode trieNode = next.childrenNodes[c - 'a'];
            if (trieNode == null) {
                trieNode = new TrieNode();
                next.childrenNodes[c - 'a'] = trieNode;
            }
            next = trieNode;
        }
        next.isEnd = true;
        next.value = word;
    }

    /**
     * 查询单词是否存在
     *
     * @param word 单词
     * @return 是否存在
     */
    public boolean search(String word){
        TrieNode trieNode = searchNode(word);
        return trieNode != null && trieNode.isEnd;
    }

    /**
     * 判断前缀是否存在
     *
     * @param prefix 前缀
     * @return 是否存在
     */
    public boolean starsWith(String prefix){
        return searchNode(prefix) != null;
    }

    /**
     * 查询结点
     *
     * @param word 单词
     * @return 结点
     */
    private TrieNode searchNode(String word){
        char[] chars = word.toLowerCase().toCharArray();
        TrieNode next = trieNode;
        for (char c : chars) {
            TrieNode trieNode = next.childrenNodes[c - 'a'];
            if (trieNode == null) {
                return null;
            }
            next = trieNode;
        }
        return next;
    }

    /**
     * 自动补全
     * @param prefix 前缀
     * @param list 结果集
     */
    public void autocomplete(String prefix, List<String> list){
        TrieNode trieNode = searchNode(prefix);
        if (trieNode != null) {
            autocomplete(trieNode, list);
        }
    }

    private void autocomplete(TrieNode trieNode, List<String> list){
        TrieNode[] trieNodes = trieNode.childrenNodes;
        for (TrieNode node : trieNodes) {
            if (node != null) {
                if (node.isEnd) {
                    list.add(node.value);
                }
                autocomplete(node, list);
            }
        }
    }

    public class TrieNode {
        // 是否是终点
        boolean isEnd;
        // 字符串的值，isEnd = true 时才有
        String value;
        // 子结点
        TrieNode[] childrenNodes = new TrieNode[26];
    }

    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree();
        trieTree.add("apple");
        trieTree.add("apply");
        trieTree.add("application");
        System.out.println(trieTree.search("apple"));
        System.out.println(trieTree.search("app"));
        System.out.println(trieTree.starsWith("app"));
        List<String> list = new ArrayList<>();
        trieTree.autocomplete("app", list);
        System.out.println(list);
    }
}
