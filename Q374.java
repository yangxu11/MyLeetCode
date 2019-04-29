package leetcode;

/**
 * 猜数字大小
 *
 * @author yx
 * @create 2019-04-29  21:47
 **/
public class Q374 {
    class Solution extends GuessGame {
        public int guessNumber(int n) {
            int start = 1;
            int end = n;

            while(start<=end){
                int mid = start + (end - start)/2;

                if(guess(mid)==1){
                    start = mid+1;
                }
                if(guess(mid)==-1){
                    end = mid-1;
                }
                if(guess(mid)==0){
                    return mid;
                }
            }
            return -1;
        }
    }
    class GuessGame{
        public int guess(int n){
            return 0;
        }
    }
}
