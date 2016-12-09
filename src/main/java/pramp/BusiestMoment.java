package pramp;

import org.junit.Test;

import java.util.Arrays;

public class BusiestMoment {

    @Test
    public void test() {

    }

    class Data implements Comparable {
        long timestamp;
        int count;
        boolean hasEntered;  // true for enter and false for exit

        public int compareTo(Object o) {
            return Long.compare(timestamp, ((Data) o).timestamp);
        }
    }

    long[] getBusiestMoment(Data[] data) {

        Arrays.sort(data);

        long currentPeople = 0;
        long maxPeople = 0;
        long maxStartTimestamp = 0;
        long maxEndTimestamp = 0;
        long lastTimestamp = 0;
        boolean hasSetMaximum = false;

        for (int j = 0; j < data.length; j++) {
            Data d = data[j];
            if (d.hasEntered) {
                currentPeople += d.count;
                if (maxPeople < currentPeople && lastTimestamp != d.timestamp) {
                    maxPeople = currentPeople;
                    maxStartTimestamp = d.timestamp;
                    hasSetMaximum = true;
                }
            }
            else {
                currentPeople -= d.count;
                if (hasSetMaximum) {
                    maxEndTimestamp = d.timestamp;
                    hasSetMaximum = false;
                }
            }

        }

        return new long[]{maxStartTimestamp, maxEndTimestamp};
    }

    long[] getBusiestMoment2(Data[] data) {

        Arrays.sort(data);

        long currentPeople = 0;
        long maxPeople = 0;
        long maxStartTimestamp = 0;
        long maxEndTimestamp = 0;

        for (int j=0; j<data.length; j++) {
            Data d = data[j];
            if (d.hasEntered) {
                currentPeople += d.count;
            }
            else {
                currentPeople -= d.count;
            }
            if(j<data.length-1 && d.timestamp == data[j+1].timestamp)
            {
                continue;
            }
            if(maxPeople < currentPeople)
            {
                maxPeople = currentPeople;
                if(j<data.length-1)
                {
                    maxStartTimestamp = d.timestamp;
                    maxEndTimestamp = data[j+1].timestamp;
                }
                else
                {
                    maxStartTimestamp = d.timestamp;
                    maxEndTimestamp = d.timestamp;
                }
            }
        }

        return new long[] {maxStartTimestamp, maxEndTimestamp};
    }

}
