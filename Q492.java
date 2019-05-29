package leetcode;

/**
 * 构造矩形
 *
 * @author yx
 * @create 2019-05-29  20:06
 **/
public class Q492 {
    public int[] constructRectangle(int area) {
        int num = (int)Math.sqrt(area);

        for(int i=num ; i>=1 ; i--){
            if(area%i==0){
                int l = Math.max(i,area/i);
                return new int[]{l,area/l};
            }
        }
        return new int[]{-1,-1};
    }
}
