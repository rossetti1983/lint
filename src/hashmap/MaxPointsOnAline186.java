package hashmap;

import java.util.HashMap;

/**
 * Created by zhizha on 10/20/17.
 */
public class MaxPointsOnAline186 {

    /*
 * @param points: an array of point
 * @return: An integer
 */
    public int maxPoints(Point[] points) {
        // write your code here
        if(points == null){
            return 0;
        }
        if(points.length < 3){
            return points.length;
        }
        int max = Integer.MIN_VALUE;
        int n = points.length;
        for(int i = 0; i < n; i++){
            HashMap<Double, Integer> cache = new HashMap<>();
            Point cur = points[i];
            for(int j = 0; j < n; j++) {
                if(j==i){
                    continue;
                }else{
                    Point next = points[j];
                    double k = (double)(cur.y - next.y)/(cur.x - next.x);
                    if(cache.containsKey(k)){
                        cache.put(k,cache.get(k)+1);
                    }else{
                        cache.put(k, 1);
                    }
                }
            }

            for(double d:cache.keySet()){
                if(cache.get(d) > max){
                    max = cache.get(d);
                }
            }
            }
            return max;
        }

    private static class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }
    }



