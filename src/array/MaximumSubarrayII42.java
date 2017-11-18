package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhizha on 10/25/17.
 */
public class MaximumSubarrayII42 {

    public static void main(String[] arg){
        MaximumSubarrayII42 maximumSubarrayII42 = new MaximumSubarrayII42();
        maximumSubarrayII42.maxTwoSubArrays(Arrays.asList(1,3,-1,2,-1,2));
    }

    /*
    * @param nums: A list of integers
    * @return: An integer denotes the sum of max two non-overlapping subarrays
    */
    public int maxTwoSubArrays(List<Integer> nums) {
        // write your code here
        if(nums == null || nums.size() == 0){
            return 0;
        }
        int[] forward = new int[nums.size()];
        int sum = 0;
        for(int i = 0; i < nums.size(); i++){
            if(sum+nums.get(i)>0){
                sum = sum+nums.get(i);
                forward[i] = sum;
            }else{
                forward[i] = nums.get(i);
                sum = 0;
            }
        }

        int[] backward = new int[nums.size()];
        sum = 0;
        for(int i = nums.size()-1; i>=0; i--){
            if(sum+nums.get(i)>0){
                sum = sum+nums.get(i);
                backward[i] = sum;
            }else{
                backward[i] = nums.get(i);
                sum = 0;
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < forward.length; i++){
            for(int j = i+1; j < backward.length; j++){
                if(forward[i]+backward[j]>max){
                    max = forward[i]+backward[j];
                }
            }
        }
        return max;
    }
}
