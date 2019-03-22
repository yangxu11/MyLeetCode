package leetcode;
//罗马数字转整数
public class Q13 {
    //同12 要将各种情况以数组形式展现
    public int romanToInt(String s) {
        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] key={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int res = 0;
        for(int i=0 ; i<13 ; i++){
            while(s.startsWith(key[i])){
                res+=values[i];
                s = s.substring(key[i].length());
            }
        }
        return res;
    }
}
