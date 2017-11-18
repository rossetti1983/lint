package dp.buttomUpDp;

/**
 * Created by zhizha on 10/27/17.
 */
public class MaximumSubarrayIII43 {

    public static void main(String[] arg){
        MaximumSubarrayIII43 maximumSubarrayIII43 = new MaximumSubarrayIII43();
        maximumSubarrayIII43.maxSubArray(new int[]{-1,-2,-3,-100,-1,-50}, 2);
    }
    /*
 * @param nums: A list of integers
 * @param k: An integer denote to find k non-overlapping subarrays
 * @return: An integer denote the sum of max k non-overlapping subarrays
 */
    public int maxSubArray(int[] nums, int k) {
        // write your code here
        if(nums==null||nums.length==0){
            return 0;
        }

        if(k == 0){
            return 0;
        }

        int[][] local = new int[nums.length+1][k+1];
        int[][] global = new int[nums.length+1][k+1];

        for(int j = 1; j <= k; j++){
            for(int i = j; i <= nums.length; i++){
                if(i==j){
                    local[i][j] = global[i - 1][j - 1] + nums[i - 1];
                }else {
                    local[i][j] = Math.max(local[i - 1][j] + nums[i - 1], global[i - 1][j - 1] + nums[i - 1]);
                }
                if(i-1 == j-1){
                    global[i][j] = local[i][j];
                }else {
                    global[i][j] = Math.max(local[i][j], global[i - 1][j]);
                }
            }
        }
        return global[nums.length][k];
    }
}
