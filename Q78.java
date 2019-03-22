package leetcode;

import java.util.ArrayList;
import java.util.List;
//子集
public class Q78 {
    //执行用时: 2 ms, 在Subsets的Java提交中击败了83.92% 的用户
    //内存消耗: 39.1 MB, 在Subsets的Java提交中击败了0.73% 的用户

    //思路同77（组合），46，47（全排列）
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0,new ArrayList<>());
        return res;
    }
    public void dfs(int[] nums,int index,List<Integer> list){
        res.add(new ArrayList<>(list));
        for(int i=index ; i<nums.length ; i++){
            list.add(nums[i]);
            dfs(nums,i+1,list);
            list.remove(list.size()-1);
        }
    }
}
