package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 两个数组的交集
 *
 * @author yx
 * @create 2019-04-27  19:54
 **/
public class Q349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();

        for(int num : nums1){
            set.add(num);
        }

        for(int num : nums2){
            if(set.contains(num)){
                res.add(num);
            }
        }
        int[] ans = new int[res.size()];
        int index = 0;
        for(int num : res){
            ans[index++] = num;
        }
        return ans;
    }
}
