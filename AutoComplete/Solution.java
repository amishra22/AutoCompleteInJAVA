package main.java;

/**
 * Created by Abhinav on 10-03-2017.
 */
public class Solution {

    public static void main(String[] args) {
        String[] input = {"I am", "Who is president of US", "Who is president of India", "I am a good boy", "I am a good girl",
                "What is Java", "What is Ajax", "What is the value of infinity", "I L U", ""};

        Trie trie = new Trie();

        // preprocess
        for(String str : input) {
            trie.init(str);
        }

        System.out.println("Now searching");

        String test = "What is";
        System.out.println("The sentences starting with " + "'" + test + "' is ");

        System.out.println(trie.getCompleteSentences(test));
    }
}
