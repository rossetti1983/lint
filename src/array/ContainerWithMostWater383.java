package array;

/**
 * Created by zhizha on 8/11/17.
 */
public class ContainerWithMostWater383 {

    /**
     *
     * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
     * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
     * Find two lines, which together with x-axis forms a container, such that the container contains the most water.

     Notice

     You may not slant the container.

     Have you met this question in a real interview? Yes
     Example
     Given [1,3,2], the max area of the container is 2.
     * @param : a vector of integers
     * @return: an integer
     **/
    public int maxArea(int[] heights) {

        // write your code here
        if(heights == null || heights.length <= 1){
            return 0;
        }
        int length = heights.length;
        int left = 0;
        int right = length-1;
        int max = Integer.MIN_VALUE;
        while(left < right){
            int area = (right - left) * Math.min(heights[left], heights[right]);
            if(area > max){
                max = area;
            }
            if(heights[right] > heights[left]){
                left++;
            }else{
                right--;
            }
        }
        return max;

    }
}
