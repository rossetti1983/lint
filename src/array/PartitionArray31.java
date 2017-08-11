package array;

/**
 * Created by zhizha on 8/7/17.
 */
public class PartitionArray31 {

    /**
     * Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:

     All elements < k are moved to the left
     All elements >= k are moved to the right
     Return the partitioning index, i.e the first index i nums[i] >= k.

     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     *Notice: you should do really partition in array nums instead of just counting the numbers of integers smaller than k.
    If all elements in nums are smaller than k, then return nums.length
     */
    public int partitionArray(int[] nums, int k) {

        if(nums == null || nums.length == 0){
            return 0;
        }
        //write your code here
        int startIndex = 0;
        int tailIndex = nums.length -1;

        while(startIndex < tailIndex){
            while(startIndex <= tailIndex && nums[startIndex] < k){
                startIndex++;
            }
            while(startIndex <= tailIndex && nums[tailIndex] >= k){
                tailIndex --;
            }
            if(startIndex <= tailIndex){
                int tmp = nums[startIndex];
                nums[startIndex] = nums[tailIndex];
                nums[tailIndex] = tmp;
                startIndex++;
                tailIndex--;
            }
        }

        return startIndex;
    }
}
