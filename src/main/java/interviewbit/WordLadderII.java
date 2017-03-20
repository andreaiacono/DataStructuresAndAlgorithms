package interviewbit;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class WordLadderII {


    @Test
    public void test() {
        ArrayList<String> dict = new ArrayList(Arrays.asList("baba", "abba", "aaba", "bbbb", "abaa", "abab", "aaab", "abba", "abba", "abba", "bbba", "aaab", "abaa", "baba", "baaa", "bbaa", "babb"));
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> path = new ArrayList(Arrays.asList("bbaa", "baaa", "baba", "babb"));
        result.add(path);
        path = new ArrayList(Arrays.asList("bbaa", "bbba", "baba", "babb"));
        result.add(path);
        path = new ArrayList(Arrays.asList("bbaa", "bbba", "bbbb", "babb"));
        result.add(path);
        assertEquals(result, findLadders("bbaa", "babb", dict));
    }


    public ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dict) {

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        if (start.equals(end)) {
            ArrayList<String> path = new ArrayList<>();
            path.add(end);
            result.add(path);
            return result;
        }

        int minLength = Integer.MAX_VALUE;
        ArrayList<String> path = bfs(start, end, dict, minLength, result);
        result.add(path);
        while (true) {
            path = bfs(start, end, dict, minLength, result);
            if (path.size() == 0) {
                break;
            }
            result.add(path);
        }
        return result;
    }

    public ArrayList<String> bfs(String start, String end, ArrayList<String> dict, int minLength, ArrayList<ArrayList<String>> foundPaths) {

        ArrayList<String> path = new ArrayList<>();

        Set<String> visited = new HashSet<>();
        Deque<Word> queue = new ArrayDeque<>();
        Word startWord = new Word(start, 1, null);
        visited.add(start);
        queue.add(startWord);

        while (!queue.isEmpty()) {
            Word current = queue.poll();
            if (current.distance > minLength) {
                return path;
            }
            for (int i = 0; i < current.word.length(); i++) {
                for (int j = 0; j < 26; j++) {
                    StringBuilder wordBuilder = new StringBuilder(current.word);
                    wordBuilder.setCharAt(i, (char) (97 + j));
                    Word newWord = new Word(wordBuilder.toString(), current.distance + 1, current);
                    if (newWord.word.equals(end)) {
////                        ArrayList<String> newPath = getPath(newWord);
//                        if (foundPaths.contains(newPath)) {
//                            continue;
//                        }
//                        return newPath;
                    }
                    if (dict.contains(newWord.word) && !visited.contains(newWord.word)) {
                        queue.add(newWord);
                        visited.add(newWord.word);
                    }
                }
            }
        }
        return path;
    }

    class Word {
        String word;
        int distance;
        List<Word> parents = new ArrayList<>();

        Word(String word, int distance, Word parent) {
            this.word = word;
            this.distance = distance;
            this.parents.add(parent);
        }
    }

//    ArrayList<String> getPath(Word newWord) {
//        ArrayList<String> path = new ArrayList<>();
//        Word current = newWord;
//        while (current.parents != null) {
//            path.add(current.word);
////            current = current.parents;
//        }
//        path.add(current.word);
//        Collections.reverse(path);
//        return path;
//    }


}
