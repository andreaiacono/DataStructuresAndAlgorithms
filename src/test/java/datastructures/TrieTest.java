package datastructures;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TrieTest {


    @Test
    public void testInsert() {
        Trie trie = new Trie();
        trie.addWord("abc");
        assertTrue(trie.isPresent("abc"));
        assertFalse(trie.isPresent("abd"));
        assertFalse(trie.isPresent("ab"));
        trie.addWord("abd");
        assertTrue(trie.isPresent("abc"));
        assertTrue(trie.isPresent("abd"));
        assertFalse(trie.isPresent("ab"));
        assertFalse(trie.isPresent("abde"));
    }
}