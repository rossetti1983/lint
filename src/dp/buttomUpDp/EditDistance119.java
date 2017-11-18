package dp.buttomUpDp;

/**
 * Created by zhizha on 9/3/17.
 */
public class EditDistance119 {

    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     *
     * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
     * (each operation is counted as 1 step.)

    You have the following 3 operations permitted on a word:

    Insert a character
    Delete a character
    Replace a character
     */
    public int minDistance(String word1, String word2) {
        if(word1 == null && word2 != null){
            return word2.length();
        }
        if(word2 == null && word1 != null ){
            return word1.length();
        }
        if(word1 == null && word2 == null){
            return 0;
        }

        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i = 0; i< word2.length()+1; i++){
            dp[0][i] = i;
        }
        for(int i = 0; i< word1.length()+1; i++){
            dp[i][0] = i;
        }

        for(int i = 1; i < word1.length()+1; i++){
            for(int j = 1; j < word2.length()+1; j++){
                if(word1.charAt(j-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j], dp[i][j-1]));
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
