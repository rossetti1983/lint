package array;

import java.util.*;

/**
 * Created by zhizha on 8/10/17.
 */
public class ThreeSum57 {

    public static void main(String[] arg){
        int[] a = new int[]{-2,-7,11,9};
        ThreeSum57 threeSum57 = new ThreeSum57();
        threeSum57.threeSum(a);
    }

    /**
     * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
     * Find all unique triplets in the array which gives the sum of zero.

     Notice

     Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)

     The solution set must not contain duplicate triplets.

     Have you met this question in a real interview? Yes
     Example
     For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:

     (-1, 0, 1)
     (-1, -1, 2)
     *
     *
     *
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     *
     *
     * Notice : remove duplicate
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {


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



        for(int i = 0; i < numbers.length; i++){
            int target = 0 - numbers[i];
            if(numbers[i]>0){
                break;
            }

            for(int j = i + 1 ; j < numbers.length; j++){
                if(cache.containsKey(target - numbers[j])){
                    int a = numbers[i];
                    int cIndex = cache.get(target - numbers[j]);
                    if(cIndex<=j){
                        continue;
                    }
                    int b = numbers[j];
                    int c = numbers[cIndex];
                    if(!set.contains(a+"/"+b+"/"+c)) {
                        ArrayList<Integer> bs = new ArrayList<>();
                        bs.add(a);
                        bs.add(b);
                        bs.add(c);
                        set.add(a+"/"+b+"/"+c);
                        res.add(bs);
                    }
                }
            }
        }


        return res;

    }
    }
