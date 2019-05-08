package leetcode.offer;

/**
 * 数组中重复的数
 *
 * @author yx
 * @create 2019-05-08  20:26
 **/
public class Q50 {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        int[] num = new int[length];

        for(int i=0 ; i<length ; i++){
            if(num[numbers[i]] > 0){
                duplication[0] = numbers[i];
                return true;
            }
            num[numbers[i]] += 1;
        }
        return false;
    }
}
