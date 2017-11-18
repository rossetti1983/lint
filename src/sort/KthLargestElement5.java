package sort;

/**
 * Created by zhizha on 11/13/17.
 */
public class KthLargestElement5 {

    public static void main(String[] arg){
        KthLargestElement5 kthLargestElement5 = new KthLargestElement5();
        kthLargestElement5.kthLargestElement(3, new int[]{9,3,2,4,8});
    }

    /*
    * @param k : description of k
    * @param nums : array of nums
    * @return: description of return
    */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if(nums == null || k<= 0 ){
            return -1;
        }

        return getKthElmenet(nums, 0, nums.length-1, nums.length-k);
    }

    private int getKthElmenet(int[] nums, int start, int end, int k){
        int pivotIndex = end;
        int pivot = nums[end];
        int p = start-1;

        for(int i =start ;i < pivotIndex; i++){

            if(nums[i] <= pivot){
                p++;
                int tmp = nums[i];
                nums[i] = nums[p];
                nums[p] = tmp;
            }
        }

        int tmp = nums[p+1];
        nums[p+1] = nums[pivotIndex];
        nums[pivotIndex] = tmp;

        if(p+1==k){
            return nums[k];
        }else if(p+1 > k){
            return getKthElmenet(nums, start, p, k);
        }else{
            return getKthElmenet(nums, p+2, end, k);
        }
    }
}
