package leetcode;
//寻找比目标字母大的最小字母
public class Q744 {
    //60%  二分法  需要先排除循环的情况
    public char nextGreatestLetter(char[] letters, char target) {

        int start=0;
        int end = letters.length-1;

        if(target>=letters[end]){//排除循环的情况
            return letters[0];
        }

        while(start<end){
            int mid = start + (end-start)/2;

            if(letters[mid]>target){
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return letters[start];

    }
}
