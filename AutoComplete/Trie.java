package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abhinav on 10-03-2017.
 */
public class Trie {

    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public void init(String prefix) {
        TrieNode curr = root;

        for(int i=0 ; i<prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(curr.children[ch] == null) {
                curr.children[ch] = new TrieNode();
            }
            curr = curr.children[ch];
        }
        curr.isSentene = true;
    }

    public List<String> getCompleteSentences(String prefix) {
        // get the prefix node i.e. the node till which point the prefix matches
        // after which we will traverse whole trie to find all sentences that have same prefix

        TrieNode child = getPrefixEndingNode(prefix);
        // if no such prefix exist .. you cannot find anything return null
        if(child == null) return null;

        List<String> completions = new ArrayList<>();
        getAll(prefix, child, completions);
        return completions;
    }

    private void getAll(String prefix, TrieNode child, List<String> completions) {
        // base case .. if node is null return
        if(child == null) return;

        // if valid sentence is found add it to result
        if(child.isSentene == true) {
            completions.add(prefix);
        }
        // traverse the childrens down to find other such sentences
        for (int i=0; i<child.children.length; i++) {
            getAll(prefix + Character.valueOf((char)i), child.children[i], completions);
        }
    }

    private TrieNode getPrefixEndingNode(String prefix) {
        TrieNode curr = root;
        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(curr.children[ch] == null){
                return  null;
            }
            curr = curr.children[ch];
        }
        return curr;
    }
}
