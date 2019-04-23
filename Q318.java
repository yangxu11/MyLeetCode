package leetcode;

/**
 * 最大单词长度乘积
 *
 * @author yx
 * @create 2019-04-23  20:16
 **/
public class Q318 {
    //使用位运算，每个字母用一个二进制位表示，如果两个字符串没有相同字母，则二者按位与为0
    //同样可以用来判断两个字符串是否有相同的字母
    public int maxProduct(String[] words) {
        int res = 0;

        int[] bits = new int[words.length];

        for(int i=0 ; i<words.length ; i++){
            for(char c : words[i].toCharArray()){
                int x = c-'a';
                bits[i] = bits[i] | (1<<x);
            }
        }

        for(int i=0 ; i<words.length ; i++){
            for(int j=i+1 ; j<words.length ; j++){
                if((bits[i] & bits[j]) == 0){
                    res = Math.max(res,words[i].length()*words[j].length());
                }
            }
        }

        return res;
    }
}
