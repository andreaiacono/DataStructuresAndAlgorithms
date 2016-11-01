package sorting;

public class CountingSort {


    public static int[] countingSort(int a[], int max) {
        int[] counts = new int[max];
        int[] result = new int[a.length];

        // counts elements
        for (int val: a) {
            counts[val]++;
        }

        int readIndex = 0;
        int writeIndex = 0;

        // writes them in order into result
        while (readIndex < counts.length) {
            for (int j=0; j<counts[readIndex]; j++) {
                result[writeIndex++] = readIndex;
            }
            readIndex++;
        }

        return result;
    }
}
