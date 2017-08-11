package array;

/**
 * Created by zhizha on 8/7/17.
 */
public class MaxSubArray41 {

    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     *
     * Given an array of integers, find a contiguous subarray which has the largest sum.
     * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
        the contiguous subarray [4,−1,2,1] has the largest sum = 6.
     */
    public int maxSubArray(int[] nums) {

        int ans = 0, sum = 0;
        // write your code
        if(nums == null || nums.length == 0){
            return 0;
        }else if(nums.length == 1){
            return nums[0];
        }else{
            boolean allNeg = true;
            int maxNegative = Integer.MIN_VALUE;
            for(int i = 0 ; i < nums.length ; i++){
                if(sum + nums[i] > 0){
                    allNeg = false;
                    sum = sum + nums[i];
                }else{
                    maxNegative = Math.max(nums[i], maxNegative);
                    sum = 0;
                }
                ans = Math.max(ans, sum);
            }
            if(allNeg){
                return maxNegative;
            }
        }

        return ans;

    }
}
