package leetcode;

import java.util.HashMap;
import java.util.Map;
//数组的度
// hashmap存储 key=数组值，value=[下标起始，下标结束，该值的个数]，然后遍历比较80%
public class Q697 {
    public int findShortestSubArray(int[] nums) {
        //if(nums.length==0) return 0;
        Map<Integer,int[]> map = new HashMap<>();
        for(int i=0 ; i<nums.length ; i++) {
            if(map.containsKey(nums[i])){
                int[] a = map.get(nums[i]);
                a[1] = i;
                a[2] = a[2]+1;
            } else {
                map.put(nums[i],new int[]{i,i,1});
            }
        }
        int minlen=50000;
        int maxnum=1;
        for(int i : map.keySet()){
            int[] a = map.get(i);
            if(a[2]>maxnum){
                minlen = a[1]-a[0]+1;
                maxnum=a[2];
            } else if(a[2]==maxnum) {
                minlen = Math.min(minlen,a[1]-a[0]+1);
            }
        }
        return minlen;
    }
}
