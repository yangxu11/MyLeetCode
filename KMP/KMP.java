package leetcode.KMP;

/**
 * KMP算法实现
 *
 * @author yx
 * @create 2019-11-02  11:29
 **/
public class KMP {
    public static void main(String[] args) {
        KMP kmp = new KMP();
        String s = "ABACDABABC";
        int[] next = kmp.getNext(s);
        for(int i : next){
            System.out.print(i+" ");
        }
        String p = "ACD";
        System.out.println(kmp.find(s,p));
    }

    public int[] getNext(String s){
        int len = s.length();
        int[] next = new int[len];
        next[0] = -1;
        int k = -1;
        int j = 1;

        while(j<len-1){
            if(k==-1 || s.charAt(j)==s.charAt(k)){
                next[++j] = ++k;
            } else{
                k = next[k];
            }
        }

        return next;
    }

    public int find(String str,String p){
        int len1 = str.length();
        int len2 = p.length();
        int[] next = getNext(p);
        int i=0,j=0;


        while(i<len1 && j<len2){
            if(j==-1 || str.charAt(i) == p.charAt(j)){
                ++i;
                ++j;
            } else{
                j = next[j];
            }
        }
        if(j==len2){
            return i-j;
        } else{
            return -1;
        }
    }

}
