package 算法.回溯_求解排列组合问题的DFS;
/**     * 1排列 全排列 有重复数字的排列
        * 2组合 重复元素组合
        * 3求和 重复元素求和
        * 4子集 重复元素子集
        * 5扩展题型 如ip划分 回文数划分 数字打出字母等。
        * 重点在于：递归前标记元素，每次完整递归结束需要清除标记元素。
        * 判断递归结束条件。
        * 细节问题如list的添加，contains使用等
 **/
import java.util.ArrayList;
import java.util.List;
//没有用回溯,而是遍历.
public class 复原IP地址93 {
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<>();
            int i, j, k;
            int len = s.length();
            for(i = 1; i < 4 && i < len-2; i++){  //##注意i的取值,从1到3(最多是三个数); i作为前两个数的边界,后面用substring,不包含,所以可以到3,但是要保证后面最起码留三个数,给后三位,包括i,i+1,i+2,其中(i+2 < len).
                for(j = i+1; j < i+4 && j < len-1; j++){
                    for(k = j+1; k < j+4 && k < len; k++){  //最后一个数可以为k那位.
                        String s1 = s.substring(0, i);
                        String s2 = s.substring(i, j);
                        String s3 = s.substring(j, k);
                        String s4 = s.substring(k, len);
                        if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                            res.add(s1 + "." + s2 + "." + s3 + "." + s4);
                        }
                    }
                }
            }
            return res;
        }

        private boolean isValid(String s){  //是小段数字,保证长度1~3个,且如果首位是0,那么就只能有一位,并且数值小于255
            if(s.length() < 1 || s.length() > 3 || (s.charAt(0) == '0' && s.length() > 1) || Integer.valueOf(s) > 255){   //###注意判断s的长度在1到3之间.另外如果多个字符,首不能为'0';
                return false;
            }else{
                return true;
            }
        }
    }
}
