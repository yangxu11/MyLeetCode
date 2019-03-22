package leetcode;

import java.util.ArrayList;
import java.util.List;
//目标和
public class Q494 {
//执行用时: 16 ms, 在Target Sum的Java提交中击败了88.99% 的用户
//内存消耗: 24.3 MB, 在Target Sum的Java提交中击败了28.23% 的用户

    //原问题等同于： 找到nums一个正子集和一个负子集，使得总和等于target
    //我们假设P是正子集，N是负子集 例如： 假设nums = [1, 2, 3, 4, 5]，target = 3，一个可能的解决方案是+1-2+3-4+5 = 3 这里正子集P = [1, 3, 5]和负子集N = [2, 4]
    //那么让我们看看如何将其转换为子集求和问题：
    //                  sum(P) - sum(N) = target
    //sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
    //                       2 * sum(P) = target + sum(nums)
    //因此，原来的问题已转化为一个求子集的和问题： 找到nums的一个子集 P，使得sum(P) = (target + sum(nums)) / 2
    public int findTargetSumWays(int[] nums, int S) {
        int sum=0;
        for(int num : nums){
            sum+=num;
        }
        return sum<S||(sum+S)%2>0 ? 0 : subset(nums,(S+sum)/2);
    }

    public int subset(int[] nums , int s){
        int[] dp = new int[s+1];
        dp[0] = 1;
        for(int num : nums){
            for(int i=s ; i>=num ; i--){
                dp[i] += dp[i-num];
            }
        }
        return dp[s];
    }
    //执行用时: 675 ms, 在Target Sum的Java提交中击败了13.11% 的用户
    //内存消耗: 23.9 MB, 在Target Sum的Java提交中击败了80.00% 的用户

    //深度优先搜索，从坐标起点开始累计和，和有两种情况，+和- ，累计到最后有几个和为S则返回
    public int findTargetSumWays1(int[] nums, int S) {
        return dfs(nums,0,S,0,0);
    }

    public int dfs(int[] nums,int index,int S,int sum,int result){
        if(index == nums.length) {
            if(sum==S) return ++result;
            return result;
        }
        return dfs(nums,index+1,S,sum+nums[index],result)+dfs(nums,index+1,S,sum-nums[index],result);
    }
    //执行用时: 1669 ms, 在Target Sum的Java提交中击败了1.57% 的用户
    //内存消耗: 229.2 MB, 在Target Sum的Java提交中击败了0.00% 的用户
    public int findTargetSumWays2(int[] nums, int S) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if(sum<S) return 0;
        //if(sum==S) return 1;
        List<Integer> dp = new ArrayList<>();
        dp.add(sum);

        int result = sum==S ? 1 : 0;

        for(int i=0 ; i<nums.length ; i++){
            List<Integer> temp = new ArrayList<>();
            for(int num : dp){
                if(num>=S){
                    temp.add(num);
                }
                if(num - 2*nums[i] == S){
                    result++;
                    temp.add(S);
                } else if(num - 2*nums[i]>S){
                    temp.add(num - 2*nums[i]);
                }
            }
            dp = temp;
        }
        return result;
    }
}
