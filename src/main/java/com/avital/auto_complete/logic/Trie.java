package com.avital.auto_complete.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {

    class TrieNode{
        private boolean isWord;
        private HashMap<Character,TrieNode> children;
        private char c;

        public TrieNode(char c) {
            this.c = c;
            children = new HashMap<>();
        }

        public TrieNode() {
            children = new HashMap<>();
        }

        public void insert(String word) {
            if (word == null || word.isEmpty())
                return;
            char firstChar = word.charAt(0);
            TrieNode child = children.get(firstChar);
            if (child == null) {
                child = new TrieNode(firstChar);
                children.put(firstChar, child);
            }

            if (word.length() > 1)
                child.insert(word.substring(1));
            else
                child.isWord = true;
        }



    }

    private TrieNode root;

    public Trie(List<String> words) {
        root = new TrieNode();
        for (String word : words)
            root.insert(word);
    }

    public boolean find(String prefix, boolean exact) {
        TrieNode lastNode = root;
        for (char c : prefix.toCharArray()) {
            lastNode = lastNode.children.get(c);
            if (lastNode == null)
                return false;
        }
        return !exact || lastNode.isWord;
    }

    public boolean find(String prefix) {
        return find(prefix, false);
    }

    public void suggestHelper(TrieNode root, List<String> list, StringBuffer curr) {
        if (root.isWord) {
            list.add(curr.toString());
        }

        if (root.children == null || root.children.isEmpty())
            return;

        for (TrieNode child : root.children.values()) {
            suggestHelper(child, list, curr.append(child.c));
            curr.setLength(curr.length() - 1);
        }
    }

    public List<String> suggest(String prefix) {
        // whre to put - tp lowwer case
        List<String> list = new ArrayList<>();
        TrieNode lastNode = root;
        StringBuffer curr = new StringBuffer();
        for (char c : prefix.toCharArray()) {
            lastNode = lastNode.children.get(c);
            if (lastNode == null)
                return list;
            curr.append(c);
        }
        suggestHelper(lastNode, list, curr);
        return list;
    }

}



