package main.java;

/**
 * Created by Abhinav on 10-03-2017.
 */
public class TrieNode {

    public TrieNode[] children;
    public boolean isSentene;

    public TrieNode() {
        this.children  = new TrieNode[256];
        this.isSentene = false;
    }
}
