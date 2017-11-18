package dp.buttomUpDp;

/**
 * Created by zhizha on 9/4/17.
 * Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.

 Have you met this question in a real interview? Yes
 Example
 For s1 = "aabcc", s2 = "dbbca"

 When s3 = "aadbbcbcac", return true.
 When s3 = "aadbbbaccc", return false.
 */
public class InterleavingString29 {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {

        // write your code here
        if(s1==null || s1.trim().equals("")){
            return (s2.equals(s3));
        }
        if(s2==null || s2.trim().equals("")){
            return s1.equals(s3);
        }

        if(s1.length()+s2.length()>s3.length()){
            return false;
        }

        boolean[][] dp = new boolean[s1.length()+1][s2.length()];
        dp[0][0] = true;
        for(int i = 1; i <= s1.length(); i++){
            dp[0][i] = s1.substring(1,i+1).equals(s3.substring(1,i+1));
        }

        for(int j = 1; j <= s2.length(); j++){
            dp[j][0] = s2.substring(1,j+1).equals(s3.substring(1,j+1));
        }

        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                if(dp[i-1][j]){
                    dp[i][j] = s1.charAt(i) == s3.charAt(i+j);
                }

                if(!dp[i][j] && dp[i][j-1]){
                    dp[i][j] = s2.charAt(j) == s3.charAt(i+j);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
