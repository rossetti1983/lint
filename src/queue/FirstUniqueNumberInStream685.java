package queue;

import java.util.*;

/**
 * Created by zhizha on 10/15/17.
 */
public class FirstUniqueNumberInStream685 {

    /*
 * @param : a continuous stream of numbers
 * @param : a number
 * @return: returns the first unique number
 */
    public int firstUniqueNumber(int[] nums, int number) {
        // Write your code here
        if(nums == null || nums.length == 0){
            return -1;
        }
        int i = 0 ;

        Map<Integer,Entry> pool = new HashMap<>();
        Queue<Entry> unique = new LinkedList<>();
        int flag = 0;
        while(i<nums.length){
            Entry entry = new Entry(nums[i]);
            if(!pool.containsKey(nums[i])){
                entry.setValue(1);
                pool.put(nums[i],entry);
                unique.offer(entry);
            }else{
                entry = pool.get(nums[i]);
                entry.setValue(entry.getValue()+1);
            }
            if(nums[i] == number){
                flag = 1;
                break;
            }
            i++;
        }
        if(flag == 0){
            return -1;
        }

        while(!unique.isEmpty()){
            Entry entry = unique.poll();
            if(entry.getValue() == 1){
                return entry.key;
            }
        }
        return -1;
    }

    private static class Entry {
        Integer key = null;
        Integer value = null;
        Entry(Integer key){
            this.key = key;
        }

        int getValue(){
            return value;
        }

        void setValue(Integer value){
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Entry) {
                return this.key.equals(((Entry)(obj)).key);
            }
            return false;
        }
    }

}
