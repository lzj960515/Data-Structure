package com.algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Zijian Liao
 * @date 2020/5/31 14:17
 * @description 某天早上公司领导找你解决一个问题，明天公司有N个同等级的会议需要使用同一个会议室，现在给你这个N个会议的开始和结束
 * 时间，你怎么样安排才能使会议室最大利用？即安排最多场次的会议？
 */
public class Meeting implements Comparable<Meeting> {

    public int number;
    public int startTime;
    public int endTime;

    public Meeting(int number, int startTime, int endTime) {
        this.number = number;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Meeting o) {
        if (endTime > o.endTime) return 1;
        return -1;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "number=" + number +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int next = scanner.nextInt();
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 1; i <= next; i++) {
            int startTime = scanner.nextInt();
            int endTime = scanner.nextInt();
            meetings.add(new Meeting(i, startTime, endTime));
        }

        meetings.sort(null);
        System.out.println(meetings);
        System.out.println("===============");
        int curTime = 0;
        for (Meeting meeting : meetings) {
            if(meeting.startTime>=curTime){
                System.out.println(meeting);
                curTime = meeting.endTime;
            }
        }
    }
}
