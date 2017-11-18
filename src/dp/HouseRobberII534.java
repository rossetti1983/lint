package dp;
import java.util.HashMap;
import java.util.Map;



/**
 * Created by zhizha on 8/15/17.
 */
public class HouseRobberII534 {
    public static void main(String[] arg){
        int[] nums = {1,3,2,1,5};
        HouseRobberII534 houseRobberII534 = new HouseRobberII534();
        houseRobberII534.houseRobber2(nums);
    }

    Map<Integer, Integer> cache = new HashMap<>();
    int[] pointer;
    /**
     * @param nums: An array of non-negative integers.
     *              return: The maximum amount of money you can rob tonight
     */
    public int houseRobber2(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else {
           // pointer = new int[nums.length];
            int max1 = houseRobber(nums, 0, nums.length-2);
            cache = new HashMap<>();
            int max2 = houseRobber(nums, 1, nums.length-1);
            return Math.max(max1,max2);
        }

    }

    private int houseRobber(int[] a, int i, int l) {

        if (cache.containsKey(i)) {
            return cache.get(i);
        }
        if (i > l) {
            return 0;
        }
        if (i == l) {
            return a[i];
        }
        int val = a[i];
        int child = houseRobber(a, i + 1,l);
        int grandChild = houseRobber(a, i + 2,l);
        /*if(grandChild+val > child){
            pointer[i] = i + 2;
        }else{
            pointer[i] = i + 1;
        }
        if(i == 0){
            if(pointer[i] == i + 2){
                int j = 0;
                while(j < a.length){
                    j = pointer[j];
                    if(j == a.length - 1){
                        return child;
                    }
                }
                return grandChild+val;
            }else{
                return child;
            }
        }else {*/
            int max = Math.max(grandChild + val, child);

            cache.put(i, max);
            return max;
       /* }*/

    }

}
