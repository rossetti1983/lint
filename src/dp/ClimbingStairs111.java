package dp;

import java.util.HashMap;

/**
 * Created by zhizha on 8/19/17.
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 Have you met this question in a real interview? Yes
 Example
 Given an example n=3 , 1+1+1=2+1=1+2=3

 return 3


 */
public class ClimbingStairs111 {

    HashMap<Integer, Integer> cache = new HashMap<>();
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        if(n == 0){
            return 1;
        }else if(n < 0){
            return 0;
        }

        if(cache.containsKey(n)){
            return cache.get(n);
        }
        // write your code here
        int n0 = climbStairs(n-1);

        int n1 = climbStairs(n-2);

        cache.put(n, n0+n1);
        return n0+n1;

    }
}
