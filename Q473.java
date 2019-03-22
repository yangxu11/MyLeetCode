package leetcode;

import java.util.Arrays;
//火柴拼正方形
public class Q473 {
    //97%
    //先确定边长，如果无法4等分，return false
    //将数组排序（确保从长的火柴开始遍历）
    //建立known数组来记录此火柴是否使用过
    //从长火柴开始遍历，判断能否选出数根火柴与其一起拼出一边，能count++，不能return false
    //判断算法使用dfs，如果当前选出的总长度sum>side，return false，
    // 如果==side,return true，如果<side，继续在剩余火柴中寻找合适火柴
    //所有情况中有一种return true，则为true，否则return false
    //注意，其中known数组的变化，当选择当前火柴i的所有情况都为false，known[i]依然为0
    //最后判断是否产生了四条边，return count==4
    int side;
    public boolean makesquare(int[] nums) {
        if(nums.length<4) return false;

        //先确定边长，如果无法4等分，return false
        int sum=0;
        for(int i=0 ; i<nums.length ; i++) {
            sum += nums[i];
        }
        if(sum%4 !=0) return false;
        side = sum/4;

        Arrays.sort(nums);//将数组排序（确保从长的火柴开始遍历）

        int[] known = new int[nums.length];//建立known数组来记录此火柴是否使用过
        int count=0;//记录符合条件的边

        //从长火柴开始遍历，判断能否选出数根火柴与其一起拼出一边，能count++，不能return false
        for(int i=nums.length-1 ; i>=0 ; i--){
            if(known[i]==0){
                if(isValid(i,nums,known,0)){
                    count++;
                } else {
                    return false;
                }
            }
        }
        return count==4;
    }
    public boolean isValid(int end,int[] nums,int[] known,int sum){
        if(end<0 || known[end]==1) return false;
        if(nums[end]+sum>side){
            return false;
        } else if(nums[end]+sum==side){
            known[end]=1;//符合条件，赋值为1
            return true;
        } else {
            boolean b = false;
            known[end]=1;//暂时满足要求，赋值为1
            sum += nums[end];
            for(int i=end-1 ; i>=0 ; i--){//遍历比当前火柴短的所有情况
                b = b||isValid(i,nums,known,sum);//取并，只要有一种情况满足条件
            }
            if(!b){
                known[end]=0;//所有情况都不符合要求，重新赋值为0
            }
            return b;
        }
    }
}
