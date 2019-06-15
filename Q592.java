package leetcode;

/**
 * 分数加减运算
 *
 * @author yx
 * @create 2019-06-15  20:37
 **/
public class Q592 {
    public String fractionAddition(String expression) {
        String res = "";
        if(expression.startsWith("-")){
            if(expression.length() > 4 && expression.charAt(4)!='+' && expression.charAt(4)!='-' ){
                res = expression.substring(0,5);
            } else{
                res = expression.substring(0,4);
            }

        } else{
            if(expression.length() > 3 && expression.charAt(3)!='+' && expression.charAt(3)!='-' ){
                res = expression.substring(0,4);
            } else{
                res = expression.substring(0,3);
            }
        }
        int up,down;
        String[] init = res.split("/");
        up = Integer.parseInt(init[0]);
        down = Integer.parseInt(init[1]);
        int[] ans = {up,down};
        for(int i=res.length() ; i<expression.length() ; i+=4){
            int sign = 1;
            if(expression.charAt(i)=='-'){
                sign = -1;
            }
            String num = expression.substring(i+1,i+4);
            if(i+4 < expression.length()){
                if(expression.charAt(i+4)!='+' && expression.charAt(i+4)!='-'){
                    num = expression.substring(i+1,i+5);
                    i++;
                }
            }
            String[] nums = num.split("/");
            int up1 = Integer.parseInt(nums[0]);
            int down1 = Integer.parseInt(nums[1]);
            if(sign==-1){
                up1 *= -1;
            }
            ans = getSum(ans[0],ans[1],up1,down1);
        }
        int common = getCommon(Math.abs(ans[0]),Math.abs(ans[1]));
        ans[0] /= common;
        ans[1] /= common;

        return ans[0] + "/" + ans[1];
    }

    public int[] getSum(int up1,int down1,int up2,int down2){
        int common = getCommon(down1,down2);
        int x = down1/common;
        int down = down2*x;
        int up = (down/down1)*up1 + (down/down2)*up2;
        return new int[]{up,down};
    }

    public int getCommon(int a,int b){
        while(b!=0){
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}
