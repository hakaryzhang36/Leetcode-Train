// Leetcode 208-implement-trie-prefix-tree
class Trie {
    // 根节点没有value，只有child
    char value;
    boolean isWord;
    Trie[] child;   // 子节点存在，说明后续可以继续搜索 word[1, n]

    public Trie() {
        isWord = false;
        child = new Trie[26];
    }
    
    public void insert(String word) {
        if (word.length() > 0) {
            char ch = word.charAt(0);
            if (child[ch - 'a'] == null) {
                child[ch - 'a'] = new Trie();
                child[ch - 'a'].value = ch;
            }
            child[word.charAt(0) - 'a'].insert(word.substring(1, word.length()));
        }
        else {
            isWord = true;
        }
    }
    
    public boolean search(String word) {
        if (word.length() == 0) {
            return isWord;
        }
        else if (child[word.charAt(0) - 'a'] != null) {
            return child[word.charAt(0) - 'a'].search(word.substring(1, word.length()));
        }
        else {
            return false;
        }
    }
    
    public boolean startsWith(String prefix) {
        if (prefix.length() == 1) {
            return child[prefix.charAt(0) - 'a'] != null;
        }
        else if (child[prefix.charAt(0) - 'a'] != null) {
            return child[prefix.charAt(0) - 'a'].startsWith(prefix.substring(1, prefix.length()));
        }
        else {
            return false;
        }
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */