package com.algorithm.hash;

/**
 * bit map 位图算法
 *
 * @author Zijian Liao
 * @since 1.0.0
 */
public class BitMap {

    private final int[] data;

    public BitMap(int capacity) {
        this.data = new int[capacity];
    }
    // element = 5
    public void add(int element) {
        // 0
        int dataIndex = element >> 5;
        // 5
        int location = element & 31;
        // 1 << location = 0010 0000
        //   0000 0000
        // | 0010 0000
        //   0010 0000
        data[dataIndex] |= 1 << location;
    }

    public boolean find(int element) {
        int dataIndex = element >> 5;
        int location = element & 31;
        //   0010 0000
        // & 0010 0000
        //   0010 0000
        int exist = data[dataIndex] & (1 << location);
        return exist != 0;
    }

    public void delete(int element){
        int dataIndex = element >> 5;
        int location = element & 31;
        //   0010 1100
        // ^ 001000000
        //   000001100
        data[dataIndex] ^= (1 << location);
    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(3);
        bitMap.add(5);
        bitMap.add(29);
        bitMap.add(63);
        System.out.println(bitMap.find(5));
        System.out.println(bitMap.find(63));
        bitMap.delete(63);
        System.out.println(bitMap.find(63));
    }
}
