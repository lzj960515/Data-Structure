package com.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        count();



    }

    private static void count(){
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                List<Integer> list = new ArrayList<>();
                int count =0 ;
                for(;;){
                    count++;
                    list.add(1);
                }
            }).start();
        }
    }
}
