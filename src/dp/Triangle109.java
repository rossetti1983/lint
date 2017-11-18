package dp;

import java.util.HashMap;

/**
 * Created by zhizha on 8/27/17.
 */
public class Triangle109 {

    public static void main(String[] arg){
        Triangle109 triangle109 = new Triangle109();
        triangle109.minimumTotal(new int[][]{{-1},{2,3},{1,-1,-3}});
    }

    /*
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    HashMap<String,Integer> cache = new HashMap<>();
    public int minimumTotal(int[][] triangle) {
        // write your code here
        int min = minimumTotal(triangle,0,  new int[]{0});
        return min;
    }

    public int minimumTotal(int[][] triangle,int level, int[] adjs) {
        if(level>=triangle.length){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < adjs.length; i++){
            if(cache.containsKey(level + ","+adjs[i])){
                if(min > cache.get(level + ","+adjs[i])){
                    min = cache.get(level + ","+adjs[i]);
                    continue;
                }
            }
            int[] adj = new int[2];
            adj[0] = adjs[i]+0;
            adj[1] = adjs[i]+1;

            int localMin = minimumTotal(triangle,level+1, adj)+triangle[level][adjs[i]];
            if(min>localMin){
                min = localMin;
            }
            cache.put(level + ","+adjs[i] ,localMin);
        }
        return min;
    }
}
