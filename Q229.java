package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q229 {
    public static void main(String[] args) {
        int[] a ={1,1,1,1,2,3,4,4,4,4,4,3,3,3,3,3,3,3,5,5,5,2,2,2,2,2,2,2,2,2};
        System.out.println(majorityElement(a));
    }
        /**Moore Voting algorithm*/
        public static List<Integer> majorityElement(int[] nums) {
            List<Integer> result = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return result;
            }
            int count1 = 0;
            int count2 = 0;
            int candidate1 = 0;
            int candidate2 = 1;
            for (int num : nums) {
                if (num == candidate1) {
                    count1++;
                } else if (num == candidate2) {
                    count2++;
                } else if (count1 == 0) {
                    candidate1 = num;
                    count1 = 1;
                } else if (count2 == 0) {
                    candidate2 = num;
                    count2 = 1;
                } else {
                    count1--;
                    count2--;
                }
            }
            count1 = 0;
            count2 = 0;
            for (int num : nums) {
                if (num == candidate1) {
                    count1 += 2;
                } else {
                    count1--;
                }
                if (num == candidate2) {
                    count2 += 2;
                } else {
                    count2--;
                }
            }
            if (count1 > 0) {
                result.add(candidate1);
            }
            if (count2 > 0) {
                result.add(candidate2);
            }
            return result;
        }
}
