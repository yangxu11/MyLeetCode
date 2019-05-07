package leetcode.offer;

/**
 * 数组中只出现过一次的数
 *
 * @author yx
 * @create 2019-05-07  19:48
 **/
public class Q40 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int num = 0;
        for(int i=0 ; i<array.length ; i++){
            num ^= array[i];
        }
        int move = Integer.toBinaryString(num).length()-1;
        num >>= move;
        int a=0;
        int b=0;
        for(int i=0 ; i<array.length ; i++){
            if((num & (array[i]>>move)) == 1){
                a ^= array[i];
            } else{
                b ^= array[i];
            }
        }
        num1[0] = a;
        num2[0] = b;
    }
}
