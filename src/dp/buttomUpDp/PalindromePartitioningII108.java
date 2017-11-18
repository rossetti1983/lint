package dp.buttomUpDp;

import LinkedList.PartitionList96;

import java.util.HashMap;

/**
 * Created by zhizha on 9/6/17.
 * Given a string s, cut s into some substrings such that every substring is a palindrome.

 Return the minimum cuts needed for a palindrome partitioning of s.

 Have you met this question in a real interview? Yes
 Example
 Given s = "aab",

 Return 1 since the palindrome partitioning ["aa", "b"] could be produced using 1 cut.


 */
public class PalindromePartitioningII108 {

    public static void main(String[] arg){
        PalindromePartitioningII108 palindromePartitioningII108 = new PalindromePartitioningII108();
        palindromePartitioningII108.minCut("aaabaa");
    }
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        int len = s.length();
        int[][] dp = new int[len+1][len];
        // write your code here
        for(int i = len-1; i >= 0; i--){
            for(int j = i; j < len; j++){
                int minC = Integer.MAX_VALUE;
                for(int k = i; k <= j ; k++){
                    String ss = s.substring(i, k+1);
                    if(isPalinDrome(ss)){
                        int tmp = (k+1>j?-1:dp[k+1][j]) + 1;
                        if(minC>tmp){
                            minC = tmp;
                            dp[i][j] = minC;
                        }
                    }else{
                        continue;
                    }
                }
            }
        }
        return dp[0][len-1];
    }

    HashMap<String, Boolean> cache = new HashMap<>();
    private boolean isPalinDrome(String ss) {
        if(cache.containsKey(ss)){
            return cache.get(ss);
        }
        if(ss.length()==1){
            cache.put(ss, true);
            return true;
        }
        int start = 0;
        int end = ss.length()-1;
        while(start<end){
            if(ss.charAt(start++) == ss.charAt(end--)){
                continue;
            }else{
                cache.put(ss, false);
                return false;
            }
        }
        cache.put(ss, true);
        return true;
    }
}
