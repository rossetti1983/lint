package dp.buttomUpDp;

/**
 * Created by zhizha on 10/10/17.
 */
public class PerfectSquares513 {

    public static void main(String[] arg){
        PerfectSquares513 perfectSquares513 = new PerfectSquares513();
        perfectSquares513.numSquares(100);
    }

    /*
    * @param n: a positive integer
    * @return: An integer
    */
    public int numSquares(int n) {

        // write your code here

        if(n == 0 ){
            return 0;
        }

        double d = Math.sqrt(n);
        int l = Double.valueOf(Math.floor(d)).intValue();

        int[][] dp = new int[l+1][n+1];

        for(int i = 0; i < l+1; i++){
            for(int j = 0; j < n+1; j++){
                if(i == 0){
                    dp[i][j] = Integer.MAX_VALUE;
                }

                if(j == 0){
                    dp[i][j] = 0;
                }

                if(i!=0 && j!=0){
                    int real = Double.valueOf(Math.pow(i,2)).intValue();
                    if(j%real == 0){
                        dp[i][j] = Math.min(j/real, dp[i-1][j]);
                    }else{
                        if(real>j){
                            dp[i][j] = dp[i-1][j];
                        }else{
                            int re = j%real;
                            dp[i][j] = Math.min((j/real)+dp[i][re], dp[i-1][j]);
                        }
                    }
                }
            }
        }

        return dp[l][n];

    }
}
