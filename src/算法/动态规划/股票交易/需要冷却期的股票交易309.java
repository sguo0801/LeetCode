package 算法.动态规划.股票交易;

public class 需要冷却期的股票交易309 {

    //法一,没有用到sell[i-1]替换sell[i-2].
    private static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[] buy = new int[n];  //数组是指前i天最后一次交易为buy的最大利润
        int[] sell = new int[n];
        buy[0] = -prices[0]; //最开始第0天就是做初始值用的,如果买,利润就是负值.
        sell[0] = 0;  //卖的初始值可以定义不能为最小,只能为0;
        if (n > 1) {   //要是只有一个值要考虑
            buy[1] = Math.max(buy[0], 0 - prices[1]);
            sell[1] = Math.max(sell[0], buy[0] + prices[1]);
        }
        for (int i = 2; i < n; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);  //递归推导,这里sell[i-1]是从sell[i-2]推过来的,因为前一天只能休息,所以二者相同.输出4,是在12302中,直接3卖完就买了.还是先用sell[i-2].
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
        }
        return sell[n - 1];  //最后的最大利润肯定是最后交易为卖出之后的.
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit1(prices));
    }
    //法二.直接用prices的foreach循环,不需要赋初值,但是要用MIN_VALUE.并且使用sell[i-1];
    //节省了数组.用迭代更新pre等参数.
    public static int maxProfit1(int[] prices) {
        int presell = 0;
        int prebuy;
        int sell = 0;
        int buy = Integer.MIN_VALUE;
        for (int price : prices) {
            prebuy = buy;
            buy = Math.max(prebuy, presell - price);
            presell = sell;
            sell = Math.max(presell, prebuy + price);
        }
        return sell;

    }


}
