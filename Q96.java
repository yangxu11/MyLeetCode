package leetcode;

import java.util.HashMap;
import java.util.Map;
////不同的二叉搜索树II
public class Q96 {
    //0ms 100%
    //动态规划，与爬楼梯类似，当n时，左边有1个，右边有n-2个，左2，则右n-3 ...而0，1，2...n-1对应的个数都是之前得到的值
    //结题思路：假设n个节点存在二叉排序树的个数是G(n)，1为根节点，2为根节点，...，n为根节点，
    // 当1为根节点时，其左子树节点个数为0，右子树节点个数为n-1，
    // 同理当2为根节点时，其左子树节点个数为1，右子树节点为n-2，所以可得G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
    public int numTrees2(int n) {
        if (n == 0) {
            return 0;
        }
        int[] num = new int[n + 1];
        num[0] = 1;
        num[1] = 1;
        for (int i = 2; i <= n; i ++) {
            for (int j = 0; j < i; j++) {
                num[i] += num[j] * num[i - j - 1];
            }
        }
        return num[n];
    }
    //5ms 8%
    //思路：从小往大生成，新来一数，肯定比现有的节点都大
    // 第一步n可以成为现在所有树的父节点，并且他们都是n的左子树
    // 第二步就是沿着现有子树的右侧尝试不断插入。 如果插入以后，n还有子树，那么这些子树都是n的左子树。

    //使用一个hashmap来存储右子树的个数，键为右子树的长度，值为右子树为该长度的树的个数
    //找n时，遍历之前n-1的map，右子树长度为1的可以生成长度为1和2的右子树的树，2的可以生成1，2，3 。 .....
    //则总个数 = n-1的个数（第一步，n为根，其他为左节点） + map中的key*value（第二步，长度为n的右子树可以生成n种树）
   public int numTrees(int n) {
        if(n==0) return 0;
        int result = 1;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int x=2;
        while(x<=n){
            int count = 0;
            Map<Integer,Integer> temp = new HashMap<>();
            for(int key : map.keySet()){
                for(int i=1 ; i<=key+1 ; i++){
                    temp.put(i,temp.getOrDefault(i,0)+map.get(key));
                }
            }
            map = temp;
            for(int key : map.keySet()){
                count += key*map.get(key);
            }
            result = result + count;
            x++;
        }

        return result;
    }

}
