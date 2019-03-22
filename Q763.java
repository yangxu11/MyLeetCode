package leetcode;

import java.util.ArrayList;
import java.util.List;
//划分字母区间
public class Q763 {
    //5%  使用list<list> 来存储区间所有字母，如果新来的字母被前面的区间包含，则合并该区间之后的所有区间
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();

        List<List<Character>> lists = new ArrayList<>();

        for(int i=0 ; i<S.length() ; i++) {
            char c = S.charAt(i);
            int flag = 0;
            for(int j=0 ; j<lists.size() ; j++) {
                if(lists.get(j).contains(c)){
                    flag = 1;
                    List<Character> list = lists.get(j);
                    for(int k=j+1 ; k<lists.size() ;) {
                        list.addAll(lists.get(k));
                        lists.remove(k);
                    }
                    list.add(c);
                    break;
                }
            }
            if(flag==0) {
                List<Character> list = new ArrayList<>();
                list.add(c);
                lists.add(list);
            }
        }
        for(List list : lists){
            result.add(list.size());
        }
        return result;
    }
//双指针 55%  用一个数组存储每个字母出现的最后的位置，如果遍历当前的字母的最后位置=当前位置，则该为一个区间
    public List<Integer> partitionLabels2(String S) {
        List<Integer> result = new ArrayList<>();

        int[] last = new int[26];

        for(int i=0 ; i<S.length() ; i++) {
            last[(int)(S.charAt(i)-'a')] = i;
        }
        int start=-1;
        int end = -1;
        for(int i=0 ; i<S.length() ; i++) {
            if(start==-1) {
                start = i;
            }
            end = Math.max(end,last[(int)(S.charAt(i)-'a')]);
            if(i==end){
                result.add(end-start+1);
                start = -1;
            }
        }
        return result;
    }
}
