package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q229 {
     //由于数组中出现次数超过 13 的数字最多只可能为两个，所以记录两个数字n1、n2，以及他们出现的次数c1、c2，遍历数组并做以下操作：
    //
    //若当前两数字出现则把对应的次数加1；
    //若其中一个出现次数为0，则把当前数字赋给出现次数为0的数字，并将其出现次数置为1；
    //若当前数字不同于任何一个数字，则将两数字的出现次数都减1
    //最后得到两个数字以及他们出现的次数，再遍历一遍数组记录他们的出现次数，若大于 n3 则加入到结果中。
        /**Moore Voting algorithm*/
        public List<Integer> majorityElement(int[] nums) {
            List<Integer> res = new ArrayList<>();
            if(nums.length==0) return res;
            int r1=0,r2=0;
            int count1=0,count2=0;
            for(int i=0 ; i<nums.length ; i++){
                if(nums[i]==r1){
                    count1++;
                } else if(nums[i]==r2){
                    count2++;
                } else if(count1==0){
                    r1 = nums[i];
                    count1=1;
                } else if(count2==0){
                    r2 = nums[i];
                    count2=1;
                } else{
                    --count1;
                    --count2;
                }
            }
            count1=0;
            count2 = 0;
            for(int num : nums){
                if(num==r1){
                    count1 ++;
                } else if(num==r2){
                    count2 ++;
                }
            }
            if(count1>nums.length/3) res.add(r1);
            if(count2>nums.length/3) res.add(r2);
            return res;
        }
}
