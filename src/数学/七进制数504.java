package 数学;

public class 七进制数504 {
//    class Solution {   //直接使用Integer的toString方法.
//        public String convertToBase7(int num) {
//            return Integer.toString(num, 7);
//        }
//    }
    class Solution {
        public String convertToBase7(int num) {
            if(num < 0){
                return "-" + convertToBase7(-num);
            }
            if(num < 7){  //直到小于7位置,开始返回,这个最上层num为七进制中最左边的数
                return num + "";  //这边可以保证为字符串形式输出
            }
            return convertToBase7(num / 7) + num % 7;  //不要用num&6的形式,这里不能用二进制进行加和求值或者做判断.
        }
    }
}
