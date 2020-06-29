package com.algorithm.test;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;


public class Test {

	public static void main(String[] args) throws Exception {
		final String fileName = "D:\\学习笔记\\数据结构与算法\\基础数据结构\\数组\\age1.txt";
		final Random random = new Random();
		BufferedWriter objWriter = null;
		objWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
		for (int i = 0; i < 1400000000; i++) {
			int age = Math.abs(random.nextInt()) % 180;
			objWriter.write(age + "\r\n");
		}
		objWriter.flush();
		objWriter.close();

	}
}
