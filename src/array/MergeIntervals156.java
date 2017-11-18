package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zhizha on 10/22/17.
 */
public class MergeIntervals156 {
    public static void main(String[] arg) {
        MergeIntervals156 MergeIntervals156 = new MergeIntervals156();
        List<Interval> list = new ArrayList();
        list.add(new Interval(1, 3));
        list.add(new Interval(2, 3));
        list.add(new Interval(2, 2));
        MergeIntervals156.merge(list);
    }

    private static class Point implements Comparable<Point>
    {
        int time ;
        int flag ;
        Point( int time, int flag){
            this.time = time;
            this.flag = flag;
        }


        @Override
        public int compareTo(Point o) {
            if(this.time == o.time){
                if(this.flag - o.flag > 0){
                    return -1;
                }else if(this.flag - o.flag < 0){
                    return 1;
                }else{
                    return 0;
                }
            }else{
                return this.time - o.time;
            }

        }
    }

    /**
     * @param intervals, a collection of intervals
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if(intervals == null || intervals.size() == 0){
            return res;
        }
        List<Point> points = new ArrayList<>();
        for(Interval interval : intervals){
            points.add(new Point(interval.start, 1));
            points.add(new Point(interval.end, -1));
        }
        Collections.sort(points);

        int start = 0;
        int sum = 0;
        for(Point point : points){
            if(sum == 0){
                start = point.time;
                sum = sum + point.flag;
            }else {

                sum = sum + point.flag;
                if (sum == 0) {
                    res.add(new Interval(start, point.time));
                }
            }
        }

        // write your code here
        return res;
    }

    private static class Interval

    {
        int start, end;
        Interval( int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}
