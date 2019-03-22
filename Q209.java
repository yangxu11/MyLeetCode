package leetcode;
//长度最小的数组
public class Q209 {
    //72%
    //先往后加直到 sum>=s 然后比较记录当前的最小值
    //然后从头部开始减 直到sum<s 记录最后满足sum>=s时的长度值
    //注意不存在满足sum>=s的情况，返回0
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0) return 0;

        int sum = 0;
        int len = 0;
        int result = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        while(end<nums.length){
            while(sum<s && end<nums.length){
                sum += nums[end];
                end++;
                len++;
            }
            if(result == Integer.MAX_VALUE && sum<s) return 0;//不存在子数组sum>=s，返回0
            while(sum>=s && start<end){
                sum -= nums[start];
                len--;
                start++;
            }
            result = Math.min(result,len+1);
        }
        return result;
    }




    //超时答案   枚举遍历
    public int minSubArrayLen2(int s, int[] nums) {
        if(nums.length==0) return 0;

        for(int i=1 ; i<=nums.length ; i++){
            for(int j=0 ; j<=nums.length-i ; j++){
                int sum=0;
                for(int k=j ; k<j+i ; k++){
                    sum+=nums[k];
                }
                if(sum>=s){
                    return i;
                }
            }
        }
        return 0;
    }
}
