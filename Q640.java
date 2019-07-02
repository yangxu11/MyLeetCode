package leetcode;

/**
 * 解方程
 *
 * @author yx
 * @create 2019-07-02  17:13
 **/
public class Q640 {

    public String solveEquation(String equation) {
        String[] eq = equation.split("=");
        String left = eq[0];
        String right = eq[1];
        int[] leftNum = getNum(left);
        int[] rightNum = getNum(right);
        int x = leftNum[0] - rightNum[0];
        int num = rightNum[1] - leftNum[1];
        if(x==0 && num!=0){
            return "No solution";
        } else if(x==0 && num==0){
            return "Infinite solutions";
        } else{
            return "x="+num/x;
        }
    }
    int[] getNum(String str){
        int x = 0;
        int num = 0;
        if(str.startsWith("-")){
            str = "0" + str;
        } else if(str.startsWith("+")){
            str = str.substring(1);
        }
        String[] strs = str.split("\\+");
        for(String s : strs){
            String[] ss = s.split("-");
            for(int i=0 ; i<ss.length; i++){
                String s1 = ss[i];
                if(i==0){
                    if(s1.contains("x")){
                        if(s1.length()==1){
                            x += 1;
                        } else{
                            x += Integer.parseInt(s1.substring(0,s1.length()-1));
                        }

                    } else{
                        num += Integer.parseInt(s1);
                    }
                } else{
                    if(s1.contains("x")){
                        if(s1.length()==1){
                            x -= 1;
                        } else{
                            x -= Integer.parseInt(s1.substring(0,s1.length()-1));
                        }

                    } else{
                        num -= Integer.parseInt(s1);
                    }
                }
            }
        }
        return new int[]{x,num};
    }

}
