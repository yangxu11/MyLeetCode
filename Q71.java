package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q71 {
    public static void main(String[] args) {
        Q71 q = new Q71();
        System.out.println(q.simplifyPath("/home/"));
    }
    public String simplifyPath(String path) {
        if(path.length()==0) return "";

        String[] strs = path.split("/");
        StringBuilder sb = new StringBuilder();
        List<String> str = new ArrayList<>();
        for(int i=0 ; i<strs.length ; i++) {
            String s = strs[i];
            if(s.equals("")) continue;
            if(s.contains("..")) {
                str.clear();
            }
            str.add(s);
        }
        for(String s : str) {
            sb.append("/"+s);
        }
        return sb.toString();
    }
}
