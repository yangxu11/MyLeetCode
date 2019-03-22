package leetcode;
//水壶问题
public class Q385 {
    //z必须为x和y的最大公约数的倍数，辗转相除法求最大公约数
    //注意0的问题
    public boolean canMeasureWater(int x, int y, int z) {
        if(x+y < z) return false;
        if(z==0){
            return true;
        }
        if(x==0 || y==0){
            return x==0 ? y==z : x==z;
        }
        //辗转相除法  gcd(x,y)=gcd（y,x%y）
        while(y!=0){
            int r = x%y;
            x=y;
            y=r;
        }
        return z%x==0 ? true : false;
    }
}
