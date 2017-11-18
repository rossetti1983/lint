package matrix;

/**
 * Created by zhizha on 8/27/17.
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.

 This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 Have you met this question in a real interview? Yes
 Example
 Consider the following matrix:

 [
 [1, 3, 5, 7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 */
public class Search2DMatrix28 {

    public static void main(String[] arg){
        Search2DMatrix28 search2DMatrix28 = new Search2DMatrix28();
        search2DMatrix28.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}}, 7);
    }
    /*
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null ||matrix.length == 0){
            return false;
        }
        // write your code here
        int x = matrix.length;
        int y = matrix[0].length;
        return binarySearchX(matrix, target, 0, x-1);
    }

    private boolean binarySearchX(int[][] matrix, int target, int xStart, int xEnd) {
        if(xStart > xEnd){
            return false;
        }

        int xMid = xStart + (xEnd -xStart) /2;
        if(matrix[xMid][0] <= target && matrix[xMid][matrix[xMid].length-1] >= target){
            return binarySearchY(matrix[xMid], target,0, matrix[xMid].length-1);
        }else if(matrix[xMid][0] > target){
            return binarySearchX(matrix, target, xStart, xMid-1);
        }else if(matrix[xMid][matrix[xMid].length-1] < target){
            return binarySearchX(matrix, target, xMid+1, xEnd);
        }else{
            return false;
        }
    }


    private boolean binarySearchY(int[] matrix, int target, int yStart, int yEnd){
        if(yStart > yEnd){
            return false;
        }

        int yMid = yStart + (yEnd -yStart) /2;
        if(matrix[yMid] == target){
            return true;
        }else if(matrix[yMid] > target){
            return binarySearchY(matrix, target, yStart, yMid-1);
        }else{
            return binarySearchY(matrix, target, yMid+1, yEnd);
        }
    }

}
