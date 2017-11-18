package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by zhizha on 8/27/17.
 */
public class StringsHomomorphism638 {

    public static void main(String[] arg){
        StringsHomomorphism638 stringsHomomorphism638 = new StringsHomomorphism638();
        stringsHomomorphism638.isIsomorphic("a`%ii,VEZQc_BSU%ObO5<sX81B/bOw+CNUd#Uav*P!Ax!#>hh,k#b/|>4ixFQZl+l!?bJjakbQbGglEb<g>Hf81m@A9GIvbd]qh?y__t+E(Iyv7zUEfZF{81VaM-0u?]tG=_fFR/XJ=X{-,oRpxE9u*VNYlM",
                                            "b`%ii-WE[Qc_BSV%OcO5<sX82B/cOw+CNVd#Vbv*P!Bx!#?hh-k#c/|?4ixFQ[l+l!?cJkbkcQcGhlEc<h?Hf82m@B9GIvcd]rh?y__t+E(Iyv7{VEf[F{82WbN/0u?]tG=_fFR/XJ=X{/-oRpxE9u*WNYlN");
    }

    /**
     * @param s a string
     * @param t a string
     * @return true if the characters in s can be replaced to get t or false
     */
    public boolean isIsomorphic(String s, String t) {
        // Write your code here
        if(s.length()!=t.length()){
            return false;
        }

        HashMap<Character, Integer> counterS = new HashMap<>();
        HashMap<Character, Integer> counterT = new HashMap<>();
        for(int i = 0 ; i < s.length(); i++){
            if(counterS.containsKey(s.charAt(i))){
                counterS.put(s.charAt(i), counterS.get(i)+1);
            }else{
                counterS.put(s.charAt(i), 1);
            }
        }
        for(int i = 0 ; i < t.length(); i++){
            if(counterT.containsKey(s.charAt(i))){
                counterT.put(s.charAt(i), counterT.get(i)+1);
            }else{
                counterT.put(s.charAt(i), 1);
            }
        }

        for(int i = 0 ; i < t.length(); i++){
            if(!counterS.get(s.charAt(i)).equals(counterT.get(t.charAt(i)))){
                return false;
            }
        }

        return true;


    }
}
