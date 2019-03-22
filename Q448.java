package leetcode;

import java.util.ArrayList;
import java.util.List;
//找出数组中消失的数
public class Q448 {
    //空间复杂度O(n) 70%
    public List<Integer> findDisappearedNumbers1(int[] nums) {

        List<Integer> result = new ArrayList<>();
        int[] exist = new int[nums.length];

        for(int i=0 ; i<nums.length ; i++) {
            exist[nums[i]-1] = 1;
        }

        for(int i=0 ; i<nums.length ; i++) {
            if(exist[i]==0) {
                result.add(i+1);
            }
        }
        return result;
    }
    //空间复杂度O(1) 40%
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> result = new ArrayList<>();


        for(int i=0 ; i<nums.length ;) {
            if(nums[i] != i+1 && nums[nums[i]-1]!=nums[i]) {
                int temp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[nums[i]-1] = temp;
            } else {
                i++;
            }
        }
        for(int i=0 ; i<nums.length ; i++) {
            if(nums[i]!=i+1){
                result.add(i+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Q448 q = new Q448();
        int[] a = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(q.findDisappearedNumbers2(a));
    }
}
