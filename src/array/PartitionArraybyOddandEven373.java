package array;

/**
 * Created by zhizha on 8/22/17.
 */
public class PartitionArraybyOddandEven373 {

    public static void main(String[] arg){
        PartitionArraybyOddandEven373 partitionArraybyOddandEven373 = new PartitionArraybyOddandEven373();
        partitionArraybyOddandEven373.partitionArray(new int[]{2147483644,2147483645,2147483646,2147483647});
    }

    public void partitionArray(int[] nums) {
        // write your code here;

        int even = 0;
        int odd = nums.length - 1;
        int evenFlag = 0;
        int oddFlag = 0;

        while(even < odd){
            if(nums[odd]%2 != 0){
                oddFlag = 1;
            }

            if(nums[even]%2 == 0){
                evenFlag =  1;
            }

            if(oddFlag == 1 && evenFlag == 1){
                int tmp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = tmp;
                oddFlag = 0;
                evenFlag = 0;
            }

            if(oddFlag == 0){
                odd--;
            }
            if(evenFlag == 0){
                even++;
            }
        }
    }

}
