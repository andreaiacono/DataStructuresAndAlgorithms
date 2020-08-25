package dynamicprogramming;

import org.junit.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.zone.ZoneOffsetTransition;
import java.time.zone.ZoneRules;

import static org.junit.Assert.assertEquals;

public class RobotTravel {


    @Test
    public void test() {
        char mat[][] = new char[][]
                {
                        {'P', 'P', 'P'},
                        {'P', 'P', 'P'},
                        {'P', 'P', 'P'}
                };
        assertEquals(6, countRobotPaths(mat));

        mat = new char[][]
                {
                        {'P', 'P', 'P'},
                        {'P', 'W', 'P'},
                        {'P', 'P', 'P'}
                };
        assertEquals(2, countRobotPaths(mat));

        mat = new char[][]
                {
                        {'P', 'P', 'P'},
                        {'P', 'P', 'P'},
                        {'P', 'W', 'P'}
                };
        assertEquals(3, countRobotPaths(mat));


    }

    public static void main(String[] args) {

//        TimeZone zone = TimeZone.getTimeZone("Europe/London");

        ZoneRules rules = ZoneId.of("Europe/London").getRules();
        DateTimeFormatter format = DateTimeFormatter.ISO_DATE;
        Instant current = Instant.parse("1965-01-01T00:00:00Z");
        for (int i=0; i < 110; i++) {
            ZoneOffsetTransition next = rules.nextTransition(current);
            System.out.println(current.toString());
            current = next.getInstant();
        }

//        TimeZone utc = TimeZone.getTimeZone("CET");
//        Calendar date = Calendar.getInstance();
//        DateFormat format = DateFormat.getDateTimeInstance();
//        format.setTimeZone(utc);
//        date.set(1966, 8, 24, 23, 00, 00);
//        for (int i = 0; i < 10; i++) {
//            System.out.println(format.format(date.getTime()));
//            date.add(Calendar.HOUR_OF_DAY, 1);
//        }
//
//        date.set(2017, 9, 28, 23, 00, 00);
//        for (int i = 0; i < 12; i++) {
//            System.out.println(format.format(date.getTime()));
//            date.add(Calendar.HOUR_OF_DAY, 1);
//        }
    }

    int countRobotPaths(char[][] mat) {

        int[][] counts = new int[mat.length][mat[0].length];
        counts[0][0] = 1;
        for (int r=0; r<mat.length; r++) {
            for (int c=0; c<mat[0].length; c++) {
                if (r > 0 && c > 0) {
                    counts[r][c] = (mat[r-1][c] == 'P' ? counts[r-1][c] : 0) + (mat[r][c-1] == 'P' ? counts[r][c-1] : 0);
                }
                else if (c > 0) {
                    counts[r][c] = mat[r][c-1] == 'P' ? counts[r][c-1] : 0;
                }
                else if (r > 0) {
                    counts[r][c] = mat[r-1][c] == 'P' ? counts[r-1][c] : 0;
                }
            }
        }

        return counts[mat.length-1][mat[0].length-1];
    }

}
