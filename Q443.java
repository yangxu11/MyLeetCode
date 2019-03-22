package leetcode;
//压缩字符串
public class Q443 {
    //注意，局部连续压缩不是整体压缩，长度为1不压缩
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char prev = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == prev) {
                count++;
            } else {
                if (count > 1) {
                    sb.append(prev);
                    sb.append(count);
                } else if (count == 1) {
                    sb.append(prev);
                }
                prev = chars[i];
                count = 1;
            }
        }
        sb.append(prev);
        if (count > 1) {
            sb.append(count);
        }
        int i = 0;
        for (char c : sb.toString().toCharArray()) {
            chars[i++] = c;
        }
        return sb.length();

    }
}
