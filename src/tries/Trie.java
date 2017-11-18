package tries;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhizha on 10/28/17.
 */


public class Trie {
    public static void main(String[] arg) {
        Trie trie = new Trie();
/*        trie.insert("hello");
        trie.search("hell");
        trie.search("helloa");
        trie.search("hello");
        trie.startsWith("hell");
        trie.startsWith("helloa");
        trie.startsWith("hello");*/

        trie.insert("aaa");
        trie.insert("a");
        System.out.println(trie.search("a"));
        System.out.println(trie.startsWith("aaa"));

    }

    private static class TrieNode {
        // Initialize your data structure here.
        Map<Character, TrieNode> children;
        boolean endOfWord = false;

        public TrieNode(String s) {
            if (children == null) {
                children = new HashMap<>();
            }
            if (s == null || s.equals("")) {
                endOfWord = true;
            } else {
                children.put(s.charAt(0), new TrieNode(s.substring(1)));
            }

        }
    }

    private TrieNode root;

    public Trie() {
        // do intialization if necessary
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
        Map<Character, TrieNode> children;
        if (root == null) {
            root = new TrieNode(word);
        } else {
            if (!root.children.containsKey(word.charAt(0))) {
                root.children.put(word.charAt(0), new TrieNode(word.substring(1)));
            } else {
                TrieNode tmpRoot = root;
                for (int i = 0; i < word.length(); i++) {
                    if (tmpRoot.children.containsKey(word.charAt(i))) {
                        tmpRoot = tmpRoot.children.get(word.charAt(i));
                        if (i + 1 == word.length()) {
                            tmpRoot.endOfWord = true;
                        }
                    } else {
                        tmpRoot.children.put(word.charAt(i), new TrieNode(word.substring(i + 1)));
                        break;
                    }
                }
            }
        }

    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here
        TrieNode tempRoot = root;
        if (root == null) {
            return false;
        }
        int i = 0;
        while (i < word.length()) {

            if (tempRoot.children != null && tempRoot.children.containsKey(word.charAt(i))) {
                tempRoot = tempRoot.children.get(word.charAt(i++));
            } else {
                return false;
            }
        }
        return tempRoot.endOfWord;
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here
        TrieNode tempRoot = root;
        if (root == null) {
            return false;
        }
        int i = 0;
        while (i < prefix.length()) {
            if (tempRoot.children != null && tempRoot.children.containsKey(prefix.charAt(i))) {
                tempRoot = tempRoot.children.get(prefix.charAt(i++));
            } else {
                return false;
            }
        }
        return true;
    }
}

