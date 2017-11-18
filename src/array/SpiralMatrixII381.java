package array;

import java.util.HashSet;

/**
 * Created by zhizha on 8/31/17.
 */
public class SpiralMatrixII381 {

    public static void main(String[] arg){
        SpiralMatrixII381 spiralMatrixII381 = new SpiralMatrixII381();
        spiralMatrixII381.generateMatrix(3);
    }
    /**
     * @param n an integer
     * @return a square matrix
     */
    public int[][] generateMatrix(int n) {
        // Write your code here
        int[][] matrix = new int[n][n];
        generateMatrixHelper(matrix, 1,0,0,0);
        return matrix;
    }

    HashSet<Integer> row = new HashSet<>();
    HashSet<Integer> col = new HashSet<>();

    void generateMatrixHelper(int[][] matrix,int n,int x, int y, int rdlu){
        if(n>matrix.length*matrix[0].length){
            return;
        }
        if(rdlu == 0){
            matrix[x][y] = n;
            row.add(x);
            int tmpy = y+1;
            if(tmpy==matrix[0].length || col.contains(tmpy)){
                generateMatrixHelper(matrix, n+1, x+1, y, 1);
            }else{
                generateMatrixHelper(matrix, n+1, x, y+1, 0);
            }
        }else if(rdlu == 1){
            matrix[x][y] = n;
            col.add(y);
            int tmpx = x+1;
            if(tmpx==matrix.length || row.contains(tmpx)){
                generateMatrixHelper(matrix, n+1, x, y-1, 2);
            }else{
                generateMatrixHelper(matrix, n+1, x+1, y, 1);
            }
        }else if(rdlu == 2){
            matrix[x][y] = n;
            row.add(x);
            int tmpy = y-1;
            if(tmpy<0 || col.contains(tmpy)){
                generateMatrixHelper(matrix, n+1, x-1, y, 3);
            }else{
                generateMatrixHelper(matrix, n+1, x, y-1, 2);
            }
        }else{
            matrix[x][y] = n;
            col.add(y);
            int tmpx = x-1;
            if(row.contains(tmpx)){
                generateMatrixHelper(matrix, n+1, x, y+1, 0);
            }else{
                generateMatrixHelper(matrix, n+1, x-1, y, 3);
            }
        }
    }
}