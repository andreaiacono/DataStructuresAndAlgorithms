package interviewbit;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class WordLadderI {

    @Test
    public void test() {
        List<String> dict = Arrays.asList("hot","dot","dog","lot","log");
        assertEquals(5, ladderLength("hit", "cog", dict));

        dict = Arrays.asList("bb","ab");
        assertEquals(1, ladderLength("bb", "ab", dict));
    }

    class Word {
        String word;
        int distance;

        Word(String word, int distance) {
            this.word = word;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return word + '[' + distance + ']';
        }
    }

    public int ladderLength(String start, String end, List<String> dictV) {

        Set<String> visited = new HashSet<>();
        Deque<Word> queue = new ArrayDeque<>();
        Word startWord = new Word(start, 1);
        visited.add(start);
        queue.add(startWord);

        while (!queue.isEmpty()) {
            Word current = queue.poll();
            for (int i=0; i<current.word.length(); i++) {
                for (int j=0; j<26; j++) {
                    StringBuilder wordBuilder = new StringBuilder(current.word);
                    wordBuilder.setCharAt(i, (char)(97+j));
                    Word newWord = new Word(wordBuilder.toString(), current.distance+1);
                    if (newWord.word.equals(end)) {
                        return current.distance + 1;
                    }
                    if (dictV.contains(newWord.word) && !visited.contains(newWord.word)) {
                        queue.add(newWord);
                        visited.add(newWord.word);
                    }
                }
            }
        }
        return 0;
    }
}
