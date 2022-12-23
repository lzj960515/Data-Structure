package com.solution;

public class Roman {

    public int romanToInt(String s) {
        // if first is I|X|C
        // test second is V|X L|C D|M
        // if true, return;
        // if false, return value
        int result = 0;
        char[] arr = s.toCharArray();
        int i = 0;
        for (; i < arr.length - 1; i++) {
            char c = arr[i];
            if(c == 'I'
                    && (arr[i+1] == 'V' | arr[i+1] == 'X')){
                result += determineValue2(arr[i+1]);
                i++;
                continue;
            }
            if(c == 'X'
                    && (arr[i+1] == 'L' | arr[i+1] == 'C')){
                result += determineValue2(arr[i+1]);
                i++;
                continue;
            }
            if(c == 'C'
                    && (arr[i+1] == 'D' | arr[i+1] == 'M')){
                result += determineValue2(arr[i+1]);
                i++;
                continue;
            }
            result += determineValue(c);
        }
        if(i < arr.length){
            result += determineValue(arr[i]);
        }
        return result;
    }

    private int determineValue(char romanNum){
        return switch (romanNum) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    private int determineValue2(char c){
        return switch (c) {
            case 'V' -> 4;
            case 'X' -> 9;
            case 'L' -> 40;
            case 'C' -> 90;
            case 'D' -> 400;
            case 'M' -> 900;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        Roman roman = new Roman();
        System.out.println(roman.romanToInt("III"));
        System.out.println(roman.romanToInt("IV"));
        System.out.println(roman.romanToInt("IX"));
        System.out.println(roman.romanToInt("LVIII"));
        System.out.println(roman.romanToInt("MCMXCIV"));
    }
}
