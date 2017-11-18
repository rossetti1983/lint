package dp.buttomUpDp;

/**
 * Created by zhizha on 10/14/17.
 */
public class DistinctSubsequences118 {

    public static void main(String[] arg){
        DistinctSubsequences118 distinctSubsequences118 = new DistinctSubsequences118();
        distinctSubsequences118.numDistinct("rabbbit","rabbit");
    }
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        if(S==null){
            return 0;
        }

        if(T == null){
            return 1;
        }

        if(T.length() > S.length()){
            return 0;
        }

        int[][] dp = new int[T.length()+1][S.length()+1];
        for(int i = 0; i < S.length() + 1; i ++){
            dp[0][i] = 1;
        }
        for(int i = 1; i < T.length() + 1; i ++){
            dp[i][0] = 0;
        }

        for(int i = 1 ; i < T.length()+1; i ++){
            for(int j = i; j < S.length()+1; j++){
                if(T.charAt(i-1) == S.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[T.length()][S.length()];
    }
}
