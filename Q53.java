package leetcode;
//最大子序列的和
public class Q53 {
    //9ms 94% O(n)
    // 如果当前子序列的和大于0，则继续加上当前数组值，否则直接舍弃（和为0只会减小后面子序列的和），令和为当前数组值
    public int maxSubArray(int[] nums) {
        int end = 0;
        int sum=0;
        int result = Integer.MIN_VALUE;
        while(end < nums.length){
            if(sum>0){
                sum += nums[end];
            } else {
                sum = nums[end];
            }
            result = Math.max(result,sum);
            end++;
        }
        return result;
    }
    //分治算法 17ms  32%  O(nlogn)
    //先算出左右的最大子序列，再算左右之间的最大子序列，比较得出其最大值
    public int maxSubArray2(int[] nums) {
        return maxSum(nums,0,nums.length-1);
    }
    public int maxSum(int[] nums , int left , int right) {
        if(left==right) {
            return nums[left];
        }

        int center  = (left + right) /2;
        int leftSum = maxSum(nums,left,center);
        int rightSum = maxSum(nums,center+1 , right);

        int maxLeftBoardSum=Integer.MIN_VALUE,leftBoardSum=0;
        for(int i=center ; i>=left ; i--){
            leftBoardSum += nums[i];
            if(maxLeftBoardSum < leftBoardSum ){
                maxLeftBoardSum = leftBoardSum;
            }
        }
        int maxRightBoardSum=Integer.MIN_VALUE,rightBoardSum=0;
        for(int i=center+1 ; i<=right ; i++){
            rightBoardSum += nums[i];
            if(maxRightBoardSum < rightBoardSum ){
                maxRightBoardSum = rightBoardSum;
            }
        }

        return max3(leftSum,rightSum,maxLeftBoardSum+maxRightBoardSum);
    }
    public int max3(int i ,int j , int k){
        int x = Math.max(i,j);
        return Math.max(x,k);
    }
}
