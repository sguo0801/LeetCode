package Top100;
//假设n个节点存在二叉排序树的个数是G(n)，令f(i)为以i为根的二叉搜索树的个数，则
//G(n) = f(1) + f(2) + f(3) + f(4) + ... + f(n)
//
//当i为根节点时，其左子树节点个数为i-1个，右子树节点为n-i，则
//f(i) = G(i-1)*G(n-i)
//
//综合两个公式可以得到 卡特兰数 公式
//G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)  最后一个式子就是以最后一个节点n为根的二叉搜索树数目,即都是其左子树G(n-1).右边为空即G(0);
public class _96 {
    class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n+1];
            dp[0] = 1; //空树也是二叉搜索树
            dp[1] = 1;  //只有一个根节点的也是二叉搜索树

            for(int i = 2; i <= n; i++){  //这里的i就是公式中的n
                for(int j = 1; j <= i; j++){  //j为根,就是原公式的i
                    dp[i] += dp[j-1] * dp[i-j];  //由左i-1,右n-i;变成左j-1,右i-j;
                }
            }
            return dp[n];
        }
    }
}
