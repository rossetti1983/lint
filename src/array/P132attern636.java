package array;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by zhizha on 8/17/17.
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.

 n will be less than 20,000.

 Have you met this question in a real interview? Yes
 Example
 Given nums = [1, 2, 3, 4]
 return False // There is no 132 pattern in the sequence.

 Given nums = [3, 1, 4, 2]
 return True // There is a 132 pattern in the sequence: [1, 4, 2].
 */
public class P132attern636 {

    public static void main(String[] arg){
        int[] nums = new int[]{5,6,4,1,3,2};
        P132attern636 p132attern636 = new P132attern636();
        p132attern636.find132pattern(nums);

    }

    /**
     * @param nums a list of n integers
     * @return true if there is a 132 pattern or false
     */
    public boolean find132pattern(int[] nums) {
        boolean pminflag = false;
        int premin = Integer.MAX_VALUE;
        int premax = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i]>min && nums[i]<max){
                return true;
            }
            if(nums[i] < premin){
                premin = nums[i];
                pminflag = true;
            }else if(nums[i] > premax){
                premax = nums[i];
                if(pminflag){
                    max = premax;
                    min = premin;
                    pminflag = false;
                    continue;
                }
            }

            if(nums[i] > max){
                max = nums[i];
            }
        }
        return false;
    }
}
