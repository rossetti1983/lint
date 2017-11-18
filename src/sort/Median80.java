package sort;

/**
 * Created by zhizha on 10/27/17.
 */
public class Median80 {

    public static void main(String[] arg){
        Median80 median80 = new Median80();
        median80.median(new int[]{-1,-2,-3,-100,-1,-50});
    }
    /*
    * @param nums: A list of integers
    * @return: An integer denotes the middle number of the array
    */
    public int median(int[] nums) {
        // write your code here
        if(nums == null){
            return -1;
        }
        else if(nums.length==1){
            return nums[0];
        }

        int i = getMedian(nums, 0, nums.length-1, (nums.length+1)/2-1);

        return i;
    }

    private int getMedian(int[] nums, int start, int end, int midIndex) {
            int pivotIndex = end;
            int pivot = nums[end];
            int p = start-1;
            for (int i = start; i <= end-1; i++)
            {
            // If current element is smaller than or
            // equal to pivot
            if (nums[i] <= pivot)
                {
                p++;    // increment index of smaller element
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                }
            }


            int temp = nums[p+1];
            nums[p+1] =nums[pivotIndex];
            nums[pivotIndex] = temp;

            if(p+1 == midIndex){
                return nums[midIndex];
            }else if(p+1 > midIndex){
                return getMedian(nums, start, p, midIndex);
            }else{
                return getMedian(nums, p+2, end, midIndex);
            }



    }
}
