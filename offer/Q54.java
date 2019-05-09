package leetcode.offer;

/**
 * 字符流中第一个不重复的字符
 *
 * @author yx
 * @create 2019-05-09  20:28
 **/
public class Q54 {
    int index = 1;
    int[] num = new int[128];
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(num[ch]>0){
            num[ch] = -1;
        } else if(num[ch] == 0){
            num[ch] = index++;
        }

    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        int res = index;
        int ans = -1;
        for(int i=0; i< num.length ; i++){
            if(num[i] > 0){
                if(num[i] < res){
                    res = num[i];
                    ans = i;
                }

            }
        }
        return res==index ? '#' : (char)ans;
    }
}
