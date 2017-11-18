package array;

import java.util.Arrays;

/**
 * Created by zhizha on 10/25/17.
 */
public class ThreeSumClosest59 {

    public static void main(String[] arg){
        ThreeSumClosest59 threeSumClosest59 = new ThreeSumClosest59();
        threeSumClosest59.threeSumClosest(new int[]{1,0,-1,0,-2,2,21,-15}, -20);
    }
    /*
    * @param numbers: Give an array numbers of n integer
    * @param target: An integer
    * @return: return the sum of the three integers, the sum closest target.
    */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        if(numbers == null || numbers.length<3){
            return -1;
        }

        Arrays.sort(numbers);
        int min = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for(int i = 0 ; i < numbers.length; i++){
            if(numbers[i] >= target && Math.abs(numbers[i] - target) >= min){
                return res;
            }

            int start = i+1;
            int end = numbers.length - 1;
            inner:
            while(start < end){

                int sum = numbers[i] + numbers[start] + numbers[end];
                if(Math.abs(sum-target) < min){
                    min = Math.abs(sum-target);
                    res = sum;
                }
                if(sum == target){
                    return sum;
                }else if(sum > target){
                    end--;
                }else{
                    start++;
                }
            }
        }
        return res;
    }
}
