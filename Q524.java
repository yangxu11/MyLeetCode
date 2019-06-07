package leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q524 {

    //先对数组排序，先长度，后字典（ a.compareTo(b) ）
    //遍历判断子序列
    public String findLongestWord(String s, List<String> d) {
        Comparator<String> comp = new Comparator<String>(){
            public int compare(String a,String b){
                return a.length()<b.length() ? 1 : (a.length()==b.length() ? a.compareTo(b): -1);
            }
        };
        Collections.sort(d,comp);
        for(String str : d){
            if(isSub(s,str)){
                return str;
            }
        }

        return "";
    }

    private boolean isSub(String str,String s){
        int index = 0;
        for(int i=0 ; i<s.length() ; i++){
            char c = s.charAt(i);
            index = str.indexOf(c,index);
            if(index==-1){
                return false;
            }
            ++index;
        }
        return true;
    }

}
