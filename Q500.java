package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 键盘行
 *
 * @author yx
 * @create 2019-06-01  18:24
 **/
public class Q500 {
    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<String>();
        for(String word : words){
            if(isSameLine(word)){
                list.add(word);
            }
        }

        return list.toArray(new String[0]);

    }

    private boolean isSameLine(String word){
        String[] rows = new String[]{"qwertyuiop","asdfghjkl","zxcvbnm"};
        String str = word.toLowerCase();
        for(String row : rows){
            if(isSameOne(row,str)){
                return true;
            }
        }

        return false;
    }

    private boolean isSameOne(String key,String S){
        for(int i = 0; i < S.length(); i++){
            if(key.indexOf(S.charAt(i)) == -1){
                return false;
            }
        }

        return true;
    }
}
