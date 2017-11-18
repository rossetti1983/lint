package array;

/**
 * Created by zhizha on 10/27/17.
 */
public class WiggleSort {

    public static void main(String[] arg){
        WiggleSort wiggleSort = new WiggleSort();
        wiggleSort.wiggleSort(new int[]{3,5,2,1,6,4});
    }

    public void wiggleSort(int[] nums) {
        // Write your code here
        for(int i=1; i<nums.length; i++) {
            if((i%2==1 && (nums[i] < nums[i-1]) ||
                    (i%2==0) && (nums[i] > nums[i-1]))) {
                swap(nums, i-1, i);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
