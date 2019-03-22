package leetcode;

import java.util.ArrayList;
import java.util.List;
//组合总数
public class Q39 {
    //执行用时: 27 ms, 在Combination Sum的Java提交中击败了33.58% 的用户
    //内存消耗: 47.4 MB, 在Combination Sum的Java提交中击败了0.78% 的用户

    //递归
    //如果当前组合的和==target加入res,否则加入新的list继续递归
    //每次循环都需要将组合pre复原，去掉最后加上的nums[i]
    //注意不能有重复组合，每个数只能向自己的后方找，否则会重复
    List<List<Integer>> res= new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        getSum(candidates,target,new ArrayList<>(),0,0);
        return res;
    }
    public void getSum(int[] nums,int target,List<Integer> pre,int sum,int index){
        if(sum>target) return;

        for(int i=index ; i<nums.length ; i++){//index向后寻找，防止重复
            pre.add(nums[i]);
            if(sum+nums[i] == target){
                res.add(new ArrayList<>(pre));
            }else{
                getSum(nums,target,pre,sum+nums[i],i);
            }
            pre.remove(pre.size()-1);//复原
        }
    }
}
