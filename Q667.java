package leetcode;
//优美的排列II
public class Q667 {
    //7ms 70%
    //最小，最大值穿插取值，然后顺延剩下的值
    //比如最后是最大值6，剩下的为5，4.... 如果最后是最小值3，剩下的为4,5....
    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        int start = 1;
        int end = n;
        result[0] = 1;
        int i=0;
        //选出K-1个不同差值
        for(; i<k ; i++){
            if(i%2!=0){
                result[i]=end;
                end--;
            } else {
                result[i] = start;
                start++;
            }
        }
        //输出剩下差值为1的值
        if(result[i-1]==end+1){
            for(int j=i ; j<n ; j++){
                result[j]=end--;
            }
        } else {
            for(int j=i ; j<n ; j++){
                result[j]=start++;
            }
        }
        return result;
    }
}
