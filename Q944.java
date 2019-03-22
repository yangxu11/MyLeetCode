package leetcode;
//删列造序
public class Q944 {
    public int minDeletionSize(String[] A) {
        int count=0;
        for(int j=0 ; j<A[0].length() ; j++){
            for(int i=1 ; i<A.length ; i++){
                String s1 = A[i];
                String s2 = A[i-1];
                if(s1.charAt(j) < s2.charAt(j)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
