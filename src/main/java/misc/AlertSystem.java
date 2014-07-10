package misc;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 10/07/14
 * Time: 13.44
 */

import java.util.*;

/**
 * Design an alert system. You have 500,000 hotels you represent, and about 250,000 are visited each day.
 * You want to track hotel page visits such that, if more than 10 visitors per a) 5 minutes, b) 1 hour,
 * and c) 24 hours occur, then a (different for each time period) "alert" appears when someone visits one
 * of those "hot" hotel pages. Don't worry about the UI part, just design the underlying alert system.
 * Then optimize your solution for space.
 */
public class AlertSystem {

    Map<Integer, VisitsData> visits = new HashMap<>();

    /**
     * to be called when a hotel is visited *
     */
    public void setHotelAsVisited(Integer id) {
        if (!visits.containsKey(id)) {
            visits.put(id, new VisitsData());
        }
        long now = System.currentTimeMillis();
        visits.get(id).addVisit(now);
    }


    public int getLastFiveMinutesVisits(Integer id) {
        long now = System.currentTimeMillis();
        return visits.get(id).getFiveMinutesVisits(now);
    }

    public int getLastOneHourVisits(Integer id) {
        long now = System.currentTimeMillis();
        return visits.get(id).getOneHourVisits(now);
    }
    public int getLastTwentyFourHoursVisits(Integer id) {
        long now = System.currentTimeMillis();
        return visits.get(id).getTwentyFourHoursVisits(now);
    }


    class VisitsData {

        private List<Long> fiveMinutes;
        private List<Long> oneHour;
        private List<Long> twentyFourHours;


        VisitsData() {
            fiveMinutes= new LinkedList<>();
            oneHour = new LinkedList<>();
            twentyFourHours = new LinkedList<>();
        }

        public void addVisit(long now) {
            fiveMinutes.add(0, now);
            oneHour.add(0, now);
            twentyFourHours.add(0, now);
        }

        public int getFiveMinutesVisits(long now) {
            return getVisits(fiveMinutes, 300000, now);
        }
        public int getOneHourVisits(long now) {
            return getVisits(oneHour, 3600000, now);
        }
        public int getTwentyFourHoursVisits(long now) {
            return getVisits(twentyFourHours, 86400000, now);
        }


        private int getVisits(List<Long> list, int time, long now) {
            int counter = 0;
            for (Long timestamp: list) {
                if (now - timestamp < time) counter++;
                else break;
            }
            return counter;
        }

        /**
         * to be called every day to avoid out of memory errors
         */
        public void cleanMaps() {
            cleanMap(fiveMinutes);
            cleanMap(oneHour);
            cleanMap(twentyFourHours);
        }

        private void cleanMap(List<Long> list) {
            long now = System.currentTimeMillis();
            Iterator<Long> iterator = list.iterator();
            while (iterator.hasNext()) {
                Long timestamp = iterator.next();
                if (now - timestamp > 86400000) {
                    iterator.remove();
                }
            }
        }
    }

}
