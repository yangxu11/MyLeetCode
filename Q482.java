package leetcode;

/**
 * 密钥格式化
 *
 * @author yx
 * @create 2019-05-28  21:09
 **/
public class Q482 {

    public String licenseKeyFormatting(String S, int K) {
        S = S.toUpperCase();

        String[] strs = S.split("-");

        StringBuilder sb = new StringBuilder();

        for(int i=0 ; i<strs.length ; i++){
            sb.append(strs[i]);
        }
        int len = sb.length();
        if(len==0) return "";
        int start = len % K==0 ? K : len%K;
        if(start==len) return sb.toString();
        sb.insert(start,"-");
        for(int i=sb.indexOf("-")+K+1 ; i<sb.length() ; i+=K+1){
            sb.insert(i,"-");
        }
        return sb.toString();
    }
}
