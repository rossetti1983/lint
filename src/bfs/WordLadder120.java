package bfs;

import java.util.*;

/**
 * Created by zhizha on 11/5/17.
 */
public class WordLadder120 {

    public static void main(String[] arg) {
        Set<String> dict = new HashSet<>();

        WordLadder120 wordLadderII121 = new WordLadder120();

        String[] arr = new String[]{"a","b","c"};
        List<String> list = Arrays.asList(arr);
        wordLadderII121.ladderLength("a","c", new HashSet<>(list));

    }
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        if(start.equals(end)){
            return 1;
        }
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

        if(tmp.size()==0){
            return 0;
        }
        return i+1;

    }


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

    HashMap<String, Boolean> cache = new HashMap<>();
    private boolean isSimilar(String s, String ss) {
        if(cache.containsKey(s+","+ss)){
            return cache.get(s+","+ss);
        }else {
            int diff = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ss.charAt(i)) {
                    diff++;
                }
            }
            cache.put(s+","+ss, diff==1);
            return diff == 1;
        }
    }
}
