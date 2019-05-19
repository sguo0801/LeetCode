package 算法.动态规划.股票交易;

public class 两笔交易的股票交易123 {
    class Solution {
        public int maxProfit(int[] prices) {
            //迭代法,直接设置四个变量,
            //firbuy代表这一天之前最后的交易是第一次买入的最大利润
            //firsell代表这一天之前最后的交易是第一次卖出的最大利润
            //secbuy,与secsell类比.
            //先要赋初值
            int firbuy = Integer.MIN_VALUE, secbuy = Integer.MIN_VALUE;  //买入初值都是最小
            int fircell = 0, seccell = 0;  //卖出初值都是0.
            for (int p : prices) {
                firbuy = Math.max(firbuy, -p);  // 第一次就是单纯的给-p,第二次开始也是跟-p比看谁大,其他的题目是unhold-p.这里没必要.后面不会再更新回来,会跑到secbuy那边.
                fircell = Math.max(fircell, firbuy + p);
                secbuy = Math.max(secbuy, fircell - p);
                seccell = Math.max(seccell, secbuy + p);
            }
            return seccell;
        }
    }
}
