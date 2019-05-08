package leetcode.offer;

/**
 * 扑克牌顺子
 *
 * @author yx
 * @create 2019-05-08  17:36
 **/
public class Q45 {
    public boolean isContinuous(int [] numbers) {
        int len = numbers.length;
        if(len<5) return false;
        int[] num = new int[14];
        int min = 14;
        int max = -1;

        for(int i=0 ; i<len ; i++){
            num[numbers[i]] += 1;
            if(numbers[i] == 0){
                continue;
            }
            if(num[numbers[i]] > 1){
                return false;
            }
            min = Math.min(min,numbers[i]);
            max = Math.max(max,numbers[i]);
        }
        if(max - min >= 5){
            return false;
        } else{
            return true;
        }
    }
}
