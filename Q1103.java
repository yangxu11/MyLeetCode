package leetcode;

/**
 * 分糖果
 *
 * @author yx
 * @create 2019-09-30  9:38
 **/
public class Q1103 {
    public static void main(String[] args) {
        Q1103 q = new Q1103();
        System.out.println(q.distributeCandies(80,4));
    }
    public int[] distributeCandies(int candies, int num_people) {
        int len = num_people;

        int[] res = new int[len];

        int total = (1+len)*len/2;
        int step = 0;
        long sum = 0;
        while(sum<=candies){
            sum += total + step*len*len;
            ++step;
        }

        --step;
        if(candies>=total){
            for(int i=0 ; i<len ; i++){
                res[i] = (i+1)*step+(step-1)*len;
                candies-= res[i];
            }
        }

        for(int i=0 ; i<len ; i++){
            if(candies<=0) break;
            if(candies>=i+1+step*len){
                res[i] += i+1+step*len;
                candies -= i+1+step*len;
            } else{
                res[i] += candies;
                break;
            }
        }

        return res;
    }
}
