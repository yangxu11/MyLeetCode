package leetcode;
//从英文字母中重建数字
public class Q423 {
    //23ms 73%
    // 统计字母出现的次数
    //找出有独特字母的数字，0，2，4，6，8，并把与其相关的字母剔除掉
    //然后再剩下的数字中找独特的字母
    public String originalDigits(String s) {
        String[] letterNum = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        int[] nums = new int[26];
        int[] result = new int[10];
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<s.length() ; i++){
            char c = s.charAt(i);
            int index= c-'a';
            nums[index]++;
        }
        //0的个数
        int num0 = nums['z'-'a'];
        result[0] = num0;
        for(int i=0 ; i<letterNum[0].length() ; i++){
            nums[letterNum[0].charAt(i)-'a'] -= num0;
        }

        //2的个数
        int num2 = nums['w'-'a'];
        result[2] = num2;
        for(int i=0 ; i<letterNum[2].length() ; i++){
            nums[letterNum[2].charAt(i)-'a'] -= num2;
        }
        //4的个数
        int num4 = nums['u'-'a'];
        result[4] = num4;
        for(int i=0 ; i<letterNum[4].length() ; i++){
            nums[letterNum[4].charAt(i)-'a'] -= num4;
        }
        //6的个数
        int num6 = nums['x'-'a'];
        result[6] = num6;
        for(int i=0 ; i<letterNum[6].length() ; i++){
            nums[letterNum[6].charAt(i)-'a'] -= num6;
        }
        //8的个数
        int num8 = nums['z'-'a'];
        result[8] = num8;
        for(int i=0 ; i<letterNum[8].length() ; i++){
            nums[letterNum[8].charAt(i)-'a'] -= num8;
        }
        //5
        int num5 = nums['f'-'a'];
        result[5] = num5;
        for(int i=0 ; i<letterNum[5].length() ; i++){
            nums[letterNum[5].charAt(i)-'a'] -= num5;
        }
        //7
        int num7 = nums['v'-'a'];
        result[7] = num7;
        for(int i=0 ; i<letterNum[7].length() ; i++){
            nums[letterNum[7].charAt(i)-'a'] -= num7;
        }
        //1
        int num1 = nums['o'-'a'];
        result[1] = num1;
        for(int i=0 ; i<letterNum[1].length() ; i++){
            nums[letterNum[1].charAt(i)-'a'] -= num1;
        }
        //3
        int num3 = nums['t'-'a'];
        result[3] = num3;
        for(int i=0 ; i<letterNum[3].length() ; i++){
            nums[letterNum[3].charAt(i)-'a'] -= num3;
        }
        //9
        int num9 = nums['i'-'a'];
        result[9] = num9;

        for(int i=0 ; i<result.length ; i++){
            for(int j=0 ; j<result[i] ; j++){
                sb.append(String.valueOf(i));
            }
        }
        return sb.toString();

    }
}
