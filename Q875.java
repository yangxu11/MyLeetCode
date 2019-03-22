package leetcode;

public class Q875 {
    //执行用时: 29 ms, 在Koko Eating Bananas的Java提交中击败了52.22% 的用户
    //内存消耗: 36.7 MB, 在Koko Eating Bananas的Java提交中击败了33.33% 的用户

    //以最大值为上界，1为下界，二分查找，算出mid对应所需的时间，逼近
    public int minEatingSpeed(int[] piles, int H) {
        int start=1;
        int end = getMax(piles);
        int res = Integer.MAX_VALUE;

        while(start<end){
            int mid = start+(end-start)/2;

            int h = getH(piles,mid);

            if(h>H){
                start = mid+1;
            } else{
                end = mid;
            }

        }
        return start;
    }

    public int getH(int[] p,int k){
        int h=0;
        for(int i : p){
            h += i%k==0 ? i/k : i/k+1;
        }
        return h;
    }

    public int getMax(int[] p) {
        int max = 0;
        for(int i : p){
            max = Math.max(i,max);
        }
        return max;
    }
}
