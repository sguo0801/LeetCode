package 贪心思想;

public class 股票单次交易最大利润121 {
        public int maxProfit(int[] prices) {
            if(prices.length == 0 || prices == null){  //注意边界条件
                return 0;
            }
            int profit = 0;
            int min = prices[0];
            for(int i = 1; i < prices.length; i++){
                if(min > prices[i]){ //哪怕后面有更小的值但是利润不会更高,但是前面有记录之前最高的利润.
                    min = prices[i];
                }else{
                    profit = Math.max(profit, prices[i] - min);  //前面是之前留下的最大利润,后面可能是更换min后的最大利润.
                }
            }
            return profit;
        }
}
