package leetcode;

import java.util.ArrayList;
import java.util.List;

//数组中重复的数
public class Q442 {
    //16ms 70% 没有使用额外空间
    //遍历，将数组值对应的下标上的元素置为负数，如果遍历到其已经为负数，则为重复元素
    public List<Integer> findDuplicates1(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0 ; i<nums.length ; i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]<0){
                result.add(++index);
            } else {
                nums[index] = 0 - nums[index];
            }
        }
        return result;
    }
    //11ms 92%
    //使用了O(n)的空间
    public List<Integer> findDuplicates(int[] nums) {
        int[] visited = new int[nums.length];
        List<Integer> result = new ArrayList<>();
        for(int i=0 ; i<nums.length ; i++){
            if(visited[nums[i]-1] == 1){
                result.add(nums[i]);
            } else {
                visited[nums[i]-1]=1;
            }
        }
        return result;
    }
    //920ms  2%  没有使用额外空间
    // 交换数组的元素，将该位置上的元素交换到它对应的下标的位置，直到该位置的元素与其下标对应，或者出现重复元素无限循环了
    //如果出现重复元素就将其加入数组中
    public List<Integer> findDuplicates2(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0 ; i<nums.length ; i++){
            while(nums[i]-1 != i) {
                if(nums[i]==nums[nums[i]-1]){
                    if(!result.contains(nums[i])){
                        result.add(nums[i]);
                    }
                    break;
                }
                int temp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[temp-1] = temp;
            }
        }
        return result;
    }
}
