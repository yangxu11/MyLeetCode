package leetcode;

/**
 * 字符串的排列
 *
 * @author yx
 * @create 2019-06-14  20:11
 **/
public class Q567 {
    //滑动窗口法，记录s1长度的子串内各个字符出现的次数，如果相同，则return true
    public boolean checkInclusion1(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] rec1 = new int[26];
        int[] rec2 = new int[26];

        for(int i=0 ; i<s1.length() ; i++){
            rec1[s1.charAt(i)-'a'] += 1;
            rec2[s2.charAt(i)-'a'] += 1;
        }
        if(check(rec1,rec2)) return true;

        for(int i=s1.length() ; i<s2.length() ; i++){
            rec2[s2.charAt(i)-'a'] +=1;
            rec2[s2.charAt(i-s1.length())-'a'] -= 1;
            if(check(rec1,rec2)) return true;
        }

        return false;
    }

    private boolean check(int[] rec1,int[] rec2){
        for(int i=0 ; i<26 ; i++){
            if(rec1[i]!=rec2[i]){
                return false;
            }
        }
        return true;
    }


    //回溯超时
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        char[] cs = s1.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[cs.length];
        return dfs(cs,s2,sb,visited);
    }

    public boolean dfs(char[] cs,String s2,StringBuilder sb,boolean[] visited){
        if(sb.length()== cs.length){
            if(s2.contains(sb.toString())){
                return true;
            } else{
                return false;
            }
        }
        boolean b = false;
        for(int i=0 ; i<cs.length ; i++){
            if(!visited[i]){
                sb.append(cs[i]);
                visited[i] = true;
                b = b || dfs(cs,s2,sb,visited);
                sb.deleteCharAt(sb.length()-1);
                visited[i]=false;
            }
        }
        return b;

    }
}
