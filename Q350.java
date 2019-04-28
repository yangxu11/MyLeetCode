package leetcode;

import java.util.*;

/**
 * 两个数组的交集II
 *
 * @author yx
 * @create 2019-04-28  15:33
 **/
public class Q350 {
    //排序
    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int i=0,j=0;
        while(i<nums1.length && j<nums2.length)
        {
            if(nums1[i]<nums2[j])
            {i++;}
            else if(nums1[i]>nums2[j])
            {j++;}
            else
            {
                list.add(nums1[i]);
                i++;j++;
            }
        }
        int[] result = new int[list.size()];
        int k=0;
        for(Integer x: list)
        {
            result[k++] = x;
        }

        return result;
    }
    //map
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0 ; i<nums1.length ; i++) {
            if(map.containsKey(nums1[i])) {
                map.put(nums1[i],map.get(nums1[i])+1);
            } else {
                map.put(nums1[i],1);
            }
        }
        for(int i=0 ; i<nums2.length ; i++) {
            if(map.containsKey(nums2[i])) {
                if(map.get(nums2[i]) > 0) {
                    list.add(nums2[i]);
                    map.put(nums2[i],map.get(nums2[i])-1);
                }

            }
        }
        int[] commonArray = new int[list.size()];
        for(int i=0 ; i<list.size() ; i++) {
            commonArray[i] = list.get(i);
        }
        return commonArray;
    }
}
