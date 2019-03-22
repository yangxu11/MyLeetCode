package leetcode;
//检验大写字母
public class Q520 {
    //33ms 60%
    public boolean detectCapitalUse(String word) {
        if(word.length()==1) return true;

        if(isLower(word.charAt(0))){
            for(int i=1 ; i<word.length();i++){
                if(!isLower(word.charAt(i)))
                    return false;
            }
        } else {
            if(isLower(word.charAt(1))){
                for(int i=1 ; i<word.length();i++){
                    if(!isLower(word.charAt(i)))
                        return false;
                }
            } else {
                for(int i=1 ; i<word.length();i++){
                    if(isLower(word.charAt(i)))
                        return false;
                }
            }
        }
        return true;

    }

    public boolean isLower(char c){
        return c>='a' && c<='z';
    }
}
