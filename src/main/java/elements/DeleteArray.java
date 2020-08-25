package elements;

import java.util.Arrays;

public class DeleteArray {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5, 5, 7, 11, 11, 11, 13};

        deleteDuplicates(arr);
    }

    public static void deleteDuplicates(int[] arr) {

        System.out.println(Arrays.toString(arr));

        int writeIndex = 1;

        for (int i = 1; i < arr.length; i++) {

            while (writeIndex < arr.length && arr[i - 1] == arr[writeIndex]) {
                writeIndex++;
            }
            arr[i] = writeIndex < arr.length ? arr[writeIndex] : 0;
        }

// wrong book solution
//        int writelndex = 1;
//        for (int i = 1; i < vals.length; ++i) {
//            if (vals[writelndex-1] != vals[i]) {
//                vals[writelndex++] = vals[i];
//            }
//        }

        System.out.println(Arrays.toString(arr));
    }
}
