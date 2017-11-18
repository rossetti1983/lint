package array;

/**
 * Created by zhizha on 10/25/17.
 */
public class MaximumSubarrayDifference45 {

    public int maxDiffSubArrays(int[] nums) {
        // write your code here

        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] poforward = new int[nums.length];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(sum+nums[i]>0){
                sum = sum+nums[i];
                poforward[i] = sum;
            }else{
                poforward[i] = nums[i];
                sum = 0;
            }
        }

        int[] pobackward = new int[nums.length];
        sum = 0;
        for(int i = nums.length-1; i>=0; i--){
            if(sum+nums[i]>0){
                sum = sum+nums[i];
                pobackward[i] = sum;
            }else{
                pobackward[i] = nums[i];
                sum = 0;
            }
        }

        int[] negforward = new int[nums.length];
        sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(sum+nums[i]<0){
                sum = sum+nums[i];
                negforward[i] = sum;
            }else{
                negforward[i] = nums[i];
                sum = 0;
            }
        }

        int[] negbackward = new int[nums.length];
        sum = 0;
        for(int i = nums.length-1; i>=0; i--){
            if(sum+nums[i]<0){
                sum = sum+nums[i];
                negbackward[i] = sum;
            }else{
                negbackward[i] = nums[i];
                sum = 0;
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < poforward.length; i++){
            for(int j = i+1; j < negbackward.length; j++){
                if(Math.abs(poforward[i]-negbackward[j])>max){
                    max = Math.abs(poforward[i]-negbackward[j]);
                }
            }
        }

        for(int i = 0 ; i < negforward.length; i++){
            for(int j = i+1; j < pobackward.length; j++){
                if(Math.abs(negforward[i]-pobackward[j])>max){
                    max = Math.abs(negforward[i]-pobackward[j]);
                }
            }
        }

        return max;
    }
}
