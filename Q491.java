package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//递增的子序列
public class Q491 {
    //81%
    //注意，要保持原序列的次序，不能排序
    //从头遍历，出现过的数组值要跳过（使用set记录），以当前数组值为头，dfs生成所有以当前值为头的递增子序列
    //dfs算法：
    // 将当前数组值添加到head子序列中，遍历此数组值后面的值，如果值>=头序列中的最大值，则向result中添加head+此值的子序列，
    // 并以此子序列为头进行递归
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        if(nums.length<=1) return res;
        dfs(nums,0,new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums,int start ,List<Integer> list){
        if(list.size()>1){
            res.add(new ArrayList<>(list));
        }
        Set<Integer> set = new HashSet<>();
        for(int i=start ; i<nums.length ; i++){
            if(set.contains(nums[i])) {
                continue;
            }
            if(list.isEmpty() || nums[i]>=list.get(list.size()-1)){
                list.add(nums[i]);
                set.add(nums[i]);
                dfs(nums,i+1,list);
                list.remove(list.size()-1);
            }
        }
    }
}
