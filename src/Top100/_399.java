package Top100;

import java.util.HashMap;
import java.util.List;

public class _399 {
    class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            //字符串用map进行映射
            HashMap<String, String> parent = new HashMap<>();  //作为当前节点与父节点的连通.即节点,父节点;find都是通过父节点再递归找到根
            HashMap<String, Double> ratio = new HashMap<>();  //节点,节点/父节点的值.
            //根据方程式建立连通
            for (int i = 0; i < equations.size(); i++) {  //要把values[i]放进来,不能用foreach
                union(parent, ratio, equations.get(i).get(0), equations.get(i).get(1), values[i]);  //注意get后面是()
            }
            double[] res = new double[queries.size()];
            for (int i = 0; i < queries.size(); i++) {
                String s1 = queries.get(i).get(0);  //问题中的被除数
                String s2 = queries.get(i).get(1);  //问题中的除数
                if(!parent.containsKey(s1) || !parent.containsKey(s2) || !find(parent, ratio, s1).equals(find(parent, ratio, s2))){
                    res[i] = -1.0;  //s1或者s2根本就不在连通的map中,或者而这不在同一组,即没有连通性则返回-1.
                }else {
                    res[i] = ratio.get(s1) / ratio.get(s2);  //算的是二者与根的比率,这样子以根为标准,可以得出二者的比率.
                }

            }
            return res;
        }

        private void union(HashMap<String, String> parent, HashMap<String, Double> ratio, String s1, String s2, double n) {
            if (!parent.containsKey(s1)) {
                parent.put(s1, s1);
                ratio.put(s1, 1.0);
            }
            if (!parent.containsKey(s2)) {
                parent.put(s2, s2);
                ratio.put(s2, 1.0);
            }
            //说明连通,则进行根节点相连.
            //把变量提出来,否则可能赋值时会有影响
            String p1 = find(parent, ratio, s1);
            String p2 = find(parent, ratio, s2);
            parent.put(p1, p2);  //把被除数连接在除数的数上.方便更新radio
            ratio.put(p1, n * ratio.get(s2) / ratio.get(s1));  //此处求是s1的根与s2的根的比率.画个图s1为8,p1为2,s2为3,p2为1.已经n为s1与s2的比率8/3.求得p1/p2为8/3*3/4 = 2.
        }

        private String find(HashMap<String, String> parent, HashMap<String, Double> ratio, String s) {
            if(parent.get(s).equals(s)){
                return s;  //先判断本身是否为根.
            }
//            if (!parent.containsKey(s)) {  //不需要判断parent中不存在s,这样进不来.
//                return null;
//            }
            String father = parent.get(s);
            String grandpa = find(parent, ratio, father);
            //这里就是通过递归找根,然后直接将s连接到根上,就是每一个节点都是连接到根上.而算法中是通过while迭代爷爷节点再连接到根.这里是使用递归.目的都是让节点与根相连.
            parent.put(s, grandpa);
            //连接之后要赋s与根的比率
            ratio.put(s, ratio.get(s) * ratio.get(father));  //就是s到father的比率*father到根的比率 = s到根的比率.
            return grandpa;  //返回根.
        }
    }
}
