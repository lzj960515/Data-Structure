package com.algorithm.list;

import java.util.Scanner;

/**
 * @author Zijian Liao
 * @date 2020/5/20 23:34
 * @description 给定一串括号，判断是否符合括号规则 如 {[]} 符合  {}(] 不符合
 */
public class BracketMatch { //代码实现

    private static class Stack{ //自定义栈
        private Character[] data; private int size;
        Stack(int capacity){
            data = new Character[capacity];
        }
        //压栈
        public void push(Character character){
            data[size++] = character;
        }
        public Character pop(){ //取出并移除栈顶元素
            if(size == 0) return null;
            Character c = data[--size];
            data[size] = null;
            return c;
        }
        public boolean isEmpty(){
            return size == 0;
        }
    }

    public boolean bracketMatch(String brackets){ //括号匹配
        Stack stack = new Stack(brackets.length());
        char[] characters = brackets.toCharArray();
        for (char character : characters) {
            switch (character){
                case '(': case '[': case '{':
                    stack.push(character); break;
                case ')': if(stack.isEmpty() || stack.pop() != '(') return false;
                    break;
                case ']': if(stack.isEmpty() || stack.pop() != '[') return false;
                    break;
                case '}': if(stack.isEmpty() || stack.pop() != '{') return false;
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        //such as {()}
        //从头开始遍历括号，若发现为为左括号，则压入栈中
        //当遇到右括号时，取出栈顶元素比较，若相等，则消除，如 {() -> {
        //不相等则括号规则错误
        //重复以上步骤，直接括号遍历完毕，最后栈空则括号规则正确

        BracketMatch bracketMatch = new BracketMatch();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String next = scanner.next();
            System.out.println("括号符合规则:"+bracketMatch.bracketMatch(next));
        }
    }
}
