package 算法.动态规划.股票交易;

public class k笔交易的股票交易188 {
    class Solution {
        public int maxProfit(int k, int[] prices) {
            //分成两种情况,在k>n/2时,则交易次数相当于无限,用贪心算法.
            //在k有要求时,采用动归,buy[i][j]表示在第j天前,最后一次交易是买(已经完成交易),并完成i次交易的最大利润
            //sell[i][j]同理,表示在第j天前,最后一次交易为卖,共完成i次交易的最大利润.
            int n = prices.length;
            if (k < 0 || n < 2) {
                return 0;
            }
            if (k >= n / 2) {
                int max = 0;
                for (int i = 1; i < n; i++) {
                    if (prices[i] > prices[i - 1]) {
                        max += prices[i] - prices[i - 1];
                    }
                }
                return max;
            }
            int[][] buy = new int[k + 1][n];
            int[][] sell = new int[k + 1][n];  //n天值0~n-1天

            //先看要求的交易数,再看第几天.

            for (int i = 1; i <= k; i++) {  //##得从1开始否则sell中buy越界,而且要求0笔交易,无意义直接为0已经初始化中包括了.
                //要求i笔交易.###买入就代表完成一笔交易,这个容易出错!!!!!
                buy[i][0] = -prices[0];  //用数组就从0赋值,for从1开始.sell与buy数组中初始默认为0
                for (int j = 1; j < n; j++) {  //表示第j天前完成i笔交易
                    //buy就是第j-1天完成交易量并买好啦,今天啥也不干;或者昨天进行卖出完成交易量,今天买入.
                    buy[i][j] = Math.max(buy[i][j - 1], sell[i - 1][j - 1] - prices[j]);
                    //##这里sell的i可能越界,所以必须i=1为初始.
                    // 并且都是上下买卖结合
                    //sell就是昨天已经卖出并完成交易量;或者昨天以前买好,今天卖出才完成i次交易.
                    sell[i][j] = Math.max(sell[i][j - 1], buy[i][j - 1] + prices[j]);
                }
            }
            return sell[k][n - 1];  //0~n-1天,对应的也是数组中的0~n-1;
        }
    }
}
