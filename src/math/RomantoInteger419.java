package math;

import java.util.HashMap;

/**
 * Created by zhizha on 8/28/17.
 */
public class RomantoInteger419 {

    HashMap<String, Integer> map = new HashMap<>();
    public int romanToInt(String s) {
        // write your code here
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        return romanToInt(s, null, 0);
    }

    String[] nums = new String[]{"I","V","X","L","C","D","M"};

    public int romanToInt(String s, String pre, int value) {
        String ss = s.substring(0,1);
        int t = map.get(s.substring(0,1));
        if(pre==null){
            if(s.length()>1){
                return romanToInt(s.substring(1), ss, t);
            }else{
                return t;
            }
        }else{
            if(map.get(pre) >= t){
                value = value + t;
                if(s.length()>1){
                    return romanToInt(s.substring(1), ss, value);}
                else{
                    return value;
                }
            }else{
                value = value - map.get(pre) + t - map.get(pre);
                if(s.length()>1){
                    return romanToInt(s.substring(1), ss, value);
                }else{
                    return value;
                }
            }
        }
    }
}
