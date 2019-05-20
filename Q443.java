package leetcode;
//压缩字符串
public class Q443 {
    public int compress(char[] chars) {
        int slow = 0;
        int fast = 0;
        while(fast<chars.length){
            chars[slow] = chars[fast];
            int count=1;
            while(fast<chars.length-1 && chars[fast]==chars[fast+1]){
                count++;
                ++fast;
            }
            if(count==1){
                ++fast;
                ++slow;
                continue;
            }
            char[] cs = String.valueOf(count).toCharArray();
            for(char c : cs){
                chars[++slow] = c;
            }
            ++fast;
            ++slow;
        }

        return slow;
    }
}
