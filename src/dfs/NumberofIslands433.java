package dfs;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by zhizha on 8/21/17.
 *
 * Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.

 Find the number of islands.

 Have you met this question in a real interview? Yes
 Example
 Given graph:

 [
 [1, 1, 0, 0, 0],
 [0, 1, 0, 0, 1],
 [0, 0, 0, 1, 1],
 [0, 0, 0, 0, 0],
 [0, 0, 0, 0, 1]
 ]
 return 3.
 */
public class NumberofIslands433 {
    HashMap<String, String> cache = new HashMap<>();

    public static void main(String[] arg){
        NumberofIslands433 numberofIslands433= new NumberofIslands433();
        boolean[][] is = new boolean[][]{{true,true,false,false,false},{false,true, false, false, true},
                {false, false, false, true, true},{false, false, false, false, false},{false, false, false, false, true}};
        numberofIslands433.numIslands(is);
    }
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if(grid.length == 0){
            return 0;
        }

        if(grid[0].length == 0){
            return 0;
        }

        int count = 0 ;

        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0 ; j < grid[0].length; j++){
                if(!grid[i][j]){
                    continue;
                }else{
                    if(!cache.containsKey(i+","+j)) {
                        count++;
                        dfs(grid, i, j, null);
                    }
                }
            }
        }
        return count;

    }

    private void dfs(boolean[][] grid, int i, int j, String parent) {

        if(i>=grid.length || j >= grid[0].length || i < 0 ||j < 0){
            return;
        }
        if(cache.containsKey(i+","+j)){return;}
        if(grid[i][j]){
            cache.put(i + "," + j, parent);
                    dfs(grid, i+1, j, i+","+j);
                    dfs(grid, i-1, j, i+","+j);
                    dfs(grid, i, j+1, i+","+j);
                    dfs(grid, i, j-1, i+","+j);
                }
    }
}
