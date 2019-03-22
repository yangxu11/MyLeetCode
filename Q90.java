package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//子集II
public class Q90 {
    //执行用时: 5 ms, 在Subsets II的Java提交中击败了71.76% 的用户
    //内存消耗: 37.6 MB, 在Subsets II的Java提交中击败了0.81% 的用户

    //思路同77（组合），46，47（全排列），78（子集）
    //有重复数字后，将数组排序，遍历时跳过重复数字，即可避免重复
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums,new ArrayList<>(),0);
        return res;
    }

    public void dfs(int[] nums,List<Integer> list,int index){
        res.add(new ArrayList<>(list));

        for(int i=index;i<nums.length ; i++){
            list.add(nums[i]);
            dfs(nums,list,i+1);
            list.remove(list.size()-1);
            while(i+1<nums.length && nums[i]==nums[i+1]){
                i++;
            }
        }
    }
}
