package interviewbit;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * https://www.interviewbit.com/problems/word-break-ii/
 */
public class WordBreakII {

    @Test
    public void test() {

        ArrayList<String> dict = new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        ArrayList<String> result = new ArrayList<>(Arrays.asList("cat sand dog", "cats and dog"));
        assertEquals(result, wordBreak("catsanddog", dict));

    }

    Map<String, Integer> cache = new HashMap<>();
    List<String> partials = new ArrayList<>();
//
//    public ArrayList<String> wordBreak(String a, ArrayList<String> b) {
//        ArrayList<String> result = new ArrayList<>();
//        wordBreak(a, b, result);
//        Collections.sort(result);
//        return result;
//    }
//
//    public void wordBreak(String a, ArrayList<String> b, ArrayList<String> result) {
//        if (a.equals("")) {
//            String string = "";
//            for (int i = 0; i < partials.size(); i++) {
//                string += partials.get(i) + " ";
//            }
//            result.add(string.substring(0, string.length() - 1));
//            return;
//        }
//
//        for (int i = 0; i < a.length() + 1; i++) {
//            String substring = a.substring(0, i);
//            if (b.contains(substring)) {
//                partials.add(substring);
//                wordBreak(a.substring(i), b, result);
//                partials.remove(substring);
//            }
//        }
//    }

    public ArrayList<String> wordBreak(String a, ArrayList<String> b) {
        return wordBreak(0, a, b);
    }

    ArrayList<String> wordBreak(int index, String s, ArrayList<String> dict) {
        ArrayList<String> sentences = new ArrayList<>();
        String sub = s.substring(index);
        if (dict.contains(sub)) {
            sentences.add(sub);
            return sentences;
        }

        for (int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i + 1);
            if (dict.contains(substring)) {
                ArrayList<String> ret = wordBreak(i + 1, s, dict);
                for (String sentence : ret) {
                    sentences.add(substring + " " + sentence);
                }
            }
        }
        return sentences;
    }
}
