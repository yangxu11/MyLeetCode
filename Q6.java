package leetcode;
//Z字形变换
public class Q6 {
    //寻找规律
    //每行第一个数都为原坐标
    //第0行 第i(i>0)个数 原坐标 （2*i*numRows-2*k）
    //第1~numRows-2行 第i(i>0)个数  偶数原坐标(i*(2*numRows - 2)-row 奇数原坐标(i*(2*numRows - 2)+row
    //第numRows-1行 原坐标 i*(2*numRows - 2)- (numRows - 1)
    public String convert(String s, int numRows) {
        StringBuilder str = new StringBuilder();
        if( s.equals("")) return "";
        if(numRows == 1) return s;

        for(int row = 0 ; row < numRows ; row++) {
            if( row == 0) {
                int k = 1;
                str.append(s.charAt(row));
                while(true) {
                    if(k*(2*numRows - 2) < s.length()) {
                        str.append(s.charAt(k*2*numRows - 2*k));
                        k++;
                    } else {
                        break;
                    }
                }
            }

            if(row > 0 && row < numRows-1) {
                int k = 1;
                if( row < s.length() ) {
                    str.append(s.charAt(row));
                }
                while(true) {

                    if((k*(2*numRows - 2) - row) < s.length()) {
                        str.append(s.charAt(k*(2*numRows - 2)-row));
                    } else {
                        break;
                    }
                    if( (k*(2*numRows - 2) + row) < s.length()) {
                        str.append(s.charAt(k*(2*numRows - 2) +row));
                    } else {
                        break;
                    }
                    k++;
                }
            }

            if( row == numRows-1) {
                int k = 1;
                while(true) {
                    if((k*(2*numRows - 2) - (numRows - 1)) < s.length()) {
                        str.append(s.charAt(k*(2*numRows - 2)- (numRows - 1)));
                        k++;
                    } else {
                        break;
                    }
                }
            }
        }

        return str.toString();
    }
}
