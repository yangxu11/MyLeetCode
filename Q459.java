package leetcode;

//重复的子字符串
public class Q459 {
    //16ms 88%
    //首先找到一个区间长度，使得字符串能被完整分割（能被整除）
    //然后查看每个分割出的字符串是否相同，使用substring()分割
    //最终没有符合条件的返回false
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for(int i=1 ; i<len ; i++){
            if(len%i==0){
                String pre = s.substring(0,i);
                int flag=0;
                for(int j=i ; j<s.length()-i+1 ; j+=i){
                    String str = s.substring(j,j+i);
                    if(!str.equals(pre)){
                        flag=1;
                        break;
                    }
                }
                if(flag==0) return true;
            }
        }
        return false;
    }
}
