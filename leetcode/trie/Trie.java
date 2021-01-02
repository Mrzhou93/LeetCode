package leetcode.trie;

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Trie {
    private boolean isEnd;
    private Trie[] tries = new Trie[26];

    /** Initialize your data structure here. */
    public Trie() {
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        Trie node = this;
        for (int i = 0; i < chars.length; i++){
            char c = chars[i];
            if (node.tries[c - 'a'] == null){
                node.tries[c - 'a'] = new Trie();
            }
            node = node.tries[c - 'a'];

            if (i == chars.length - 1){
                node.isEnd = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        Trie node = this;
        for (int i = 0; i < chars.length; i++){
            char c = chars[i];
            if (node.tries[c - 'a'] != null){
                node = node.tries[c - 'a'];
            } else {
                return false;
            }
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        Trie node = this;
        for (int i = 0; i < chars.length; i++){
            char c = chars[i];
            if (node.tries[c - 'a'] != null){
                node = node.tries[c - 'a'];
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));     // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 true
    }
}
