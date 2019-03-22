package leetcode;
//两数之和-有序数组
public class Q167 {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length-1;

        int[] result = new int[2];

        while(start<end){
            if(numbers[start]+numbers[end]>target){
                end--;
            } else if(numbers[start]+numbers[end]<target){
                start++;
            } else{
                result[0] = start+1;
                result[1] = end+1;
                break;
            }
        }
        return result;
    }
}
