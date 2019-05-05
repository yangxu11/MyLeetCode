package leetcode.offer;

/**
 * 数组中出现的超过一半次数的数字
 *
 * @author yx
 * @create 2019-05-05  16:50
 **/
public class Q28 {
    public int MoreThanHalfNum_Solution(int [] array) {
        int res = array[0];
        int count = 0;
        for(int i=0 ; i<array.length ; i++){
            if(res == array[i]){
                ++count;
            }else{
                --count;
                if(count==0 && i<array.length-1){
                    res = array[i+1];
                }
            }
        }
        count =0;
        for(int i=0 ; i<array.length ; i++){
            if(array[i] == res){
                ++count;
            }
        }
        return count>array.length/2 ? res : 0;
    }
}
