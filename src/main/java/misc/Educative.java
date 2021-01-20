package misc;

import org.junit.Test;
import tree.Node;
import tree.Printer;

import java.util.*;

import static org.junit.Assert.*;

// https://www.educative.io/blog/google-coding-interview-questions
public class Educative {

    @Test
    public void testfindClosest() {
        List<Integer> arr = List.of(1, 2, 3, 4, 7);
        List<Integer> exp = List.of(1, 2, 3, 4);
        assertEquals(exp, findClosest(arr, 4, 3));
        arr = List.of(2, 4, 5, 6, 9);
        exp = List.of(4, 5, 6);
        assertEquals(exp, findClosest(arr, 3, 6));
    }

    //    Given a sorted number array and two integers ‘K’ and ‘X’, find ‘K’ closest numbers to ‘X’ in the array.
    //    Return the numbers in the sorted order. ‘X’ is not necessarily present in the array.
    List<Integer> findClosest(List<Integer> values, int k, int x) {
        int kIdx = binarySearch(values, x);
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparing(Math::abs));
        if (values.get(kIdx) == x) {
            queue.add(0);
        }
        for (int i = 1; i <= k; i++) {
            if (kIdx - i >= 0) {
                queue.add(x - values.get(kIdx - i));
            }
            if (kIdx + i < values.size()) {
                queue.add(x - values.get(kIdx + i));
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(x - queue.poll());
        }
        Collections.sort(result, Comparator.naturalOrder());
        return result;
    }

    int binarySearch(List<Integer> values, int n) {

        int left = 0;
        int right = values.size() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (values.get(mid) == n) {
                return mid;
            } else if (values.get(mid) < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }


    @Test
    public void testDeleteNode() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;

        deleteNode(n1, 2);
        assertEquals(List.of(1, 3), getList(n1));
        deleteNode(n1, 3);
        assertEquals(List.of(1), getList(n1));
        assertEquals(List.of(), getList(deleteNode(n1, 1)));
    }

    ListNode deleteNode(ListNode head, int val) {
        // todo: basic checks as null, one node list

        if (head.val == val) {
            return head.next;
        }
        ListNode current = head;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
                return head;
            }
            current = current.next;
        }
        return head;
    }

    List<Integer> getList(ListNode head) {
        List<Integer> result = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            result.add(current.val);
            current = current.next;
        }
        return result;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }


    @Test
    public void testMirrorTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(10);

        Printer printer = new Printer();
        mirrorTree(root);
        printer.printNode(root);
    }

    void mirrorTree(Node current) {

        if (current == null) {
            return;
        }

        mirrorTree(current.left);
        mirrorTree(current.right);
        Node tmp = current.left;
        current.left = current.right;
        current.right = tmp;
    }

    @Test
    public void testCheckTrees() {

        /* Construct below tree
	          1
	       /     \
	      2       3
	     / \     / \
	    4   5   6   7   */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(10);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.right.left = new Node(6);
        root2.right.right = new Node(7);
        root2.right.right.left = new Node(10);


        assertTrue(checkTrees(root, root));
        assertTrue(checkTrees(root, root2));
        root2.right.left = new Node(3);
        assertFalse(checkTrees(root, root2));
        root2.right.left = new Node(6);
        assertTrue(checkTrees(root, root2));
        root2.right.left = null;
        assertFalse(checkTrees(root, root2));
    }

    boolean checkTrees(Node current1, Node current2) {
        // base case
        if (current1 == null || current2 == null) {
            return current1 == current2;
        }

        return current1.data == current2.data &&
                checkTrees(current1.left, current2.left) &&
                checkTrees(current1.right, current2.right);
    }


    @Test
    public void testIsSegmented() {
        Set<String> words = new HashSet<>() {{
            add("kin");
            add("kind");
            add("dare");
            add("are");
            add("a");
            add("aa");
            add("aaa");
            add("aaaa");
            add("aaaaa");
            add("aaaaaa");
            add("aaaaaa");
            add("aaaaaaa");
            add("aaaaaaaa");
            add("aaaaaaaaa");
            add("aaaaaaaaaa");
            add("aaaaaaaaaaa");
        }};

        assertTrue(isSegmented("kindare", words));
        assertFalse(isSegmented("kindared", words));
        assertEquals(2, countSegmented("kindare", words, new HashMap<>()));
        assertEquals(0, countSegmented("kindares", words, new HashMap<>()));

        assertTrue(isSegmented("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", words));
        assertEquals(33791920, countSegmented("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", words, new HashMap<>()));

    }

    final int MAX_LENGTH = 4;

    boolean isSegmented(String s, Set<String> words) {

        // base case
        if (s.length() == 0) {
            return true;
        }

        // recursive case
        boolean result = false;
        for (int i = 1; i < MAX_LENGTH && i < s.length(); i++) {
            String partial = s.substring(0, i + 1);
            if (words.contains(partial)) {
                result = result || isSegmented(s.substring(i + 1), words);
            }
        }
        return result;
    }

    int countSegmented(String s, Set<String> words, Map<String, Integer> cache) {

        // base case
        if (s.length() == 0) {
            return 1;
        }

        if (cache.containsKey(s)) {
            return cache.get(s);
        }

        // recursive case
        int result = 0;
        for (int i = 1; i < MAX_LENGTH && i < s.length(); i++) {
            String partial = s.substring(0, i + 1);
            if (words.contains(partial)) {
                result += countSegmented(s.substring(i + 1), words, cache);
            }
        }
        cache.put(s, result);
        return result;
    }

    @Test
    public void countPalindromeTest() {
        String s = "acabaca";
        assertEquals(5, countPalindromes(s));
    }

    // abaca
    // 2: aba, aca
    int countPalindromes(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                System.out.println(s.substring(i, j));
                if (isPalindrome(s.substring(i, j))) {
                    count++;
                }
            }
        }

        return count;
    }


    boolean isPalindrome(String s) {
        if (s.length() < 2) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }


    @Test
    public void largestSumSubarrayTest() {
        int[] vals = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertEquals(6, largestSumSubarray(vals));
        System.out.println(Arrays.toString(largestSumSubarrayValues(vals)));
        assertTrue(Arrays.equals(new int[]{4, -1, 2, 1}, largestSumSubarrayValues(vals)));
    }

    int largestSumSubarray(int[] vals) {

        int partialMax = vals[0];
        int max = vals[0];
        int maxNeg = Integer.MIN_VALUE;

        for (int i = 1; i < vals.length; i++) {
            partialMax += vals[i];
            if (partialMax < 0) {
                partialMax = 0;
            }
            if (max < partialMax) {
                max = partialMax;
            }
            maxNeg = Math.max(maxNeg, vals[i]);
        }

        if (maxNeg < 0) {
            return maxNeg;
        }

        return max;
    }

    int[] largestSumSubarrayValues(int[] vals) {

        int partialMax = vals[0];
        int max = vals[0];
        int maxLeft = 0;
        int maxRight = 0;

        for (int i = 1; i < vals.length; i++) {
            partialMax += vals[i];
            if (partialMax < 0) {
                partialMax = 0;
                maxLeft = i + 1;
            }
            if (max < partialMax) {
                max = partialMax;
                maxRight = i;
            }
        }

        return Arrays.copyOfRange(vals, maxLeft, maxRight + 1);
    }

    @Test
    public void isValidTest() {
        assertTrue(isValid("4.231"));
        assertTrue(isValid("231"));
        assertTrue(isValid("0.231"));
        assertTrue(isValid(".231"));
        assertFalse(isValid("1.4.231"));
        assertFalse(isValid("1.4."));
        assertFalse(isValid("1."));
    }

    boolean isValid(String s) {

        boolean hasDot = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '.') {
                if (hasDot || i == s.length() - 1) {
                    return false;
                } else {
                    hasDot = true;
                }
            }
            if (c != '.' && (c < '0' || c > '9')) {
                return false;
            }
        }
        return true;
    }


    @Test
    public void balancedParsTest() {
        System.out.println(balanced(5, "", 0, 0).toString().replace(", ", "\n"));
        List<String> res = balanced(3, "", 0, 0);
        List<String> exp = List.of("((()))", "(()())", "(())()", "()(())", "()()()");
        assertEquals(exp.size(), res.size());
        assertEquals(exp, res);
    }

    // n=3
    // balanced(n, "", 0, 0)
    List<String> balanced(int n, String partial, int open, int close) {
        if (open == n && close == n) {
            return List.of(partial);
        }
        List<String> result = new ArrayList<>();
        if (open < n) {
            result.addAll(balanced(n, partial + "(", open + 1, close));
        }
        if (close < open) {
            result.addAll(balanced(n, partial + ")", open, close + 1));
        }
        return result;
    }

    @Test
    public void cacheTest() {
        Cache cache = new Cache(3);
        assertEquals(-1, cache.get());
        assertEquals(-1, cache.get());
        assertEquals(0, cache.dataSize());
        cache.put(10);
        assertEquals(1, cache.dataSize());
        assertEquals(10, cache.get());
        assertEquals(0, cache.dataSize());
        cache.put(20);
        cache.put(30);
        cache.put(40);
        cache.put(50);
        assertEquals(3, cache.dataSize());
        assertEquals(30, cache.get());
        assertEquals(40, cache.get());
        cache.put(60);
        cache.put(70);
        assertEquals(3, cache.dataSize());
        cache.put(80);
        assertEquals(3, cache.dataSize());
        assertEquals(60, cache.get());
        assertEquals(70, cache.get());
        assertEquals(80, cache.get());
        assertEquals(-1, cache.get());
    }

    class Cache {
        int cacheSize;
        //        Deque<Integer> data = new ArrayDeque<>();
        LinkedList<Integer> data = new LinkedList<>();
        int head = 0;
        int tail = 0;

        public Cache(int size) {
            this.cacheSize = size;
//            data = new int[size];
        }

        boolean isEmpty() {
//            return head % cacheSize == tail % cacheSize;
            return data.isEmpty();
        }

        public int dataSize() {
//            return Math.abs((head % cacheSize - tail % cacheSize));
            return data.size();
        }

        void put(int value) {
            data.addLast(value);
            if (data.size() > cacheSize) {
                data.removeFirst();
            }

//            data[head % cacheSize] = value;
//            head++;
//            tail++;
        }

        int get() {
            if (isEmpty()) {
                return -1;
            }
            return data.removeFirst();
//            int value = data[tail % cacheSize];
//            tail++;
//            return value;
        }
    }


    @Test
    public void lowHighIndexTest() {
        int[] values = new int[]{5, 7, 7, 8, 8, 10};
        int[] result = lowHighIndex(values, 8);
        int[] exp = new int[]{3, 4};
        assertTrue(Arrays.equals(exp, result));

        values = new int[]{5, 7, 7, 8, 8, 10};
        result = lowHighIndex(values, 7);
        exp = new int[]{1, 2};
        assertTrue(Arrays.equals(exp, result));

        values = new int[]{5, 7, 7, 8, 8, 10};
        result = lowHighIndex(values, 5);
        exp = new int[]{0, 0};
        assertTrue(Arrays.equals(exp, result));

        values = new int[]{5, 7, 7, 8, 8, 10};
        result = lowHighIndex(values, 3);
        exp = new int[]{-1, -1};
        assertTrue(Arrays.equals(exp, result));
    }

    int[] lowHighIndex(int[] values, int target) {
        int index = binarySearch(values, target);
        if (index == -1) {
            return new int[]{-1, -1};
        }

        int left = index;
        while (left >= 0 && values[left] == target) {
            left--;
        }
        int right = index;
        while (right < values.length && values[right] == target) {
            right++;
        }
        return new int[]{left + 1, right - 1};
    }

    int binarySearch(int[] values, int target) {
        int left = 0;
        int right = values.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (values[mid] == target) {
                return mid;
            } else if (values[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


    @Test
    public void test() {
        List<Interval> vals = List.of(
                new Interval(1, 3),
                new Interval(2, 6),
                new Interval(8, 10),
                new Interval(15, 18)
        );

        List<Interval> exp = List.of(
                new Interval(1, 6),
                new Interval(8, 10),
                new Interval(15, 18)
        );

        assertEquals(exp, mergeIntervals(vals));

    }

    List<Interval> mergeIntervals(List<Interval> intervals) {

        List<Interval> result = new ArrayList<>();

        for (int i = 0; i < intervals.size() - 1; i++) {
            Interval current = intervals.get(i);
            int maxEnd = 0;
            int nextIndex = i + 1;
            Interval next = intervals.get(nextIndex);
            while (current.end >= next.start) {
                maxEnd = Math.max(maxEnd, next.end);
                nextIndex++;
                next = intervals.get(nextIndex);
            }
            if (nextIndex == i + 1) {
                result.add(current);
                if (i == intervals.size() - 2) {
                    result.add(next);
                }
            } else {
                result.add(new Interval(current.start, maxEnd));
                i++;
            }
        }
        return result;
    }

    class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean equals(Object o) {
            // check instance
            Interval other = (Interval) o;
            return other.start == this.start && other.end == this.end;
        }

        public String toString() {
            return "(" + start + "," + end + ")";
        }
        // equals
    }

    @Test
    public void pathToSumTest() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(10);

        Printer printer = new Printer();
        printer.printNode(root);

        assertTrue(pathToSum(root, 21, 0));
        assertTrue(pathToSum(root, 7, 0));
        assertTrue(pathToSum(root, 10, 0));
        assertFalse(pathToSum(root, 0, 0));
        assertFalse(pathToSum(root, 1, 0));
        assertFalse(pathToSum(root, 3, 0));
        assertFalse(pathToSum(root, 4, 0));
        assertFalse(pathToSum(root, 11, 0));
    }


    boolean pathToSum(Node current, int target, int partialSum) {
        System.out.println("current: " + (current != null ? current.data : "NULL") + " partial:"  +partialSum);
        partialSum += current.data;
        if (current.left == null && current.right == null) {
            return partialSum == target;
        }

        boolean left = current.left != null ? pathToSum(current.left, target, partialSum) : false;
        boolean right = current.right != null ? pathToSum(current.right, target, partialSum) : false;

        return left || right;
    }

    @Test
    public void reverseListTest() {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(4);
        n1.next.next.next.next = new ListNode(5);

        System.out.println(getList(n1));
        List<Integer> exp = List.of(5, 4, 3, 2, 1);

        System.out.println(getList(reverse(n1)));
        assertTrue(exp.toString().equals(getList(reverse(n1)).toString()));
    }

    ListNode reverse(ListNode root) {

        ListNode natural = root;
        ListNode reversed = new ListNode(root.val);
        natural = natural.next;
        while (natural != null) {
            ListNode node = new ListNode(natural.val);
            node.next = reversed;
            reversed = node;
            natural = natural.next;
        }

         return reversed;
    }
}