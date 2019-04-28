package leetcode;

/**
 * 水壶问题
 *
 * @author yx
 * @create 2019-04-28  15:54
 **/
public class Q365 {
    //辗转相除法求得最大公约数，如果z能被其整除，则可以
    public boolean canMeasureWater(int x, int y, int z) {
        if(x==z || y==z || x+y==z) return true;
        if(x==0 || y==0) return false;
        if(x+y < z) return false;

        return z%getCommon(x,y) == 0;

    }
    public int getCommon(int x,int y){
        while(y>0){
            int r = x%y;
            x = y;
            y = r;
        }
        return x;
    }
}
