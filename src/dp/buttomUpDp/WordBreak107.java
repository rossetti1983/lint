package dp.buttomUpDp;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhizha on 9/4/17.
 */
public class WordBreak107 {

    public static void main(String[] arg){
        WordBreak107 wordBreak = new WordBreak107();
        Set<String> set = new HashSet();
        set.add("leet");
        set.add("code");
        wordBreak.wordBreak("leetcode",set);
    }

    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if(s==null || s.equals("")){
            return true;
        }
        boolean[] dp = new boolean[s.length()];
        outer:
        for(int i = s.length()-1; i >= 0; i--){
            for(int j = s.length() -1 ; j >= i; j--){
                boolean pre = dict.contains(s.substring(i, j+1));
                boolean suffix = true;
                if(j+1<=s.length()-1){
                    suffix = dp[j+1];
                }
                dp[i] = pre && suffix;
                if(dp[i]){
                    continue outer;
                }
            }
        }

        return dp[0];
    }
}
