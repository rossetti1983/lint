package design;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhizha on 11/12/17.
 */
public class LFUCache {

    public static void main(String[] arg){
        LFUCache lruCache = new LFUCache(3);
        lruCache.set(1,10);
        lruCache.set(2,20);
        lruCache.set(3,30);
        lruCache.get(1);
        lruCache.set(4,40);
        lruCache.get(4);
        lruCache.get(3);
        lruCache.get(2);
        lruCache.get(1);
        lruCache.set(5,50);
        lruCache.get(1);
        lruCache.get(2);
        lruCache.get(3);
        lruCache.get(4);
        lruCache.get(5);
        //set(1,10),set(2,20),set(3,30),get(1),set(4,40),get(4),get(3),get(2),get(1),set(5,50),get(1),get(2),get(3),get(4),get(5)
    }

    private static class Key {
        Integer key = null;
        Integer count = 0;
        long weight = 0;
        Key(Integer key) {
            this.key = key;
            weight =  ++weight;
        }
    }

    Map<Integer, Integer> values = new HashMap<>();
    Map<Integer, Integer> position = new HashMap<>();
    Key[] priorityQueue = null;
    int size = 0;
    int weight = 0;
    /*
    * @param capacity: An integer
    */
    public LFUCache(int capacity) {
        // do intialization if necessary
        priorityQueue = new Key[capacity];
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (!values.containsKey(key)) {
            return -1;
        } else {
            int index = position.get(key);
            priorityQueue[index].count++;
            priorityQueue[index].weight = ++weight;
            index = heapify(priorityQueue, index);
            position.put(key, index);
            return values.get(key);
        }
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (values.containsKey(key)) {
            int index = position.get(key);
            priorityQueue[index].weight = ++weight;
            index = heapify(priorityQueue, index);
            position.put(key, index);
            values.put(key, value);
        } else {
            if (size == priorityQueue.length) {
                Key remove = priorityQueue[0];
                Key k = new Key(key);
                priorityQueue[0] = k;
                position.put(k.key, 0);
                values.put(k.key, value);
                values.remove(remove.key);
                position.remove(remove.key);
            }else{
                Key k = new Key(key);
                priorityQueue[size] = k;
                int index = heapifyUp(priorityQueue, size);
                position.put(k.key, index);
                values.put(k.key, value);
                size++;
            }
        }
    }

    public int heapify(Key[] queue, int index) {
        Key key = queue[index];
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;
        Key left = null;
        Key right = null;
        if (leftIndex < size) {
            left = queue[leftIndex];
        }

        if (rightIndex < size) {
            right = queue[rightIndex];
        }

        int newIndex = -1;
        if (left != null && right != null) {
            if (key.count >= left.count && key.count >= right.count) {
                if (left.count < right.count) {
                    newIndex = swap(queue, index, leftIndex);
                } else if(left.count > right.count){
                    newIndex = swap(queue, index, rightIndex);
                } else {
                    if(left.weight>right.weight){
                        newIndex = swap(queue, index, rightIndex);
                    }else{
                        newIndex = swap(queue, index, leftIndex);
                    }
                }
            } else if (key.count >= left.count) {
                newIndex = swap(queue, index, leftIndex);
            } else if (key.count >= right.count) {
                newIndex = swap(queue, index, rightIndex);
            }
        } else if (left != null) {
            if (key.count >= left.count) {
                newIndex = swap(queue, index, leftIndex);
            }
        }

        if (newIndex == -1) {
            return index;
        }
        return heapify(queue, newIndex);
    }

    public int heapifyUp(Key[] queue, int index) {
        Key key = queue[index];
        int leftParent = (index-1)/2 ;
        int rightParent = (index-2)/2;
        Key left = null;
        Key right = null;
        if (leftParent >=0) {
            left = queue[leftParent];
        }

        if (rightParent >=0) {
            right = queue[rightParent];
        }

        int newIndex = -1;
        if (left != null && right != null) {
            if (key.count < left.count && key.count < right.count) {
                if (left.count < right.count) {
                    newIndex = swap(queue, index, leftParent);
                } else {
                    newIndex = swap(queue, index, rightParent);
                }
            } else if (key.count < left.count) {
                newIndex = swap(queue, index, leftParent);
            } else if (key.count < right.count) {
                newIndex = swap(queue, index, rightParent);
            }
        } else if (left != null) {
            if (key.count < left.count) {
                newIndex = swap(queue, index, leftParent);
            }
        }

        if (newIndex == -1) {
            return index;
        }
        return heapifyUp(queue, newIndex);
    }



    private int swap(Key[] queue, int index, int target) {
        Key src = queue[index];
        Key tar = queue[target];
        position.put(src.key, target);
        position.put(tar.key, index);
        queue[index] = queue[target];
        queue[target] = src;
        return target;
    }
}
