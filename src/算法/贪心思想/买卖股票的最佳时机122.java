package 算法.贪心思想;
//注意分解问题,找局部最优,保证遍历之后也是全局最优,算法.贪心思想
//[7, 1, 5, 6] 第二天买入，第四天卖出，收益最大（6-1），所以一般人可能会想，怎么判断不是第三天就卖出了呢? 这里就把问题复杂化了，
// 根据题目的意思，当天卖出以后，当天还可以买入，所以其实可以第三天卖出，第三天买入，第四天又卖出（（5-1）+ （6-5） === 6 - 1）。
// 所以算法可以直接简化为只要今天比昨天大，就卖出。
//##注意股票题型是n个数.数组是从0~n-1;prices[i - 1]为昨天的价格
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
