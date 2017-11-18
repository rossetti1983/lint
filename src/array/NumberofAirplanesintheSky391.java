package array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zhizha on 10/22/17.
 */
public class NumberofAirplanesintheSky391 {

    public static void main(String[] arg){
        NumberofAirplanesintheSky391 numberofAirplanesintheSky391 = new NumberofAirplanesintheSky391();
        List<Interval> list = new ArrayList();
        list.add(new Interval(1,10));
        list.add(new Interval(2,3));
        list.add(new Interval(5,8));
        list.add(new Interval(4,7));
        numberofAirplanesintheSky391.countOfAirplanes(list);
    }
    /*
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        if(airplanes == null || airplanes.size()==0){
            return 0;
        }
        // write your code here
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(Interval inter : airplanes){
            if(min > inter.start){
                min = inter.start;
            }
            if(max < inter.end){
                max= inter.end;
            }
        }

        int[] count = new int[max-min];
        int resMax = 0;
        for(Interval inter : airplanes){
            int len = inter.end-inter.start;
            int start = inter.start-min;
            for(int i = start; i < start+len; i++){
                count[i]++;
                if(resMax < count[i]){
                    resMax = count[i];
                }
            }
        }

        return resMax;
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
