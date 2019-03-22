package leetcode;

import java.util.ArrayList;
import java.util.List;
//组合
public class Q77 {
    //执行用时: 17 ms, 在Combinations的Java提交中击败了70.79% 的用户
    //内存消耗: 42 MB, 在Combinations的Java提交中击败了15.56% 的用户

    //思路同46，47（全排列）
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for(int i=0 ; i<n ; i++){
            nums[i] = i+1;
        }
        dfs(nums,k,0,new ArrayList<>());
        return res;
    }
    public void dfs(int[] nums,int k,int index,List<Integer> list){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=index ; i<nums.length ; i++){
            list.add(nums[i]);
            dfs(nums,k,i+1,list);
            list.remove(list.size()-1);
        }
    }
}
