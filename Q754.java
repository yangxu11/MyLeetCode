package leetcode;

/**
 * 到达的最终数字
 *
 * @author yx
 * @create 2019-07-21  16:21
 **/
public class Q754 {

    public int reachNumber(int target) {
        int index = 0;
        target = Math.abs(target);
        int sum = 0;
        while(true){
            sum += ++index;
            if(sum>=target &&(sum-target)%2==0){
                break;
            }
        }
        return index;
    }
}
