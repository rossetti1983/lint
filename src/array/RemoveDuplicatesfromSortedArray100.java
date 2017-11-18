package array;

/**
 * Created by zhizha on 8/23/17.
 */
public class RemoveDuplicatesfromSortedArray100 {

    public static void main(String[] arg){
        RemoveDuplicatesfromSortedArray100 removeDuplicatesfromSortedArray100 = new RemoveDuplicatesfromSortedArray100();
        removeDuplicatesfromSortedArray100.removeDuplicates(new int[]{-14,-14,-13,-13,-13,-13,-13,-13,-13,-12,-12,-12,-12,-11,-10,-9,-9,-9,-8,-7,-5,-5,-5,-5,-4,-3,-3,-2,-2,-2,-2,-1,-1,-1,-1,-1,0,1,1,1,1,2,2,2,3,3,3,4,4,4,4,5,5,5,6,6,6,6,7,8,8,8,9,9,9,10,10,10,11,11,11,12,12,12,13,14,14,14,14,15,16,16,16,18,18,18,19,19,19,19,20,20,20,21,21,21,21,21,21,22,22,22,22,22,23,23,24,25,25});
    }
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        int pre = 0;
        int count=0;
        for(int i = 0; i < nums.length; i++){
            if(i==0){
                pre = nums[i];
            }else{
                if(pre==nums[i]){
                    continue;
                }else{
                    pre = nums[i];
                }
            }
            count++;
        }
        int[] B = new int[count];
        int j = 0;
        pre = 0;
        for(int i = 0; i < nums.length; i++){
            if(i==0){
                pre = nums[i];
            }else{
                if(pre==nums[i]){
                    continue;
                }else{
                    pre = nums[i];
                }
            }
            B[j++] = nums[i];
        }
        nums = B;
        return count;
    }
}
