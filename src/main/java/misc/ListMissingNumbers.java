package misc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListMissingNumbers {

    @Test
    public void test() {
        int[] nums = new int[] {};
        String result = "0-99";
        assertEquals(result, toMissingString(nums));

        nums = new int[] {0};
        result = "1-99";
        assertEquals(result, toMissingString(nums));

        nums = new int[] {99};
        result = "0-98";
        assertEquals(result, toMissingString(nums));

        nums = new int[] {0, 99};
        result = "1-98";
        assertEquals(result, toMissingString(nums));

        nums = new int[] {0,1};
        result = "2-99";
        assertEquals(result, toMissingString(nums));

        nums = new int[] {1};
        result = "0,2-99";
        assertEquals(result, toMissingString(nums));

        nums = new int[] {1,2,3,4};
        result = "0,5-99";
        assertEquals(result, toMissingString(nums));

        nums = new int[] {3,5};
        result = "0-2,4,6-99";
        assertEquals(result, toMissingString(nums));

        nums = new int[] {3,5,7};
        result = "0-2,4,6,8-99";
        assertEquals(result, toMissingString(nums));

        nums = new int[] {0,1,2,50,52,75};
        result = "3-49,51,53-74,76-99";
        assertEquals(result, toMissingString(nums));
    }

    private int[] holder = new int[100];
    private int start = -1;
    private String result = "", s;

    private String findUps(int[] numbers) {
        List<Integer> nums = new ArrayList<>();
        Arrays.stream(numbers).forEach(n -> nums.add(n));
        if(nums == null || nums.size() == 0)return "0-99";
        for(int n : nums){
            holder[n] = 1;
        }
        for (int i = 0; i<100; i++) {
            if(holder[i]==0) {
                if(start == -1) start = i;
            } else {
                if(start != -1) {
                    if(i-start == 1) s = ""+start;
                    else s = start + "-" + (i-1);
                    result += (result.equals("")?"":",")
                            + s;
                    start = -1;
                }
            }
        }
        if(start != -1)
            result += (result.equals("")?"":",")
                    + ((99-start != 0)?start + "-":"") + 99;
        return result;
    }

    private String toMissingString(int[] nums) {

        if (nums.length == 0) {
            return "0-99";
        }
        // fills an array with the numbers that are in the array
        boolean[] presences = new boolean[100];
        for (int j=0; j<nums.length; j++) {
            presences[nums[j]]  =true;
        }

        StringBuilder result = new StringBuilder();
        int lastSeenNumber = -1;

        int firstNotPresent = 0;
        while (firstNotPresent < 100 && presences[firstNotPresent]) {
            firstNotPresent++;
        }

//        if (firstNotPresent == 1) {
//            result.append("0,");
//        }
        if (firstNotPresent > 1) {
            lastSeenNumber = firstNotPresent+1;
            result.append("0").append("-").append(firstNotPresent-1).append(",");
        }

        for (int j=firstNotPresent; j<presences.length; j++) {

            if (!presences[j]) {
                continue;
            }
            else {
//                if (j > 0 && presences[j-1]) {
//                    lastSeenNumber = j;
//                    continue;
//                }
                if (lastSeenNumber + 1 == j - 1) {
                    result.append(lastSeenNumber + 1).append(",");
                }
//                else if (lastSeenNumber >= 0) {
                else if (lastSeenNumber >= 0){
                    result.append(lastSeenNumber + 1).append("-").append(j - 1).append(",");
                }
                lastSeenNumber = j;
            }
        }

        if (lastSeenNumber < 99) {
            result.append(lastSeenNumber+1).append("-").append("99");
        }
        else {
            // removes the comma at the end of the string
            if (result.length() > 0) result.deleteCharAt(result.length()-1);
        }

        return result.toString();
    }

    private String toMissingStringNotWorking(int[] nums) {

        if (nums.length == 0) {
            return "0-99";
        }

        StringBuilder result = new StringBuilder();
        int lastSeenNumber = 0;

        for (int j=0; j<nums.length; j++) {

            if (j == nums.length-1) {
                result.append(lastSeenNumber+1);
                if (lastSeenNumber+1 !=  nums[j] -1 ) {
                    result.append("-").append(nums[j] - 1).append(",");
                }
                else {
                    result.append(",");
                }
                if (nums[j] != 99) {
                    result.append(nums[j] + 1).append("-").append("99");
                }
                break;
            }

            if (nums[j] - lastSeenNumber == 2) {
                result.append(nums[j]-1).append(",");
                lastSeenNumber = nums[j];
            }
            else if (nums[j] - lastSeenNumber > 1) {
                result.append(lastSeenNumber).append("-").append(nums[j]-1).append(",");
                lastSeenNumber = nums[j];
            }
            else {
                lastSeenNumber ++;
            }
        }

        if (result.charAt(result.length()-1) == ',') {
            result.deleteCharAt(result.length()-1);
        }


        return result.toString();
    }
}
