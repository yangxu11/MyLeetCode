package leetcode;
//报数
public class Q38 {
    //注意count超过10，不能使用翻转reverse
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        n--;
        while(n>0){
            StringBuilder tmp = new StringBuilder();
            tmp.append(sb.charAt(sb.length()-1));
            int count=1;
            for(int i=sb.length()-2 ; i>=0 ; i--){
                if(sb.charAt(i) != sb.charAt(i+1)){
                    tmp.insert(0,count);
                    tmp.insert(0,sb.charAt(i));
                    count = 1;
                } else {
                    count++;
                }
            }
            tmp.insert(0,count);
            sb = tmp;
            n--;
        }
        return sb.toString();
    }
}
