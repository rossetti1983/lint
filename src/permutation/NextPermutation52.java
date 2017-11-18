package permutation;

/**
 * Created by zhizha on 8/29/17.
 * Given a list of integers, which denote a permutation.

 Find the next permutation in ascending order.

 Notice

 The list may contains duplicate integers.

 Have you met this question in a real interview? Yes
 Example
 For [1,3,2,3], the next permutation is [1,3,3,2]

 For [4,3,2,1], the next permutation is [1,2,3,4]
 */
public class NextPermutation52 {

    public static void main(String[] arg){
        NextPermutation52 nextPermutation52 = new NextPermutation52();
        nextPermutation52.nextPermutation(new int[]{4,3,2,1});
    }
    /*
     * @param nums: A list of integers
     * @return: A list of integers
     */
    public int[] nextPermutation(int[] nums) {

        if(nums == null || nums.length < 2 ){
            return nums;
        }
        int len = nums.length;
        if(nums[len-1] > nums[len-2]){
            int tmp = nums[len-1];
            nums[len-1] = nums[len-2];
            nums[len-2] = tmp;
            return nums;
        }

        // write your code here
        for(int i = nums.length-1; i>=0; i--){
            if(i == nums.length -1){
                continue;
            }else{
                if(nums[i] < nums[i+1]){
                    return nextPermutation(nums,i);
                }
            }
        }
        return nextPermutation(nums,-1);
    }

    private int[] nextPermutation(int[] nums, int i) {
        int pre = -1;
        if(i == -1){
            i = 0;
            pre = Integer.MIN_VALUE;
        }else{
            pre = nums[i];
        }


        while(i<nums.length){
            int minPre = -1;
            for(int j = i; j < nums.length; j++){
                 if(minPre == -1 && nums[j] > pre){
                     minPre = j;
                     continue;
                 }
                 if(minPre != -1 && nums[minPre]>nums[j] && nums[j] > pre){
                     minPre = j;
                 }
            }
            int tmp = nums[i];
            nums[i] = nums[minPre];
            nums[minPre] = tmp;
            pre = Integer.MIN_VALUE;
            i++;
        }

        return nums;
    }
}
