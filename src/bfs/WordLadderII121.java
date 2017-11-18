package bfs;

import java.util.*;

/**
 * Created by zhizha on 11/4/17.
 */
public class WordLadderII121 {

    public static void main(String[] arg){
        Set<String> dict = new HashSet<>();

        WordLadderII121 wordLadderII121 = new WordLadderII121();

        String[] arr = new String[]{"si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"};

        List<String> list = Arrays.asList(arr);
        wordLadderII121.findLadders("qa","sq", new HashSet<String>(list));
    }
    /*
    * @param start: a string
    * @param end: a string
    * @param dict: a set of string
    * @return: a list of lists of string
    */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        Map<String, Integer> level = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        int i = 1;
        List<String> frontier = new ArrayList<>();
        frontier.add(start);
        level.put(start, 0);
        while (!frontier.isEmpty()) {
            List<String> next = new ArrayList<>();
            inner:
            for (String s : frontier) {
                if (isSimilar(s, end)) {
                    tmp.add(s);
                    break;
                }
                List<String> ss = getNextWords(s, dict);
                for (String v : ss) {
                    if (!level.containsKey(v)) {
                        level.put(v, i);
                        parent.put(v, s);
                        next.add(v);
                    }
                }
            }

            if (tmp.size() > 0) {
                break;
            }

            frontier = next;
            i++;
        }

        tmp = new ArrayList<>();
        tmp.add(start);
        dfs(dict, start, end, res, tmp, 1, i, new HashSet<>());

        return res;

    }

    private void dfs(Set<String> dict, String start, String end, List<List<String>> res, List<String> tmp, int len, int sp, Set<String> parent){
        if(len == sp){
            if(isSimilar(start, end)){
                tmp.add(end);
                res.add(new ArrayList<>(tmp));
                tmp.remove(tmp.size()-1);
            }
            return;
        }else{
            List<String> ss = getNextWords(start, dict);
            for(String s : ss){
                if(!parent.contains(s)){
                    parent.add(s);
                    tmp.add(s);
                    dfs(dict, s, end, res, tmp, len+1, sp, parent);
                    parent.remove(s);
                    tmp.remove(tmp.size()-1);
                }
            }
        }

    }

    String[] arr = null;

    // replace character of a string at given index to a given character
    // return a new string
    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }

    // get connections with given word.
    // for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}
    // it will return ['hit', 'hog']
    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }


    private boolean isSimilar(String s, String ss) {

            int diff = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ss.charAt(i)) {
                    diff++;
                }
            }

            return diff == 1;
        }



}
