package leetcode;

public class Q1014 {
    //二分法
    public int shipWithinDays(int[] weights, int D) {
        int start = findMax(weights);
        int end = getTotal(weights);
        while(start<end){
            int mid = start + (end-start)/2;
            int day = getDay(weights,mid);
            if(day>D){
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return start;
    }
    public int getDay(int[] w,int num){
        int day=0;
        int sum = 0;
        for(int i=0 ; i<w.length ; i++){
            sum+=w[i];
            if(sum>num){
                day++;
                sum = w[i];
            }
        }
        return day+1;
    }
    public int getTotal(int[] w){
        int sum = 0;
        for(int i:w){
            sum+=i;
        }
        return sum;
    }
    public int findMax(int[] w){
        int max = 0;
        for(int i:w){
            if(i>max){
                max = i;
            }
        }
        return max;
    }
}
