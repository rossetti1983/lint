package matrix;

/**
 * Created by zhizha on 10/27/17.
 */
public class Search2DMII38 {

    public static void main(String[] arg){
        Search2DMII38 search2DMII38 = new Search2DMII38();
        search2DMII38.searchMatrix(new int[][]{
                {1,3,5,7},
                {2,4,7,8},
                {3,5,9,10}}, 7);
    }

    public int searchMatrix(int[][] matrix, int target) {
        // write your code here

        return dfs(matrix, 0, matrix[0].length, target, 0);
    }

    public int dfs(int[][] matrix, int level, int endIndex, int target, int count){
        if(level>matrix.length-1){
            return count;
        }
        for(int i = 0; i < endIndex; i++){
            if(matrix[level][i] >= target){
                if(matrix[level][i] == target){
                    count++;
                }
                return dfs(matrix, ++level, i, target, count);
            }
        }
        return dfs(matrix, ++level, endIndex, target, count);
    }
}
