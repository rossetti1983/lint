package dp.buttomUpDp;

/**
 * Created by zhizha on 10/9/17.
 * Clarification
 What's the definition of longest increasing subsequence?

 The longest increasing subsequence problem is to find a subsequence of a given sequence in which the subsequence's elements are in sorted order, lowest to highest, and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.

 https://en.wikipedia.org/wiki/Longest_increasing_subsequence

 Example
 For [5, 4, 1, 2, 3], the LIS is [1, 2, 3], return 3
 For [4, 2, 4, 5, 3, 7], the LIS is [2, 4, 5, 7], return 4
 */
public class LongestIncreasingSubsequence76 {

    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {

        // write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length+1];

        for(int i = 1; i <= nums.length; i++){
            int max = 0;
            for(int j = i - 1; j >= 1; j--){
                if(nums[i] > nums[j] && dp[j] > max){
                    max = dp[j];
                }
                continue;
            }
            dp[i] = max+1;
        }

        int max = 0;
        for(int i = 1; i <= nums.length; i++){
            if(dp[i] > max){
                max = dp[i];
            }
        }

        return max;

    }
}
