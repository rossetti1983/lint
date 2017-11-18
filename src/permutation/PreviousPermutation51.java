package permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhizha on 8/29/17.
 * Given a list of integers, which denote a permutation.

 Find the previous permutation in ascending order.

 Notice

 The list may contains duplicate integers.

 Have you met this question in a real interview? Yes
 Example
 For [1,3,2,3], the previous permutation is [1,2,3,3]

 For [1,2,3,4], the previous permutation is [4,3,2,1]
 */
public class PreviousPermutation51 {
    /*
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public List<Integer> previousPermuation(List<Integer> numl) {
        if(numl == null || numl.size() < 2 ){
            return numl;
        }
        Integer[] nums = new Integer[numl.size()];
        int index = 0;
        for(Integer i:numl){
            nums[index++] = i;
        }

        int len = nums.length;
        if(nums[len-2] > nums[len-1]){
            int tmp = nums[len-1];
            nums[len-1] = nums[len-2];
            nums[len-2] = tmp;
            return  Arrays.asList(nums);
        }

        // write your code here
        for(int i = nums.length-1; i>=0; i--){
            if(i == nums.length -1){
                continue;
            }else{
                if(nums[i] > nums[i+1]){
                    return Arrays.asList(nextPermutation(nums,i));
                }
            }
        }
        return Arrays.asList(nextPermutation(nums,-1));
    }

    private Integer[] nextPermutation(Integer[] nums, int i) {
        int pre = -1;
        if(i == -1){
            i = 0;
            pre = Integer.MAX_VALUE;
        }else{
            pre = nums[i];
        }


        while(i<nums.length){
            int maxPre = -1;
            for(int j = i; j < nums.length; j++){
                if(maxPre == -1 && nums[j] < pre){
                    maxPre = j;
                    continue;
                }
                if(maxPre != -1 && nums[maxPre]<nums[j] && nums[j] < pre){
                    maxPre = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[maxPre];
            nums[maxPre] = tmp;
            pre = Integer.MAX_VALUE;
            i++;
        }

        return nums;
    }
}
