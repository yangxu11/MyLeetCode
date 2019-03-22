package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//数组中的K-diff数对
public class Q532 {
    //34ms 50%
    //使用hashmap存储数组值及其的个数，同时使用hashset存储已经使用过的值
    //然后遍历数组，如果map中有i+k，则存在一组数对，result++
    //注意K=0时，此时不能使用i+k来判断，要判断map的个数来决定result
    public int findPairs(int[] nums, int k) {
        if(nums.length<2 || k<0) return 0;
        int result=0;

        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        if(k==0){
            for(int key : map.keySet()){
                if(map.get(key)>1){
                    result++;
                }
            }
        } else {
            for(int i : nums){
                if(map.containsKey(i+k) && set.add(i)){
                    result++;
                }
            }
        }

        return result;
    }
}
