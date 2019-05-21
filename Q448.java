package leetcode;

import java.util.ArrayList;
import java.util.List;
//找出数组中消失的数
public class Q448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        for(int i=0 ; i<nums.length ; i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index] = 0-nums[index];
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i=0 ; i<nums.length ; i++){
            if(nums[i]>0){
                res.add(i+1);
            }
        }
        return res;
    }
}
