package misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 14/07/14
 * Time: 14.52
 */

/**
If we have 3 travel alerts, one in Boston, one in Massachusetts, and one in the USA:

        A user looking at a Boston specific page should see the travel alert of Boston and not the one of Massachusetts
        A user looking at a Massachusetts page should see the travel alert of Massachusetts
        A user looking at a Newton specific page should see the travel alert of Massachusetts
        A user looking at a NYC specific page should see the US travel alert
        A user looking at a Montreal specific page should see no travel alert.
*/

public class TravelAlert {

    int id;
    String message;
    int locationId;
}

class Location {
    int locationId;
    int parentLocationId; // -1 if no parent, location is hierarchy
    String name;

    static Location findLocation(int locationId) {
        return null;
    }
}

class TravelAlertStore {
    private List<TravelAlert> lAlerts; // already populated, static

    private Map<Integer, TravelAlert> listToMap(List<TravelAlert> list) {
        Map<Integer, TravelAlert> map = new HashMap<>();
        for (TravelAlert travelAlert: lAlerts) {
            map.put(travelAlert.locationId, travelAlert);
        }
        return map;
    }

    // Return null if no alert
    TravelAlert findBestTravelAlert(int locationId) {

        TravelAlert ta = null;
        Map<Integer, TravelAlert> map = listToMap(lAlerts);
        Location loc = Location.findLocation(locationId);

        while (loc.parentLocationId != -1 && (ta=map.get(loc.locationId)) == null) {
            loc = Location.findLocation(loc.parentLocationId);
        }

        return ta;
    }
}