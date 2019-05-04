package 算法.贪心思想;
//注意分解问题,找局部最优,保证遍历之后也是全局最优,算法.贪心思想
public class 买卖股票的最佳时机122 {
        public int maxProfit(int[] prices) {
            int profit = 0;
            for(int i = 1; i < prices.length; i++){
                if(prices[i] > prices[i - 1]){
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
}
