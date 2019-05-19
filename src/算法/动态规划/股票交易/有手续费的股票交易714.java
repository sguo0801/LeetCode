package 算法.动态规划.股票交易;

public class 有手续费的股票交易714 {
//    class Solution {
//        public int maxProfit(int[] prices, int fee) {
//            //动态规划分成两个数组,一个是当前不持有股票的unhold[],一个是当前持有股票hold[];
//            //unhold[i] = max(unhold[i-1], hold[i-1] + prices[i] - fee);  就是第i天不持有,可能是i-1天不持有今天没买入;或者是i-1天持有,今天卖出且付手续费.
//            //hold[i] = max(hold[i-1], unhold[i-1]-prices[i]);  第i天持有,可能是i-1天持有,今天不交易;或者是i-1天没持有,今天买入.
//            if (prices == null || prices.length < 2) {
//                return 0;
//            }
//            int n = prices.length;
//            int[] unhold = new int[n];  //就是当前为卖出状态,对应冷却期
//            int[] hold = new int[n];  //当前为买入状态.
//            unhold[0] = 0;
//            hold[0] = -prices[0];  //两数组赋初值,冷却期需要赋0.1两个值.
//            for (int i = 1; i < n; i++) {  //注意从1开始
//                unhold[i] = Math.max(unhold[i - 1], hold[i - 1] + prices[i] - fee);
//                hold[i] = Math.max(hold[i - 1], unhold[i - 1] - prices[i]);
//            }
//            return unhold[n - 1];  //最后应该是不持有比较赚.
//        }
//    }

    //    class Solution {
//        //法二用迭代的方法代替数组.因为在动归中只用到了hold[i-1],unhold[i-1];
//        public int maxProfit(int[] prices, int fee) {
//            if(prices == null || prices.length < 2){
//                return 0;
//            }
//            int n = prices.length;
//            int unhold = 0;
//            int hold = -prices[0];  //给变量赋值
//            int prehold;  //关键迭代,从前一个的买入开始.暂存前一天持有股票的利润;unhold不需要保存
//            for(int i = 1; i < n; i++){  //注意从1开始
//                prehold = hold;
//                unhold = Math.max(unhold, prehold + prices[i] - fee);
//                hold = Math.max(hold , unhold - prices[i]);
//            }
//            return unhold;  //最后应该是不持有比较赚.
//        }
//    }
    //法三,最佳解.用foreach循环,需要改变初值,然后prehold,之前的持有需要跟-p比较,并且可以写成unhold-p,省略prehold的变量.应为unhold的初值为0;
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            if (prices == null || prices.length < 2) {
                return 0;
            }
            int unhold = 0;
            int hold = Integer.MIN_VALUE;
            for (int p : prices) {  //注意从1开始
                hold = Math.max(hold, unhold - p);   //注意hold要写在前面.
                unhold = Math.max(unhold, hold + p - fee);

            }
            return unhold;  //最后应该是不持有比较赚.
        }
    }
}
