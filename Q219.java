package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 存在重复元素II
 *
 * @author yx
 * @create 2019-04-06  11:44
 **/
public class Q219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0 ; i<nums.length ; i++){
            if(map.containsKey(nums[i]) && i-map.get(nums[i]) <=k){
                return true;
            } else{
                map.put(nums[i],i);
            }
        }
        return false;
    }

}
