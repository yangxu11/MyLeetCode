package leetcode;

import java.util.Arrays;

/**
 * 最长和谐子序列
 *
 * @author yx
 * @create 2019-06-16  15:14
 **/
public class Q594 {
    public int findLHS(int[] nums) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        int res = 0;
        int countPre = 0;
        int countCur = 0;
        int pre = nums[0];
        int cur = nums[0];
        int index = 0;
        while(index<nums.length&&nums[index]==cur){
            ++index;
            ++countPre;
        }
        if(index==nums.length) return 0;
        cur = nums[index];
        pre = nums[0];


        for(int i=index ; i<nums.length ; i++){
            if(nums[i] == cur){
                ++countCur;
            } else{
                if(cur == pre+1){
                    res = Math.max(res,countCur+countPre);
                }
                pre = cur;
                cur = nums[i];
                countPre = countCur;
                countCur = 1;
            }
        }
        if(cur == pre+1){
            res = Math.max(res,countCur+countPre);
        }
        return res;
    }
}
