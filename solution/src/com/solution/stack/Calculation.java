package com.solution.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Zijian Liao
 * @date 2020/5/21 22:22
 * @description
 */
public class Calculation {

    public double calculation(String expression) {
        //定义优先级
        Map<Character, Integer> priority = new HashMap<>(4);
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
        char[] chars = expression.toCharArray();
        Stack<Character> symbolStack = new Stack<>();
        Stack<Double> number = new Stack<>();
        for (char c : chars) {
            if (priority.containsKey(c)) { //如果为运算符
                    //不为空，则判断取出栈顶元素，比较优先级，
                    // 如果当前优先级小于等于栈顶优先级，则取出两个数字和栈顶元素进行运算，运算结果压入数字栈中，重复以上步骤，直到运算符栈栈空
                    while (!symbolStack.empty() && priority.get(c) <= priority.get(symbolStack.peek())) {
                        Double num1 = number.pop();
                        Double num2 = number.pop();
                        Character topSymbol = symbolStack.pop();
                        double result = calculation(num1, num2, topSymbol);
                        number.push(result);
                    }
                    symbolStack.push(c);
            } else { //数字
                number.push((double) (c - 48));
            }
        }
        //最后可能的情况 1+2 或者 1+2*3
        while(!symbolStack.empty()){
            Double num1 = number.pop();
            Double num2 = number.pop();
            Character topSymbol = symbolStack.pop();
            double result = calculation(num1, num2, topSymbol);
            number.push(result);
        }
        return number.pop();

    }

    public double calculation(double num1, double num2, char symbol) {
        switch (symbol) {
            case '+':
                return num1 + num2;
            case '-':
                return num2 - num1;
            case '*':
                return num1 * num2;
            case '/':
                return num2 / num1;
        }
        return 0.00;
    }

    public static void main(String[] args) {
        Calculation calculation = new Calculation();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String next = scanner.next();
            System.out.println("运算结果:"+calculation.calculation(next));
        }
    }
}
