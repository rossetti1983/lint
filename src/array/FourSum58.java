package array;

import java.util.*;

/**
 * Created by zhizha on 8/10/17.
 */
public class FourSum58 {

    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     *
     *           Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?

    Find all unique quadruplets in the array which gives the sum of target.

    Notice

    Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
    The solution set must not contain duplicate quadruplets.

    Have you met this question in a real interview? Yes
    Example
    Given array S = {1 0 -1 0 -2 2}, and target = 0. A solution set is:

    (-1, 0, 0, 1)
    (-2, -1, 1, 2)
    (-2, 0, 0, 2)
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        /* your code */
        ArrayList<ArrayList<Integer>> res = new  ArrayList<>();
        if(numbers == null || numbers.length == 0){
            return res;
        }
        Map<Integer, Integer> cache = new HashMap();
        Set<String> set = new HashSet();
        Arrays.sort(numbers);

        // write your code here
        for (int i = 0; i< numbers.length; i++){
            cache.put(numbers[i], i);
        }



        for(int h = 0; h < numbers.length; h++) {
            int target0 = target - numbers[h];
            if (numbers[h] > target && numbers[h] > 0) {
                break;
            }
            f:
            for (int i = h + 1; i < numbers.length; i++) {
                int target1 = target0 - numbers[i];
                if(numbers[i] > target0 && numbers[i] > 0){
                    break f;
                }
                s:
                for (int j = i + 1; j < numbers.length; j++) {
                    if(numbers[j]> target1 && numbers[j] > 0){
                        break s;
                    }
                    if (cache.containsKey(target1 - numbers[j])) {
                        int a = numbers[h];
                        int b = numbers[i];
                        int dIndex = cache.get(target1 - numbers[j]);
                        if (dIndex <= j) {
                            continue;
                        }
                        int c = numbers[j];
                        int d = numbers[dIndex];
                        if (!set.contains(a + "/" + b + "/" + c + "/" + d)) {
                            ArrayList<Integer> bs = new ArrayList<>();
                            bs.add(a);
                            bs.add(b);
                            bs.add(c);
                            bs.add(d);
                            set.add(a + "/" + b + "/" + c + "/" + d);
                            res.add(bs);
                        }
                    }
                }
            }

        }

        return res;

    }

}
