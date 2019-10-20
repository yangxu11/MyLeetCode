package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 删除子文件夹
 *
 * @author yx
 * @create 2019-10-20  11:11
 **/
public class Q5231 {
    public static void main(String[] args) {
        String[] f= {"/a","/a/b/c","/a/b/d"};
        Q5231 q = new Q5231();
        System.out.println(q.removeSubfolders(f));
    }
    public List<String> removeSubfolders(String[] folder) {
        Comparator<String> comp = new Comparator<String>(){
            public int compare(String s1,String s2){
                return s1.length()-s2.length();
            }
        };

        Arrays.sort(folder,comp);

        List<String> set = new ArrayList<>();

        for(String s : folder){
            boolean flag = true;
            String[] ss = s.split("/");
            StringBuilder sb = new StringBuilder();
            for(int i=0 ; i<ss.length ; i++){
                String str = ss[i];
                sb.append("/"+str);
                if(set.contains(sb.toString())){
                    flag = false;
                    break;
                }
            }
            if(flag){
                set.add(s);
            }
        }
        return set;
    }
}
