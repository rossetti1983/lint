package heap;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Created by zhizha on 8/30/17.
 * Find the kth smallest number in at row and column sorted matrix.

 Have you met this question in a real interview? Yes
 Example
 Given k = 4 and a matrix:

 [
 [1 ,5 ,7],
 [3 ,7 ,8],
 [4 ,8 ,9],
 ]
 return 5
 */
public class KthSmallestNumberinSortedMatrix401 {

    public static void main(String[] arg){
        int[][] m = new int[][]{{1,5,7},{3,7,8},{8,9,10}};
        KthSmallestNumberinSortedMatrix401 kthSmallestNumberinSortedMatrix401 = new KthSmallestNumberinSortedMatrix401();
        kthSmallestNumberinSortedMatrix401.kthSmallest(m, 6);
    }

    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }else if(matrix.length*matrix[0].length < k){
            return 0;
        }

        HashSet<String> cache = new HashSet<>();
        // write your code here
        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(((Node)o1).value >= ((Node)o2).value){
                    return 1;
                }else{
                    return -1;
                }
            }
        });
        int startX = 0;
        int startY = 0;
        priorityQueue.add(new Node(matrix[startX][startY], startX, startY));
        cache.add(startX+","+startY);
        int res = 0;
        while(k>0){
            Node next = priorityQueue.poll();
            startX = next.x;
            startY  = next.y;
            res = matrix[next.x][next.y];
            if(startX+1 < matrix.length){
            if(!cache.contains((startX+1)+","+startY)) {
                priorityQueue.add(new Node(matrix[startX + 1][startY], startX + 1, startY));
            }
            }
            if(startY+1 < matrix[0].length){
                if(!cache.contains(startX+","+(startY+1))) {
                    priorityQueue.add(new Node(matrix[startX][startY + 1], startX, startY + 1));
                }
            }
            k--;
        }


        return res;
    }


    private static class Node /*implements Comparable<Node>*/{
        int x;
        int y;
        int value;

        Node(int value, int x, int y){
            this.x = x;
            this.y = y;
            this.value = value;
        }


        /*@Override
        public int compareTo(Node o) {
            if(this.value >= o.value){
                return -1;
            }else{
                return 1;
            }
        }*/
    }
}
