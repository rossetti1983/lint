package design;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhizha on 11/11/17.
 */
public class LRUCache {

    public static void main(String[] arg){
        LRUCache lruCache = new LRUCache(2);
        lruCache.set(2,1);
        lruCache.set(1,1);
        lruCache.get(2);
        lruCache.set(4,1);
        lruCache.get(1);
        lruCache.get(2);
        //set(2,1),set(1,1),get(2),set(4,1),get(1),get(2)]
    }

    private static class Key {
        Integer key = null;
        Integer count = 0;

        Key(Integer key) {
            this.key = key;
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
    public LRUCache(int capacity) {
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
            priorityQueue[index].count= ++weight;
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
            priorityQueue[index].count= ++weight;
            index = heapify(priorityQueue, index);
            position.put(key, index);
            values.put(key, value);
        } else {
            if (size == priorityQueue.length) {
                Key remove = priorityQueue[0];
                Key k = priorityQueue[size-1];
                size--;
                priorityQueue[0] = k;
                int index = heapify(priorityQueue, 0);
                position.put(k.key, index);
                values.remove(remove.key);
                position.remove(remove.key);
            }
                priorityQueue[size] = new Key(key);
                priorityQueue[size].count = ++weight;
                values.put(key, value);
                position.put(key, size);
                size++;
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
            if (key.count > left.count && key.count > rightIndex) {
                if (left.count < right.count) {
                    newIndex = swap(queue, index, leftIndex);
                } else {
                    newIndex = swap(queue, index, rightIndex);
                }
            } else if (key.count > left.count) {
                newIndex = swap(queue, index, leftIndex);
            } else if (key.count > right.count) {
                newIndex = swap(queue, index, rightIndex);
            }
        } else if (left != null) {
            if (key.count > left.count) {
                newIndex = swap(queue, index, leftIndex);
            }
        }

        if (newIndex == -1) {
            return index;
        }
        return heapify(queue, newIndex);
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
