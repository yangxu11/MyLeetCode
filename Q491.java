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
    public List<List<Integer>> findSubseqiuences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length<2) return result;
        Set<Integer> set = new HashSet<>();//去除后面重复出现的数组值
        for(int i=0 ; i<nums.length ; i++){
            if(!set.add(nums[i])) continue;
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);//以当前数组值为头
            dfs(list,result,nums,i+1);
        }
        return result;

    }

    public void dfs(List<Integer> head,List<List<Integer>> result,int[] nums,int end){
        if(end>=nums.length) return;
        Set<Integer> set = new HashSet<>();//去除后面重复出现的数组值
        for(int i=end ; i<nums.length ; i++){
            if(!set.add(nums[i])) continue;
            if(nums[i]>=head.get(head.size()-1)){//筛选出递增的数组值
                List<Integer> list = new ArrayList<>(head);
                list.add(nums[i]);
                result.add(list);//将head+当前值的子序列添加到result中
                dfs(list,result,nums,i+1);//更新head,递归
            }
        }
    }
}
