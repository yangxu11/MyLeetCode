package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 汇总区间
 *
 * @author yx
 * @create 2019-04-09  17:06
 **/
public class Q228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        if(nums.length==0) return res;

        int count = 0;
        while(count<nums.length){
            StringBuilder sb = new StringBuilder();
            int old = count;
            sb.append(nums[count]+"");
            while(count<nums.length-1 && nums[count]+1 == nums[count+1]){
                ++count;
            }
            if(count>old){
                sb.append("->"+nums[count]);
            }
            ++count;
            res.add(sb.toString());
        }
        return res;
    }
}
