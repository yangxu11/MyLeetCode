package leetcode;

//跳跃游戏
// 从当前可跳的长度一个个往下跳，剩余值-1，遇见可跳长度（数组值）超过剩余值时，
//重新开始，如果可跳长度未更新，并且最后的值为0，则为false
public class Q55 {
    public boolean canJump(int[] nums) {
        if(nums.length==0) return true;
        if(nums[0]==0 && nums.length>1) return false;
        int remain = nums[0];

        for(int i=1 ; i<nums.length-1 ; i++){
            remain--;
            if(nums[i] >= remain){
                remain = nums[i];
            }
            if(remain==0) return false;
        }
        return true;
    }
}
