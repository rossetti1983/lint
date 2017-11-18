package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhizha on 8/15/17.
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

 Have you met this question in a real interview? Yes
 Example
 Given [3, 8, 4], return 8.
 */
public class HouseRobber392 {

    Map<Integer, Long> cache = new HashMap<>();
    /**
 * @param : An array of non-negative integers
 * @return: The maximum amount of money you can rob tonight
 */
    public long houseRobber(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return 0;
        }else if(A.length == 1){
            return A[0];
        }else{
            return houseRobber(A, 0);
        }

    }

    private long houseRobber(int[] a, int i) {
        if(cache.containsKey(i)){
            return cache.get(i);
        }
        if(i >= a.length){
            return 0;
        }
        if(i == a.length - 1){
            return a[i];
        }
        long val = a[i];
        long child = houseRobber(a, i+1);
        long grandChild = houseRobber(a, i+2);
        long max = Math.max(grandChild+val, child);
        cache.put(i,max);
        return max;
    }
}
