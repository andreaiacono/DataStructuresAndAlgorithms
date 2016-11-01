package misc;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * TopCoder: https://community.topcoder.com/stat?c=problem_statement&pm=3935&rd=6532
 */
public class SmartWordToy {

    class Word {
        final String word;
        final int steps;
        Word parent;

        public Word(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }

        public List<Word> getConnectedWords() {
            List<Word> words = new ArrayList<>();
            for (int j = 0; j < word.length(); j++) {
                StringBuilder builder = new StringBuilder(word);
                builder.setCharAt(j, builder.charAt(j) == 'z' ? 'a' : (char) (builder.charAt(j) + 1));
                String connectedWord = builder.toString();
                words.add(new Word(connectedWord, steps + 1));

                builder = new StringBuilder(word);
                builder.setCharAt(j, builder.charAt(j) == 'a' ? 'z' : (char) (builder.charAt(j) - 1));
                connectedWord = builder.toString();
                words.add(new Word(connectedWord, steps + 1));
            }
            return words;
        }

        @Override
        public String toString() {
            return word;
        }
    }

    boolean isValid(String[] forbid, String word) {
        for (int j = 0; j < forbid.length; j++) {

            String[] forbiddenLetters = forbid[j].split(" ");
            boolean areAllForbidden = true;
            for (int i = 0; i < 4; i++) {
                if (forbiddenLetters[i].indexOf(word.charAt(i)) < 0) {
                    areAllForbidden = false;
                }
            }
            if (areAllForbidden) {
                return false;
            }
        }

        return true;
    }

    private Set<String> initForbidden(String[] forbiddenChars) {
        Set<String>forbidden = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    for (int l = 0; l < 26; l++) {
                        String word = new StringBuilder()
                                .append((char) ('a' + i))
                                .append((char) ('a' + j))
                                .append((char) ('a' + k))
                                .append((char) ('a' + l))
                                .toString();
                        if (!isValid(forbiddenChars, word)) {
                            forbidden.add(word);
                        }
                    }
                }
            }
        }
        return forbidden;
    }


    @Test
    public void test() {
        assertEquals(8, minPresses("aaaa", "zzzz", new String[]{"a a a z", "a a z a", "a z a a", "z a a a", "a z z z", "z a z z", "z z a z", "z z z a"}));
        assertEquals(4, minPresses("aaaa", "bbbb", new String[]{}));
        assertEquals(6, minPresses("aaaa", "zzzz", new String[]{"cdefghijklmnopqrstuvwxyz a a a", "a cdefghijklmnopqrstuvwxyz a a", "a a cdefghijklmnopqrstuvwxyz a", "a a a cdefghijklmnopqrstuvwxyz"}));
        assertEquals(-1, minPresses("aaaa", "bbbb", new String[]{"b b b b"}));
        assertEquals(50, minPresses("aaaa", "mmnn", new String[]{}));
    }

    public int minPresses(String start, String finish, String[] forbid) {
        Set<String> visited = new HashSet<>();
        Set<String> forbidden = initForbidden(forbid);
        Deque<Word> queue = new ArrayDeque<>();
        Word startingWord = new Word(start, 0);
        queue.add(startingWord);
        visited.add(startingWord.word);
        while (!queue.isEmpty()) {

            Word currentWord = queue.poll();
            if (currentWord.word.equals(finish)) {
                int value = currentWord.steps;
                do {
                    System.out.print(currentWord + " -> ");
                    currentWord = currentWord.parent;
                }
                while (currentWord.parent != null);
                System.out.print(currentWord + "\n");
                return value;
            }

            for (Word connectedWord : currentWord.getConnectedWords()) {
                if (!visited.contains(connectedWord.word) && !forbidden.contains(connectedWord.word)) {
                    connectedWord.parent = currentWord;
                    queue.add(connectedWord);
                    visited.add(connectedWord.word);
                }
            }
        }
        return -1;
    }
}
