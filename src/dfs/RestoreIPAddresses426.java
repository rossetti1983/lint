package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhizha on 10/14/17.
 */
public class RestoreIPAddresses426 {

    public static void main(String[] arg){
        RestoreIPAddresses426 restoreIPAddresses426 = new RestoreIPAddresses426();
        restoreIPAddresses426.restoreIpAddresses("25525511135");
    }

    /*
 * @param s: the IP string
 * @return: All possible valid IP addresses
 */
    public List<String> restoreIpAddresses(String s) {
        // write your code here
        List<String> re = new ArrayList<>();
        if(s==null || s.length() < 4 || s.length() > 12){
            return re;
        }

        ip(s, re, 4, "");
        return re;
    }

    private void ip(String s, List<String> re, int i, String bs) {
        if(s.length() < i || s.length() > 3*i){
            return;
        }else if(s.length()==0 && i == 0){
            re.add(bs);
            return;
        }else{
            String p1 = s.substring(0,1);
            String nbs = bs.equals("") ? p1 : bs + "." + p1;
            ip(s.substring(1), re, i-1, nbs);

            if(s.length() > 1){
                String p2 = s.substring(0,2);
                if(p2.charAt(0) == '0'){
                    return;
                }
                String nbs2 = bs.equals("") ? p2 : bs + "." + p2;
                ip(s.substring(2), re, i-1, nbs2);
            }

            if(s.length() > 2){
                String p2 = s.substring(0,3);
                if(p2.charAt(0) == '0'){
                    return;
                }

                if(Integer.valueOf(p2) > 255){
                    return;
                }

                String nbs2 = bs.equals("") ? p2 : bs + "." + p2;
                ip(s.substring(3), re, i-1, nbs2);
            }
        }
    }
}
