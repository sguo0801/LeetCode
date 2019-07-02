package 算法.贪心思想;

public class 股票单次交易最大利润121 {
    //比较好理解,相对于下面的,负责度相同.
    //使我们感兴趣的点是数组中的峰和谷。我们需要找到最小的谷之后的最大的峰。 我们可以维持两个变量——minprice 和 maxprofit，
    //它们分别对应迄今为止所得到的最小的谷值和最大的利润（卖出价格与最低价格之间的最大差值）。
    //时间复杂度：O(n)，只需要遍历一次。
    //空间复杂度：O(1)，只使用了两个变量。
    class Solution {
        public int maxProfit(int[] prices) {
            int minprice = Integer.MAX_VALUE;
            int maxprofit = 0;
            for (int price : prices) {
                if (price < minprice) {
                    minprice = price;
                } else if (price - minprice > maxprofit) {
                    maxprofit = price - minprice;
                }

            }
            return maxprofit;
        }

    }

//        public int maxProfit(int[] prices) {
//            if(prices.length == 0 || prices == null){  //注意边界条件
//                return 0;
//            }
//            int profit = 0;
//            int min = prices[0];
//            for(int i = 1; i < prices.length; i++){
//                if(min > prices[i]){ //哪怕后面有更小的值但是利润不会更高,但是前面有记录之前最高的利润.
//                    min = prices[i];
//                }else{
//                    profit = Math.max(profit, prices[i] - min);  //前面是之前留下的最大利润,后面可能是更换min后的最大利润.
//                }
//            }
//            return profit;
//        }
}
