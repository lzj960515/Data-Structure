package com.algorithm.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Zijian Liao
 * @date 2020/5/19 13:51
 * @description
 */
public class AgeStatistics {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String filename = "D:\\学习笔记\\数据结构与算法\\基础数据结构\\数组\\age1.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line = "";
            int[] age = new int[200];
            int total = 0;
            while ((line=br.readLine())!=null){
                age[Integer.parseInt(line)]++;
                total++;
            }
            for (int i = 0;i<age.length;i++){
                System.out.println(i + ":" + age[i]);
            }
            System.out.println("一共统计："+total);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("共花费时间: "+ (System.currentTimeMillis() - startTime) + "ms");
    }
}
