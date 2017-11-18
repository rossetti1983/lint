package dp.buttomUpDp;

/**
 * Created by zhizha on 10/2/17.
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

 Have you met this question in a real interview? Yes
 Example
 For example, given the following matrix:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0
 Return 4.
 */
public class MaximalSquare436 {

    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        if(matrix == null || matrix[0].length==0){
            return 0;
        }
        // write your code here
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0 ; j < matrix[0].length; j++){
                if(matrix[i][j] == 1){
                    if(i == 0 || j == 0){
                       dp[i][j] = 1;
                    }else{
                        if(matrix[i-1][j-1] == matrix[i-1][j] && matrix[i-1][j] == matrix[i][j-1]
                                &&(dp[i-1][j-1] == dp[i-1][j] && dp[i-1][j] == dp[i][j-1])){
                            int tmp = Double.valueOf(Math.sqrt(Double.valueOf(String.valueOf(dp[i-1][j-1])))).intValue();
                            dp[i][j] = (1+tmp)*(1+tmp);
                        }else{
                            dp[i][j] = Math.max(dp[i-1][j-1], Math.max(dp[i][j-1], dp[i-1][j]));
                        }
                    }

                    if(dp[i][j]>max){
                        max = dp[i][j];
                    }
                }
            }
        }

        return max;
    }
}
