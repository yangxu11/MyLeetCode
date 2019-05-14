package leetcode;
//字符串解码
public class Q394 {
    public String decodeString(String s) {
        if(s.length() ==0) return "";

        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i<s.length()){
            if((s.charAt(i)>='a' && s.charAt(i)<='z') || (s.charAt(i)>='A' && s.charAt(i)<='Z')){
                sb.append(String.valueOf(s.charAt(i)));
            } else if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                int num=0;
                while(s.charAt(i)>='0'&& s.charAt(i)<='9'){
                    num = num*10 + s.charAt(i)-'0';
                    ++i;
                }
                int index = findIndex(i,s);
                String str = decodeString(s.substring(i+1,index));
                for(int j=0 ; j<num ; j++){
                    sb.append(str);
                }
                i=index;
            }
            ++i;
        }
        return sb.toString();
    }
    private int findIndex(int start,String s){
        int count =0;
        for(int i=start ; i<s.length() ; i++){
            if(s.charAt(i)=='['){
                ++count;
            } else if(s.charAt(i)==']'){
                --count;
            }
            if(count==0){
                return i;
            }
        }
        return -1;
    }
}
