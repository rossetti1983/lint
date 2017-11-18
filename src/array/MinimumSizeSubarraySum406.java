package array;

/**
 * Created by zhizha on 8/28/17.
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return -1 instead.

 Have you met this question in a real interview? Yes
 Example
 Given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under the problem constraint.


 */
public class MinimumSizeSubarraySum406 {

    public static void main(String[] arg){
        MinimumSizeSubarraySum406 minimumSizeSubarraySum406 = new MinimumSizeSubarraySum406();
        minimumSizeSubarraySum406.minimumSize(new int[]{2,3,1,2,4,3}, 7);
    }
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        int start = 0;

        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
            if(sum>=s){
                if(min > (i-start+1)){
                    min = i - start + 1;
                }
                    while(sum >= s && start < i){
                        sum = sum - nums[start++];
                        if(sum>=s){
                            if(min > (i-start+1)){
                                min = i - start + 1;
                            }
                        }
                    }

            }
        }
        return min;
    }
}
