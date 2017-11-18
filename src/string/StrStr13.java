package string;

/**
 * Created by zhizha on 10/14/17.
 */
public class StrStr13 {

    public static void main(String[] arg){
        StrStr13 strStr13 = new StrStr13();
        strStr13.strStr("lintcode", "lintcode");
    }

    public int strStr(String source, String target) {
        // write your code here
        if((source == null || source.length()==0) && (target == null || target.length() == 0)) {
            return 0;
        }

        if((target == null || target.length() == 0)) {
            return 0;
        }

        if((source == null || source.length()==0)) {
            return -1;
        }

        int slen = source.length();
        int tlen = target.length();
        out:
        for(int i = 0; i < slen; i++){
            if(slen - i < tlen){
                return -1;
            }
            for(int j = 0; j < tlen; j++){
                if(source.charAt(i+j) != target.charAt(j)){
                    continue out;
                }
            }
            return i;
        }
        return -1;
    }
}
