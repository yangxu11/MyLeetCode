package leetcode;

import java.util.ArrayList;
import java.util.List;

//全排列
public class Q46 {
    //执行用时: 3 ms, 在Permutations的Java提交中击败了95.19% 的用户
    //内存消耗: 39.1 MB, 在Permutations的Java提交中击败了0.76% 的用户

    //递归，定义一个数组visited[]记录那些数被遍历过，每次递归后要还原
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums,new int[nums.length],new ArrayList<>());
        return res;

    }

    public void dfs(int[] nums,int[] visited,List<Integer> list){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));//一定要新建一个list
            return;
        }
        for(int i=0 ; i<nums.length  ; i++){
            if(visited[i]==0){
                list.add(nums[i]);
                visited[i]=1;
                dfs(nums,visited,list);
                visited[i]=0;//还原
                list.remove(list.size()-1);//还原
            }
        }
    }
}
