package dp.buttomUpDp;

/**
 * Created by zhizha on 9/4/17.
 * Given two strings, find the longest common subsequence (LCS).

 Your code should return the length of LCS.

 Have you met this question in a real interview? Yes
 Clarification
 What's the definition of Longest Common Subsequence?

 https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 http://baike.baidu.com/view/2020307.htm
 Example
 For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.

 For "ABCD" and "EACB", the LCS is "AC", return 2.


 */
public class LongestCommonSubsequence77 {

    /**
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if(A==null || A.trim().equals("")){
            return 0;
        }

        if(B==null || B.trim().equals("")){
            return 0;
        }

        int[][] dp = new int[A.length()+1][B.length()+1];
        for(int i = 1; i <= A.length(); i++){
            for(int j = 1; j <= B.length(); j++){
                if(A.charAt(i) == B.charAt(j)){
                    dp[i][j] = Math.max(dp[i-1][j-1]+1, Math.max(dp[i-1][j],dp[i][j-1]));
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[A.length()][B.length()];
    }
}
