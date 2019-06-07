package leetcode;

import java.util.HashMap;
import java.util.Map;

//连续数组
public class Q525 {
    public int findMaxLength(int[] nums) {
        if(nums.length==0) return 0;

        for(int i=0 ; i<nums.length ; i++){
            if(nums[i] == 0){
                nums[i] = -1;
            }
        }

        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        int sum = 0;
        for(int i=0 ; i<nums.length ; i++){
            sum += nums[i];
            if(sum == 0 && i>res){
                res = i+1;
            }
            if(map.containsKey(sum)){
                res = Math.max(i-map.get(sum),res);
            } else{
                map.put(sum,i);
            }
        }

        return res;
    }

}
