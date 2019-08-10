package leetcode;

/**
 * 矩形重叠
 *
 * @author yx
 * @create 2019-08-10  16:32
 **/
public class Q836 {
    //找到不相交的情况，四个方向
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !((rec1[2] <= rec2[0] || rec2[2] <= rec1[0])
                || (rec1[3] <= rec2[1] || rec2[3] <= rec1[1]));
    }
}
