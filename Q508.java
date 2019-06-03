package leetcode;

import java.util.*;

public class Q508 {

    //思路同501 二叉树中的众数
    //递归计算每个子树的和，使用map记录该和出现的个数，如果超过现有的max，修改记录的值

    int max;
    Map<Integer,Integer> map = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root==null) return new int[0];
        dfs(root);
        int[] ans = new int[res.size()];
        for(int i=0 ; i<ans.length ; i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
    private int dfs(TreeNode root){
        if(root==null) return 0;
        int sum = root.val + dfs(root.left) + dfs(root.right);
        map.put(sum,map.getOrDefault(sum,0)+1);
        int num = map.get(sum);
        if(num>max){
            res.clear();
            res.add(sum);
            max= num;
        } else if(num==max){
            res.add(sum);
        }
        return sum;
    }

}
