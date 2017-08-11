package array;

import java.util.HashMap;

/**
 * Created by zhizha on 8/9/17.
 */
public class TwoSum56 {


    /**
 * @param numbers : An array of Integer
 * @param target : target = numbers[index1] + numbers[index2]
 * @return : [index1 + 1, index2 + 1] (index1 < index2)
 * Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target,
where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are NOT zero-based.
 */
    public int[] twoSum(int[] numbers, int target) {
        int[] t  = new int[2];
        if(numbers==null || numbers.length == 0){
            return null;
        }
        HashMap<Integer, Integer> cache = new HashMap<>();
        for(int i = 0; i < numbers.length; i++ ){
            cache.put(numbers[i],i+1);
        }
        int a = -1;
        int b = -1;
        for(int i = 0; i < numbers.length; i++){
            if(cache.containsKey(target - numbers[i])){
                a = i+1;
                b = cache.get(target - numbers[i]);
                break;
            }
            continue;
        }
        if(a>b){
            t[0]=b;
            t[1]=a;
        }else{
            t[0] = a;
            t[1] = b;
        }
        return t;
    }
}
