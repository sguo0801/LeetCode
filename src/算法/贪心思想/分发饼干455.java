package 算法.贪心思想;

import java.util.Arrays;
//i就是满足的饼干数量
public class 分发饼干455 {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int i = 0;
            int j = 0;
            while(j < s.length && i < g.length){
                if(s[j] >= g[i]){
                    j++;
                    i++;
                }else{
                    j++;
                }
            }
            return i;
        }
}
