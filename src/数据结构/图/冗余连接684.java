package 数据结构.图;

//参考并查集:https://blog.csdn.net/dm_vincent/article/details/7655764, https://blog.csdn.net/niushuai666/article/details/6662911
//两个路径压缩相同,只不过一个分开写啦,一个写一起啦,下面的路径压缩return group[x] = find(group[x]);更加简洁
public class 冗余连接684 {
    class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            UF uf = new UF(edges.length);   //UF为union-find类,给定的边数组的个数为节点的个数.只不过是1~n,我们的节点应该是0~n-1.
            for (int[] edge : edges) {  //开始遍历每个边数组.
                if (!uf.union(edge[0] - 1, edge[1] - 1)) {   //这里-1是相当于把边数组中代表节点的1~n,变成方法中的0~n-1;对找出多余的边并不影响
                    //如果##uf.union(注意是uf的方法)返回false,说明这一edge边上的两个节点已经连通,则此时的这一edge为多余的
                    return edge;
                }
            }
            throw new IllegalArgumentException();  //如果没有多余的边说明给定的edge边二维数组有问题,返回参数异常.
        }

        //UF类,有一个整数型数组(可以存放每个索引i的父节点,每个i代表一个节点)和两个函数组成.所以主函数要给参数一共多少个节点,可以看题意是否给了,或者与边的关系.
        // 就是有每个节点对应每个组的概念,每一组的节点是联通的,这个类还有find方法找根,union方法合并,
        class UF {  //类前可以加static, 类变量前可以加private, 方法前可以加public.
            int n;   //要有长度值,后面find限定>n的参数返回异常,当然这边限定条件>=n可以不写.
            int[] group;   //##必要的,group[i]指的是节点i的根节点.如果自己就是根节点(比如最初),那就为默认0;
            byte[] rank;   //##非必要的,只是为了合并更均衡.指的当前树的优先级.只有当两边根相同且要合并是才升级(其实也是树的高度).byte是从-128~127.足够啦.

            public UF(int n) {  //构造方法只需要当前节点归属的组,和每个节点的等级.n为节点个数.
                this.n = n;
                // if(n < 0){
                //     throw new IllegalArgumentException();  //这里是对数组长度的限定,但是我认为长度不可能为负,这里不做限定.如果是空的edges,会跳过findRedundantConnection方法的foreach抛出异常
                // }
                group = new int[n];   //初始的根节点为0,只要根为0,则代表是一组.后面需要合并是作为父节点进行拼接
                rank = new byte[n];
            }

            //find寻找x的根节点值.其实目的就是根节点值相同说明连到同一棵树上,则是同组的节点,即是已经连通的,这个方法是union的前提.
            int find(int x) {   //这里的x为当前的节点值也就是0~n-1.
                if (x < 0 || x >= n) {
                    throw new IllegalArgumentException();  //这里限定是边数组中给的节点值不符合要求,即给定参数不符合要求抛出异常.
                }
                if (group[x] == 0) {
                    return x;   //代表当前节点的根节点就是x本身.
                } else {
                    return group[x] = find(group[x]);   //两个作用,首先将当前节点的父节点指向最后(递归)的根节点值(最上面的x);然后将这个根节点值返回,求得find要的根节点.
                }
            }

            //union是判断两个节点是否相连.相连则返回false;
            boolean union(int a, int b) {
                int rootA = find(a);
                int rootB = find(b);
                if (rootA == rootB) {
                    return false;  //如果两个节点的根节点相同,说明已经在一颗树中,即同一组中是连通的.如果再想让他们合并,就是多余的边.
                }

                //下面进行两个不连通路径的连接,是以各自的根节点值进行相连.
                if (rank[rootA] > rank[rootB]) {  //说明a的根节点优先级高(也是a所在的树高度更高);则将b节点所在的树就连入到a所在的树中.
                    group[rootB] = rootA;  //相当于B树中所有值的根节点都是rootA;
                } else if (rank[rootA] < rank[rootB]) {
                    group[rootA] = rootB;
                } else {  //两个数的优先级相同(同高),则任意一个根节点作为新根,让该新根的rank等级+1;相当于整个新树长高一层.
                    group[rootA] = rootB;
                    rank[rootB]++;
                }
                return true;   //上面合并完成,说明合并成功.
            }
        }
    }
}
