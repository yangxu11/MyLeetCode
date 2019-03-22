package leetcode;
//字符串解码
public class Q394 {
    public static void main(String[] args) {
        Q394 q = new Q394();
        System.out.println(q.decodeString("3[a]2[bc]"));
    }
    public String decodeString(String s) {
        if(s.length()==0) return "";
        String str = "";
        for(int i=0 ; i <s.length() ; i++) {
            if((s.charAt(i)>='a'&& s.charAt(i)<='z') || (s.charAt(i)>='A'&& s.charAt(i)<='Z')){
                str = str + String.valueOf(s.charAt(i));
            } else if(s.charAt(i)>='0'&& s.charAt(i)<='9'){
                int num=0;
                while(s.charAt(i)>='0'&& s.charAt(i)<='9') {
                    num = num*10 + (s.charAt(i)-'0');
                    i++;

                }
                int index = findIndex(s,i);
                String sub = s.substring(i+1,index);
                String inner = decodeString(sub);
                for(int j=0 ; j<num ;j++){
                    str += inner;
                }
                i=index;
            }
        }

        return str;
    }
    public int findIndex(String s,int start) {
        int count=0;
        for(int i=start ; i<s.length();i++) {
            if(s.charAt(i)=='[') {
                count++;
            }
            if(s.charAt(i)==']') {
                count--;
            }
            if(count==0) {
                return i;
            }
        }
        return -1;
    }
}
