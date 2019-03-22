package leetcode;
//sqrt(x)
public class Q69 {
    //二分法
    public int mySqrt(int x) {
        if(x <= 1)
            return x;
        int left = 1;
        int right = x;
        while(true)
        {
            int mid = left + (right - left)/2;//不直接相加除以2是防止溢出
            if(mid > x/mid)
                right = mid;
            else
            {
                if(mid+1 > x/(mid+1))
                    return mid;
                else
                    left = mid;
            }
        }
    }
}
