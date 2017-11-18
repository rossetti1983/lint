package dp.buttomUpDp;

/**
 * Created by zhizha on 10/1/17.
 * Given two strings, find the longest common substring.

 Return the length of it.

 Notice

 The characters in substring should occur continuously in original string. This is different with subsequence.

 Have you met this question in a real interview? Yes
 Example
 Given A = "ABCD", B = "CBCE", return 2.

 Challenge
 O(n x m) time and memory.


 */
public class LongestCommonSubstring79 {

    /*
 * @param A: A string
 * @param B: A string
 * @return: the length of the longest common substring.
 */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if(A == null || A.trim().equals("")){
            return 0;
        }

        if(B == null || B.trim().equals("")){
            return 0;
        }

        int[][] dp = new int[A.length()+1][B.length()+1];
        int max = 0;
        for(int i = 1; i<= A.length(); i++){
            for(int j = 1; j <= B.length(); j++){
                if(A.charAt(i-1)==B.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if(dp[i][j]>max){
                        max = dp[i][j];
                    }
                }
            }
        }

        return max;
    }
}
