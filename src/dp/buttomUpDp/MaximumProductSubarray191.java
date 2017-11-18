package dp.buttomUpDp;

/**
 * Created by zhizha on 10/10/17.
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

 Have you met this question in a real interview? Yes
 Example
 For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaximumProductSubarray191 {

    /*
 * @param nums: An array of integers
 * @return: An integer
 */
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        // write your code here
        int[] dp = new int[nums.length+1];
        int[] dp2 = new int[nums.length+1];
        dp[0] = 1;
        int max1 = Integer.MIN_VALUE;
        for(int i = 1; i <=nums.length; i++){
            dp[i] = Math.max(dp[i-1]*nums[i-1], nums[i-1]);
            if(dp[i] > max1){
                max1 = dp[i];
            }
        }

        dp2[0] = 1;
        int max2 = Integer.MIN_VALUE;
        for(int i = 1; i <=nums.length; i++){
            dp2[i] = dp[i-1]*nums[i-1];
            if(dp2[i] > max2){
                max2 = dp2[i];
            }
        }

        return Math.max(max1,max2);
    }
}
