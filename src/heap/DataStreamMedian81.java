package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by zhizha on 10/28/17.
 */
public class DataStreamMedian81 {

    /*
    * @param nums: A list of integers
    * @return: the median of numbers
    */
    public int[] medianII(int[] nums) {
        // write your code here
        PriorityQueue<Integer> minq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1>o2 ? 1 : -1;
            }
        });

        PriorityQueue<Integer> maxq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1>o2 ? -1 : 1;
            }
        });

        int[] median = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(i==0){
                maxq.add(nums[i]);
            }else if(i==1){
                if(nums[i]>=maxq.peek()){
                    minq.add(nums[i]);
                }else{
                    minq.add(maxq.poll());
                    maxq.add(nums[i]);
                }
            }else {
                int m = i / 2 + 1;
                if(maxq.size() == m){
                    if(nums[i] >= maxq.peek()){
                        minq.add(nums[i]);
                    }else{
                        minq.add(maxq.poll());
                        maxq.add(nums[i]);
                    }
                }else{
                    if(nums[i] < minq.peek()){
                        maxq.add(nums[i]);
                    }else{
                        maxq.add(minq.poll());
                        minq.add(nums[i]);
                    }
                }
            }

            median[i] = maxq.peek();

        }

        return median;
    }

}
