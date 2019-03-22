package leetcode;
//种花问题
public class Q605 {
    //7ms 99%
    //数连续0的个数count，可种的花为count-1 /2
    //注意首尾的情况
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int result=0;
        int count=1;//首部假设已经有一个0了

        for(int i=0 ; i<flowerbed.length ; i++){
            if(flowerbed[i]==1){
                result += (count-1)/2;
                count=0;
            } else {
                count++;
            }
        }
        result += count/2;//尾部只需要连续2个0
        return result>=n;
    }
}
