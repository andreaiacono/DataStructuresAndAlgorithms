package interviewbit;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PrimeSum {

    @Test
    public void test() {
//        ArrayList<Integer> result = new ArrayList<Integer>() {{
//            add(3);
//            add(1048571);
//        }};
//        assertEquals(result, primesum(1048574));
//
//        result = new ArrayList<Integer>() {{
//            add(3);
//            add(7);
//        }};
//        assertEquals(result, primesum(10));
//
//        result = new ArrayList<Integer>() {{
//            add(2);
//            add(2);
//        }};
//        assertEquals(result, primesum(4));
//
//        result = new ArrayList<Integer>() {{
//            add(31);
//            add(16777183);
//        }};
//        assertEquals(result, primesum(16777214));

//        assertEquals(true, isPower(1024000000));
        int[] v = new int[]{699, 2, 690, 936, 319, 784, 562, 35, 151, 698, 126, 730, 587, 157, 201, 761, 956, 359, 198, 986, 915, 7, 703, 324, 814, 382, 294, 204, 120, 731, 615, 330, 486, 52, 223, 376, 649, 458, 564, 971, 72, 605, 177, 20, 461, 790, 872, 363, 916, 435, 991, 184, 410, 320, 16, 480, 768, 801, 117, 338, 650, 786, 17, 369, 979, 304, 445, 688, 862, 229, 311, 351, 985, 697, 135, 299, 310, 3, 643, 221, 831, 196, 887, 679, 484, 209, 824, 292, 588, 721, 140, 675, 827, 913, 271, 170, 812, 552, 334, 860, 981, 550, 308, 584, 442, 328, 251, 456, 976, 31, 507, 954, 982, 742, 45, 727, 794, 309, 527, 623, 56, 843, 436, 681, 143, 130, 689, 870, 362, 580, 560, 474, 385, 525, 881, 51, 890, 917, 820, 826, 139, 443, 978, 144, 512, 205, 682, 188, 344, 429, 497, 181, 749, 864, 664, 145, 621, 629, 886, 572, 89, 725, 945, 29, 553, 977, 783, 590, 236, 728, 125, 90, 492, 261, 543, 259, 662, 622, 285, 392, 561, 670, 200, 504, 246, 513, 910, 583, 460, 179, 207, 709, 127, 926, 816, 426, 520, 174, 464, 883, 780, 5, 268, 606, 1, 109, 704, 391, 661, 924, 516, 241, 477, 952, 405, 522, 247, 335, 356, 839, 423, 779, 4, 43, 720, 238, 965, 951, 914, 10, 496, 775, 651, 788, 373, 491, 746, 799, 518, 93, 86, 774, 652, 955, 494, 252, 781, 946, 412, 202, 741, 719, 612, 673, 896, 1000, 289, 554, 69, 424, 980, 506, 593, 889, 25, 959, 28, 736, 8, 969, 865, 657, 567, 434, 9, 167, 357, 929, 645, 250, 565, 94, 928, 473, 509, 823, 313, 762, -1, 208, 903, 922, 655, 948, 326, 485, 150, 73, 505, 225, 122, 129, 648, 838, 811, 972, 735, 78, 428, 740, 782, 632, 316, 440, 737, 297, 873, 281, 479, 654, 0, 633, 212, 152, 154, 470, 866, 79, 722, 958, 732, 900, 832, 278, 58, 842, 745, 540, 169, 347, 592, 438, 882, 462, 53, 34, 519, 489, 85, 757, 919, 701, 15, 211, 667, 637, 74, 573, 240, 559, -2, 472, 203, 112, 162, 776, -4, 155, 837, 99, 98, 64, 101, 983, 366, 853, 970, 482, 40, 921, 374, 758, 413, 339, 705, 771, 360, 734, 282, 219, 766, 535, 133, 532, 254};
        ArrayList<Integer> vals = new ArrayList<>();
        for (int i : v) {
            vals.add(i);
        }
        System.out.println(vals);
        assertEquals(6, firstMissingPositive(vals));

        v = new int[]{948, 20, 84, 710, 471, 606, 995, 581, -4, 428, 149, 832, 740, 943, 450, 974, 829, 721, 821, 476, 763, 4, 523, 937, 814, 624, 935, 87, 127, 816, 239, 33, 561, 999, 904, 282, 844, 923, 750, 551, 432, 9, 373, 387, 114, 376, 265, 801, 228, 454, 474, 764, 268, 680, 472, 431, 133, 785, 752, 643, 441, 151, 969, 395, 437, 94, 259, 973, 535, 272, 456, 546, 79, 677, 0, 109, 522, 295, 466, 956, 723, 157, 772, 865, 997, 771, 922, 980, 567, 939, 651, 478, 852, 926, 913, 494, 882, 207, 915, 645, 754, 385, 874, 554, 706, 722, 10, 374, 96, 647, 280, 418, 737, 538, 867, 850, 600, 23, 730, 742, 224, 511, 361, 251, 809, 907, 271, 319, 866, 848, 594, 566, 113, 211, 334, 644, 826, 430, 929, 603, 165, 147, 788, 529, 539, 633, 275, 602, 544, 540, 853, 123, -1, 443, 942, 386, 68, 465, 782, 250, 458, 174, 70, 919, 462, 347, 26, 589, 880, 648, 237, 294, 641, 707, 516, 507, 802, 989, 779, 519, 62, 619, 584, 358, 362, 277, 43, 198, 467, 625, 611, 212, 468, 767, 778, 173, 791, 331, 11, 461, 572, 97, 902, 558, 413, 28, 179, 370, 842, 568, 500, 311, 550, 464, 345, 411, 274, 181, 396, 339, 39, 760, 575, 327, 889, 579, 840, 734, 254, 934, 532, 29, 622, 780, 73, 479, 322, 2, 599, 227, 685, 65, 510, 716, 289, 912, 574, 262, 916, 924, 304, 57, 353, 40, 341, 521, 131, 307, 526, 398, 225, 63, 776};
        vals = new ArrayList<>();
        for (int i : v) {
            vals.add(i);
        }
        System.out.println(vals);
        assertEquals(1, firstMissingPositive(vals));

    }

    public int firstMissingPositive(ArrayList<Integer> a) {
        int N = a.size();
        for (int i = 0; i < N; i++) {
            int x = a.get(i);
            if (x > 0 && x <= N) {
                int pos = x-1;
                if (a.get(pos) != a.get(i)) {
                    swap(a, pos, i);
                    i--;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (a.get(i) != i+1) {
                return i + 1;
            }
        }

        return N + 1;
    }

    void swap(ArrayList<Integer> a, int pos, int i) {
        int tmp = a.get(pos);
        a.set(pos, a.get(i));
        a.set(i, tmp);
    }

    static int[] primes = new int[1091314];

    static {
//        generatePrimes();
    }

    public boolean isPower(long n) {
//        if (n == 1) {
//            return true;
//        }
//        for (int j=2; j<=Math.sqrt(n); j++) {
//            if (isPrime(j) && n % j == 0) {
//                while (n % j == 0) {
//                    n /= j;
//                }
//                return n <= 1;
//            }
//        }
        if (n == 1) {
            return true;
        }

        for (int a = 2; a <= Math.sqrt(n); a++) {
            int p = 2;
            long powerResult = (int) (Math.pow(a, p));

            while (powerResult < n) {
                powerResult = (int) (Math.pow(a, ++p));
                System.out.println("power=" + powerResult + " a=" + a + " p= " + p + "  n=" + n);
            }

            if (powerResult == n) {
                System.out.println("P=" + p + " a=" + a);
                return true;
            }
        }

        return false;

//        return false;
    }

    static boolean isPrime(int n) {
        boolean isPrime = true;
        int loop;
        for (loop = 3; isPrime && loop < Math.sqrt(n) + 1; loop += 2) {
            isPrime = ((n % loop) != 0);
        }
        return isPrime;
    }

    static void generatePrimes() {
        int index = 0;
        primes[index++] = 2;
        int n = 3;
        do {
            if (isPrime(n)) {
                primes[index++] = n;
            }
            n += 2;
        }
        while (n < 17000000);
    }


    public ArrayList<Integer> primesum(int a) {

        int left = 0;
        int right = primes.length - 1;

        while (left <= right) {
            if (primes[left] + primes[right] == a) {
                ArrayList<Integer> result = new ArrayList<>();
                result.add(primes[left]);
                result.add(primes[right]);
                return result;
            }
            if (primes[left] + primes[right] < a) {
                left++;
            }
            else {
                right--;
            }
        }

//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                if (primes[i] + primes[j] == a) {
//                    ArrayList<Integer> result = new ArrayList<>();
//                    result.add(primes[i]);
//                    result.add(primes[j]);
//                    return result;
//                }
//            }
//        }

        return null;
    }

}
