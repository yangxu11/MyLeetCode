package leetcode;

/**
 * 神奇字符串
 *
 * @author yx
 * @create 2019-05-28  20:37
 **/
public class Q481 {
    public int magicalString(int n) {
        if(n==0) return 0;
        if(n<=3) return 1;
        int res = 1;
        int[] cur = new int[n];
        cur[0] = 1;
        cur[1] = 2;
        cur[2] = 2;
        int slow = 2;
        int sign = 1;
        int count = 3;
        while(n>count){
            int num = cur[slow];
            int c;
            if(sign ==1){
                c = 1;
                if(count + num <=n){
                    res += num;
                } else{
                    res += n-count;
                    break;
                }
                sign = 2;
            } else{
                c = 2;
                sign = 1;
            }
            for(int i=count ; i<count+num && i<n ; i++){
                cur[i] = c;
            }
            count+=num;

            ++slow;
        }
        return res;
    }
}
