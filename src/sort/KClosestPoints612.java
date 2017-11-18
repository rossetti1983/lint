package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zhizha on 10/28/17.
 */
public class KClosestPoints612 {

    Point[] heap;
    /**
     * @param points a list of points
     * @param origin a point
     * @param k      an integer
     * @return the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                double o1z = Math.pow(o1.x-origin.x,2) + Math.pow(o1.y-origin.y, 2);
                double o2z = Math.pow(o2.x-origin.x,2) + Math.pow(o2.y-origin.y, 2);
                if(o1z > o2z){
                    return 1;
                }else if (o1z < o2z){
                    return -1;
                }else{
                    if(o1.x>o2.x){
                        return 1;
                    }else{
                        return -1;
                    }
                }
            }
        });

        return Arrays.copyOfRange(points, 0, k);

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
