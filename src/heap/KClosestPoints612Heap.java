package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by zhizha on 10/28/17.
 */
public class KClosestPoints612Heap {

    Point[] heap;
    /**
     * @param points a list of points
     * @param origin a point
     * @param k      an integer
     * @return the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here
        PriorityQueue<Point> queue = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                double o1z = Math.pow(o1.x-origin.x,2) + Math.pow(o1.y-origin.y, 2);
                double o2z = Math.pow(o2.x-origin.x,2) + Math.pow(o2.y-origin.y, 2);
                if(o1z > o2z){
                    return -1;
                }else if (o1z < o2z){
                    return 1;
                }else{
                    if(o1.x>o2.x){
                        return -1;
                    }else{
                        return 1;
                    }
                }
            }
        });

        int i = 0;
        while(i<points.length){
            if(queue.size()>=k){
                queue.poll();
            }
            queue.add(points[i++]);
        }

        Point[] points1 = new Point[k];
        int j = 0;
        while(queue.size()!=0){
            points1[j++] = queue.poll();
        }
        return points1;

    }

    private static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}
