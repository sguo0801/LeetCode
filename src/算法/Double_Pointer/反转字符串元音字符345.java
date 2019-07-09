package 算法.Double_Pointer;

import java.util.Arrays;
import java.util.HashSet;
//思想是不交换,建立新数组,然后往里面填.
public class 反转字符串元音字符345 {
    private HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {

        int i = 0;
        int j = s.length() - 1;
        //###String temp = "aeiouAEIOU";
        char[] res = new char[s.length()];  //作为结果存放的数组
        while (i <= j) {  //########必须是<=才行,否则res不能填充完整
            char ci = s.charAt(i);   //先取字符,再判断放入
            char cj = s.charAt(j);
            if (!set.contains(ci)) {  //说明不是元音字符,直接填进res
                res[i++] = ci; //两个数组,所以都要分别移动指针
            } else if (!set.contains(cj)) {
                res[j--] = cj;
            } else {  //说明两个字符都是元音字符
                res[i++] = cj;//新旧数组填完之后,指针都要移动
                res[j--] = ci;
            }
        }
        return new String(res);
    }

}

//法二只要用indexOf判断即可
class Solution {
    //private HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {

        int i = 0;
        int j = s.length() - 1;
        String temp = "aeiouAEIOU";  //可以的,法二只要用indexOf判断即可
        char[] res = new char[s.length()];  //作为结果存放的数组
        while (i <= j) {
            char ci = s.charAt(i);  //要把字符提出来,否则后面直接写res[i++]=s.charAt(i).i已经变化.
            char cj = s.charAt(j);
            if (temp.indexOf(ci) == -1) {  //说明不是元音字符,直接填进res
                res[i++] = ci; //两个数组,所以都要分别移动指针
            } else if (temp.indexOf(cj) == -1) {
                res[j--] = cj;
            } else {  //说明两个字符都是元音字符
                res[i++] = cj;//新旧数组填完之后,指针都要移动
                res[j--] = ci;
            }
        }
        return new String(res);
    }
}
