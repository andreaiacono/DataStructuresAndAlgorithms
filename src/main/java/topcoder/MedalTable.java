package topcoder;

import org.junit.Test;

import java.util.*;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertTrue;


/**
 * TopCoder: https://community.topcoder.com/stat?c=problem_statement&pm=2922&rd=5855
 */
public class MedalTable {

    final int GOLD = 0;
    final int SILVER = 1;
    final int BRONZE = 2;

    class Country {
        String code;
        int gold;
        int silver;
        int bronze;

        public Country(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return code + " " + gold + " " + silver + " " + bronze;
        }

        @Override
        public boolean equals(Object other) {
            if (other == null) return false;
            if (!(other instanceof Country)) {
                return false;
            }

            Country otherCountry = (Country) other;
            return code.equals(otherCountry.code);
        }

        @Override
        public int hashCode() {
            return code.hashCode();
        }
    }

    @Test
    public void test() {
        String[] results = new String[]{"KOR 3 1 0", "ITA 1 0 0", "TPE 0 1 1", "CHN 0 1 0", "JPN 0 1 0", "AUS 0 0 1", "GBR 0 0 1", "UKR 0 0 1"};
        assertTrue(Arrays.equals(results, generate(new String[]{"ITA JPN AUS", "KOR TPE UKR", "KOR KOR GBR", "KOR CHN TPE"})));

        results = new String[]{"USA 1 0 0", "AUT 0 1 0", "ROM 0 0 1"};
        assertTrue(Arrays.equals(results, generate(new String[]{"USA AUT ROM"})));

        results = new String[]{"AUT 1 1 1", "GER 1 1 1", "SUI 1 1 1"};
        assertTrue(Arrays.equals(results, generate(new String[]{"GER AUT SUI", "AUT SUI GER", "SUI GER AUT"})));

        results = new String[]{"TLS 3 0 3", "SWZ 3 0 2", "TUR 3 0 0", "CAY 2 3 0", "CRC 2 2 1", "AHO 2 1 2", "JOR 2 1 1", "LCA 2 0 2", "GAB 2 0 1", "DJI 2 0 0", "CIV 1 4 3", "ALG 1 3 4", "PAK 1 2 1", "BOT 1 2 0", "CHI 1 2 0", "KUW 1 2 0", "MDA 1 2 0", "VAN 1 2 0", "CAM 1 1 2", "ARU 1 1 1", "GRN 1 1 0", "PLW 1 1 0", "BAH 1 0 2", "EGY 1 0 1", "MEX 1 0 1", "SWE 1 0 1", "COL 1 0 0", "GHA 1 0 0", "KEN 1 0 0", "OMA 1 0 0", "SOM 1 0 0", "PHI 0 2 2", "RWA 0 2 2", "GEO 0 1 2", "ERI 0 1 1", "ETH 0 1 1", "GER 0 1 1", "NRU 0 1 1", "POL 0 1 1", "ECU 0 1 0", "EST 0 1 0", "TGA 0 1 0", "ZIM 0 1 0", "SRI 0 0 3", "FRA 0 0 1", "GBR 0 0 1"};
        assertTrue(Arrays.equals(results, generate(new String[]{"TLS EST ETH", "EGY BOT RWA", "CIV RWA FRA", "DJI PAK SWE", "CAM ALG ALG", "SWZ CRC ALG", "SOM POL PAK", "TUR VAN JOR", "MEX CAY AHO", "LCA ALG SRI", "OMA ZIM CRC", "ALG ERI ERI", "SWE GER CAM", "DJI NRU SRI", "CAY RWA TLS", "COL PHI CIV", "CRC KUW TLS", "TUR JOR SWZ", "GRN CAY AHO", "JOR PAK BAH", "GAB GEO CAM", "MDA GRN GAB", "TLS ETH SWZ", "BAH MDA LCA", "TLS PHI GBR", "SWZ TGA CIV", "ARU CIV PHI", "VAN CAM EGY", "SWZ MDA GEO", "TUR CHI CIV", "AHO KUW LCA", "CHI CIV BAH", "LCA CHI GER", "JOR CRC ARU", "BOT CIV RWA", "KEN ARU PHI", "PAK CAY TLS", "GHA BOT ALG", "PLW ALG NRU", "CRC VAN SRI", "GAB AHO GEO", "AHO CIV MEX", "CAY PLW POL", "KUW ECU ALG"})));
    }


    String[] generate(String[] results) {
        List<Country> countries = getCountries(results);

        Collections.sort(countries, (c1, c2) -> {
            if (c1.gold != c2.gold) {
                return -Integer.compare(c1.gold, c2.gold);
            }
            if (c1.silver != c2.silver) {
                return -Integer.compare(c1.silver, c2.silver);
            }
            if (c1.bronze != c2.bronze) {
                return -Integer.compare(c1.bronze, c2.bronze);
            }

            return c1.code.compareTo(c2.code);
        });

        String[] result = new String[countries.size()];
        countries.stream().map(c -> c.toString()).collect(toList()).toArray(result);
        return result;
    }

    private List<Country> getCountries(String[] results) {
        List<Country> countries = new ArrayList<>();

        Map<String, Country> countriesMap = new HashMap<>();
        for (int j = 0; j < results.length; j++) {
            String[] countryCodes = results[j].split(" ");
            updateCountry(countriesMap, countryCodes[GOLD], GOLD);
            updateCountry(countriesMap, countryCodes[SILVER], SILVER);
            updateCountry(countriesMap, countryCodes[BRONZE], BRONZE);
        }

        countries.addAll(countriesMap.values());
        return countries;
    }

    private void updateCountry(Map<String, Country> countriesMap, String countryCode, int medalType) {
        if (!countriesMap.keySet().contains(countryCode)) {
            countriesMap.put(countryCode, new Country(countryCode));
        }
        Country country = countriesMap.get(countryCode);
        switch (medalType) {
            case GOLD:
                country.gold++;
                break;
            case SILVER:
                country.silver++;
                break;
            case BRONZE:
                country.bronze++;
                break;
        }
    }
}
