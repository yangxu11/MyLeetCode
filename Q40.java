package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//组合总数II
public class Q40 {
    //执行用时: 25 ms, 在Combination Sum II的Java提交中击败了56.37% 的用户
    //内存消耗: 42.4 MB, 在Combination Sum II的Java提交中击败了2.38% 的用户

    //思路同Q39
    //遍历数组，每个数组元素向后寻找（防止重复），如果==target将当前组合存入res,否则将当前元素加入组合，递归
    //与39不同的是，每个元素只能使用一次，所有要从index+1开始寻找，而且存在重复数组值，要先排序，遍历时跳过重复元素
    List<List<Integer>> res= new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);//排序，便于跳过重复元素
        getSum(candidates,target,new ArrayList<>(),0,0);
        return res;
    }
    public void getSum(int[] nums,int target,List<Integer> pre,int sum,int index){
        if(sum>target) return;

        for(int i=index ; i<nums.length ; i++){//index+1向后寻找，防止重复
            pre.add(nums[i]);
            if(sum+nums[i] == target){
                res.add(new ArrayList<>(pre));//必须新建list,否则会与pre共同变化
            }else{
                getSum(nums,target,pre,sum+nums[i],i+1);
            }
            pre.remove(pre.size()-1);//复原
            while(i+1<nums.length && nums[i+1] == nums[i]){//跳过重复元素
                i++;
            }
        }
    }
}
