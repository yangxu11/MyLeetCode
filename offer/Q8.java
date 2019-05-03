package leetcode.offer;

/**
 * 跳台阶
 *
 * @author yx
 * @create 2019-05-03  11:35
 **/
public class Q8 {
    public int JumpFloor(int target) {
        if(target==0 || target == 1 || target ==2) return target;
        int n1 = 1;
        int n2 = 2;

        for(int i=3 ; i<=target ; i++){
            n2 = n1+n2;
            n1 = n2-n1;
        }
        return n2;
    }
}
