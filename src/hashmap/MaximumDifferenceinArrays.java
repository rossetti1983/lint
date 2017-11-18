package hashmap;

/**
 * Created by zhizha on 10/20/17.
 */
public class MaximumDifferenceinArrays {

    public static void main(String[] arg){
        MaximumDifferenceinArrays maximumDifferenceinArrays = new MaximumDifferenceinArrays();
        maximumDifferenceinArrays.maxDiff(new int[][]{{1,10},{-1,200}});
    }

    public int maxDiff(int[][] arrs) {
        // write your code here
        if(arrs == null || arrs.length == 0 ||arrs[0].length == 0){
            return 0;
        }

        int[] max1 = new int[2];
        int[] max2 = new int[2];
        int[] min1 = new int[2];
        int[] min2 = new int[2];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arrs.length; i++){
            for(int j = 0 ; j < arrs[i].length; j++){
                if((arrs[i][j]) > max){
                    max2[0] = max1[0];
                    max2[1] = max1[1];
                    max = (arrs[i][j]);
                    max1[0] = i;
                    max1[1] = max;
                }

                if((arrs[i][j]) < min){
                    min2[0] = min1[0];
                    min2[1] = min1[1];
                    min = (arrs[i][j]);
                    min1[0] = i;
                    min1[1] = min;
                }
            }
        }

        if(max1[0]!=min1[0]){
            return Math.abs(max1[1] - min1[1]);
        }else{
            return Math.max(Math.abs((max1[1] - min2[1])),Math.abs(max2[1] - min1[1]));
        }

    }
}
