package pramp;

import datastructures.Heap;

public class MessSort {

    void messSortSlow(int[] a, int k) {

        for (int j=0; j<a.length; j++) {
            int index = j;//
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            // getting minimum between k values
            while (index < j + k && index < a.length) {
                if (a[index] < min) {
                    min = a[index];
                    minIndex = index;
                }
                index++;
            }

            if (minIndex > -1) {
                swap(a, j, minIndex);
            }
        }
    }

    void messSort(int[] a, int k) {

        Heap h = new Heap();
        for (int j=0; j<a.length - k; j++) {
            h.insert(a[j]);
            if (j>=k) {
                a[j-k] = (int) h.extractMin();
            }
        }

        for (int j=k; j>0; j--) {
            a[a.length - j] = (int) h.extractMin();
        }
    }

    void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
