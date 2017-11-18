package dp.buttomUpDp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhizha on 9/4/17.
 */
public class WordBreakII582 {
    public static void main(String[] arg){
        WordBreakII582 wordBreak = new WordBreakII582();
        Set<String> set = new HashSet();
        set.add("cat");
        set.add("cats");
        set.add("and");
        set.add("sand");
        set.add("dog");
        wordBreak.wordBreak("catsanddog",set);
    }
    /**
     * @param s a string
     * @param wordDict a set of words
     */
    public List<String> wordBreak(String s, Set<String> dict) {
        // Write your code here
        if(s==null || s.equals("")){
            List<String> r = new ArrayList<>();
            r.add("");
            return r;
        }
        // write your code here

        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()] = true;
        int max_word_len = 0;
        for (String word : dict) {
            max_word_len = Math.max(max_word_len, word.length());
        }
        outer:
        for(int i = s.length()-1; i >= 0; i--){
            int start = s.length() - 1;
            if(s.length() - i > max_word_len){
                start = i + max_word_len;
            }
            inner:
            for(int j = start ; j >= i; j--){
                boolean pre = dict.contains(s.substring(i, j+1));
                if(!pre){
                    continue inner;
                }
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

        List<String> res = new ArrayList<>();
        helper(dp, 0, max_word_len, s, dict, "", res);

        return res;
    }

    private void helper(boolean[] dp, int start, int max, String s, Set<String> dict, String ss, List<String> res) {
        int end = s.length();
        if(s.length() - 1 - start > max){
            end = start + max;
        }
        String st = ss;
        for(int i = start+1; i <= end; i++){
            ss = st;
            if(dp[i]){
            if(dict.contains(s.substring(start, i))){
                ss = ss + " " + s.substring(start,i);
                if(i == s.length()){
                    res.add(ss.trim());
                }else{
                helper(dp, i, max, s, dict, ss, res);
                }
            }
            }
        }

    }
}
