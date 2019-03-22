package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//全排列II
public class Q47 {
    //执行用时: 7 ms, 在Permutations II的Java提交中击败了77.70% 的用户
    //内存消耗: 45.1 MB, 在Permutations II的Java提交中击败了9.65% 的用户

    //思路同Q46
    //当有重复元素时，要将数组排序，遍历时跳过重复的数字
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);//排序，便于跳过重复数字
        dfs(nums,new int[nums.length],new ArrayList<>());
        return res;
    }
    public void dfs(int[] nums,int[] visited,List<Integer> list){
        if(nums.length == list.size()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0 ; i<nums.length ; i++){
            if(visited[i]==0){
                list.add(nums[i]);
                visited[i] = 1;
                dfs(nums,visited,list);
                visited[i]=0;
                list.remove(list.size()-1);
                while(i+1<nums.length && nums[i]==nums[i+1]){//跳过重复数字
                    i++;
                }
            }
        }
    }
}
