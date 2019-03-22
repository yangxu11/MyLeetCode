package leetcode;
//整数转罗马数字
public class Q12 {
    //注意在这种已知情况多的时候，要用数组去存储各种情况，if else太麻烦
    //例如：方向
    public String intToRoman(int num) {
        String res = "";
        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] key={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for(int i=0 ; i<13 ; i++){
            while(num>=values[i]){
                res += key[i];
                num -= values[i];
            }
        }
        return res;
    }
}
