package com.algorithm.greedy;

/**
 * @author Zijian Liao
 * @date 2020/5/31 14:28
 * @description 双十一马上就要来了，小C心目中的女神在购物车加了N个东西，突然她中了一个奖可以清空购物车5000元的东西（不能找零），
 * 每个东西只能买一件，那么她应该如何选择物品使之中奖的额度能最大利用呢？
 * 如果存在多种最优组合你只需要给出一种即可，嘿嘿 现在女神来问你，你该怎么办？
 */
public class ShoppingCart {

    public static void greedy(int[] money, int maxMoney) {
        //定义规划表格
        //money = 1, 2, 3, 4, 5, 6, 7, 8
        //maxMoney = 10
        //输出第几个物品
        int[][] dp = new int[money.length + 1][maxMoney + 1];
        for (int i = 0; i < money.length; i++) {
            for (int j = 1; j <= maxMoney; j++) {
                if (money[i] <= j) {
                    dp[i + 1][j] = Math.max(money[i] + dp[i][j - money[i]], dp[i][j]);
                } else {
                    dp[i + 1][j] = dp[i][j];
                }
            }
        }
        System.out.println(dp[money.length][maxMoney]);
        int i = money.length;
        int surplus = maxMoney;
        System.out.print("取得组合是：");
        while (i > 0) {
            if (dp[i][surplus] > dp[i - 1][surplus]) {
                //说明取了
                System.out.print(money[i - 1]+ "  ");
                //推导组合
                //取了之后的剩余量
                surplus = surplus - money[i - 1];
            } else {
                //没取，取得是上一组
            }
            i--;
        }

    }

    public static void main(String[] args) {
        int[] money = { 7, 8, 4, 5};
        greedy(money, 10);

    }
}
