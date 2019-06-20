package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 函数的独占时间
 *
 * @author yx
 * @create 2019-06-20  19:37
 **/
public class Q636 {
    public static void main(String[] args) {
        String[] strs = {"0:start:0","1:start:5","2:start:6","3:start:9","4:start:11","5:start:12","6:start:14","7:start:15","1:start:24","1:end:29","7:end:34","6:end:37","5:end:39","4:end:40","3:end:45","0:start:49","0:end:54","5:start:55","5:end:59","4:start:63","4:end:66","2:start:69","2:end:70","2:start:74","6:start:78","0:start:79","0:end:80","6:end:85","1:start:89","1:end:93","2:end:96","2:end:100","1:end:102","2:start:105","2:end:109","0:end:114"};
       List<String> list = Arrays.asList(strs);
        Q636 q = new Q636();
        System.out.println(q.exclusiveTime(8,list));
    }
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] results =new int[n];
        Stack<String[]> stack=new Stack<>();
        for(String s:logs){
            String[] str=s.split(":");
            if(str[1].equals("start")){
                stack.push(new String[]{str[0],str[2],str[2]});
            }else{
                String[] pop = stack.pop();
                int dur=Integer.parseInt(str[2])-Integer.parseInt(pop[1])+1;
                results[Integer.parseInt(pop[0])]+=dur;
                if(stack.size()>0){
                    String[] peek =stack.peek();
                    peek[1]=Integer.parseInt(peek[1])+Integer.parseInt(str[2])-Integer.parseInt(pop[2])+1+"";
                }
            }
        }
        return results;
    }
}
