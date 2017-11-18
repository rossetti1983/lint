package dp;

import java.util.HashMap;

/**
 * Created by zhizha on 8/22/17.
 * There is a fence with n posts, each post can be painted with one of the k colors.
 You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 Return the total number of ways you can paint the fence.

 Notice

 n and k are non-negative integers.

 Have you met this question in a real interview? Yes
 Example
 Given n=3, k=2 return 6

 post 1,   post 2, post 3
 way1    0         0       1
 way2    0         1       0
 way3    0         1       1
 way4    1         0       0
 way5    1         0       1
 way6    1         1       0
 */
public class PaintFence514 {

    /*
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return: an integer, the total number of ways
     */

    HashMap<String, Integer> cache = new HashMap<>();
    public int numWays(int n, int k) {
        // write your code here
        return numWays(n, -1, -1, k);
    }

    public int numWays(int n, int ppreColor, int preColor, int k) {
        // write your code here
        if(cache.containsKey(n+","+Boolean.valueOf(ppreColor==preColor).toString()+","+k)){
            return cache.get(n+","+Boolean.valueOf(ppreColor==preColor).toString()+","+k);
        }

        if(n==0){
            cache.put(n+","+Boolean.valueOf(ppreColor==preColor).toString()+","+k, 1);
            return 1;
        }
        int count = 0;
        if(ppreColor == preColor){
            for(int i = 0; i < k; i++){
                if(i == preColor){
                    continue;
                }else{
                    count = count + numWays(n-1, preColor,i, k);
                }
            }
            cache.put(n+","+Boolean.valueOf(ppreColor==preColor).toString()+","+k, count);
            return count;
        }else{
            for(int i = 0; i < k; i++){
                count = count + numWays(n-1, preColor,i, k);
            }
            cache.put(n+","+Boolean.valueOf(ppreColor==preColor).toString()+","+k, count);
            return  count;
        }
    }
}
