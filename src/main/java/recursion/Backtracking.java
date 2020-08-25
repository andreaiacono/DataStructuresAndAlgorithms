package recursion;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Backtracking {

    Set<String> dict = new HashSet<>() {{
        add("sing");
        add("sin");
        add("son");
        add("in");
        add("on");
        add("i");
    }};

    @Test
    public void test() {
        String s = "sing";
        System.out.println("is Shrinkanle(" + s + "): " + isShrinkable(s));
        s = "son";
        System.out.println("is Shrinkanle(" + s + "): " + isShrinkable(s));

        int[] values = new int[]{100, 3, 5, 4, 2, 10, 7};
        assertTrue(subsetSum(values, 8, 0, 0));
        assertTrue(subsetSum(values, 9, 0, 0));
        assertTrue(subsetSum(values, 22, 0, 0));
        assertFalse(subsetSum(values, 0, Integer.MIN_VALUE, 0));
        assertFalse(subsetSum(values, 33, 0, 0));

        int[] doctors = new int[]{5, 2};
        int[] patients = new int[]{1, 5};
        assertTrue(doctorsPatients(doctors, patients));
        assertTrue(doctorsPatientsRecursive(doctors, patients, 0, 0));

        doctors = new int[]{5, 2};
        patients = new int[]{3, 5};
        assertFalse(doctorsPatients(doctors, patients));
        assertFalse(doctorsPatientsRecursive(doctors, patients, 0, 0));

        doctors = new int[]{5, 2, 4};
        patients = new int[]{5, 1};
        assertTrue(doctorsPatients(doctors, patients));
        assertTrue(doctorsPatientsRecursive(doctors, patients, 0, 0));


        doctors = new int[]{2, 7, 4, 2};
        patients = new int[]{4, 2, 3, 1, 1, 2, 2};
        assertTrue(doctorsPatients(doctors, patients));
        assertTrue(doctorsPatientsRecursive(doctors, patients, 0, 0));
    }

    boolean isShrinkable(String s) {
        if (s.length() == 1) {
            return true;
        }

        boolean result = false;
        for (int i = 0; i < s.length(); i++) {
            String removedChar = delete(s, i);
            if (dict.contains(removedChar)) {
                result = result | isShrinkable(removedChar);
            }
        }
        return result;
    }

    String delete(String s, int index) {
        return s.substring(0, index) + s.substring(index + 1);
    }

    boolean subsetSum(int[] values, int sum, int partialSum, int index) {

        if (partialSum == sum) {
            return true;
        } else if (partialSum > sum) {
            return false;
        }

        if (index == values.length) {
            return false;
        }

        return subsetSum(values, sum, partialSum, index + 1) ||
                subsetSum(values, sum, partialSum + values[index], index + 1);
    }

    boolean doctorsPatients(int[] doctors, int[] patients) {
        Arrays.sort(doctors);
        Arrays.sort(patients);

        for (int i = 0; i < doctors.length; i++) {
            int hoursLeft = doctors[i];
            int patient = 0;
            while (hoursLeft > 0 && patient < patients.length) {
                if (patients[patient] <= hoursLeft) {
                    hoursLeft -= patients[patient];
                    patients[patient] = 0;
                }
                patient++;
            }
        }

        return Arrays.stream(patients).sum() == 0;
    }

    boolean doctorsPatientsRecursive(int[] doctors, int[] patients, int doctorIdx, int patientIdx) {

        if (patientIdx == patients.length) {
            return true;
        }

        if (doctorIdx == doctors.length) {
            return false;
        }

        boolean result = false;
        int hoursLeft = doctors[doctorIdx];
        if (hoursLeft > patients[patientIdx]) {
            int patientHours = patients[patientIdx];
            patients[patientIdx] = 0;
            result = result | doctorsPatientsRecursive(doctors, patients, (hoursLeft - patientHours > 0) ? doctorIdx : doctorIdx+1, patientIdx + 1);
            patients[patientIdx] = patientHours;
        } else {
            result = result | doctorsPatientsRecursive(doctors, patients, doctorIdx+1, patientIdx);

        }

        return result;
    }
}
