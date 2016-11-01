package recursion;

public class WaterInGlasses {

    // indices are 1-based!
    public static float getWater(float litres, int i, int j, int searchedRow, int searchedCol) {

        // base case
        if (i > searchedRow || litres < 0) {
            return 0;
        }

        // found searched glass
        if (i == searchedRow && j == searchedCol) {
            return litres;
        }

        float found = 0;
        found += getWater((litres - 1) / 2, i + 1, j, searchedRow, searchedCol);
        found += getWater((litres - 1) / 2, i + 1, j + 1, searchedRow, searchedCol);

        return found;
    }

    public static void main(String[] args) {
        int litres = 4;
        int row = 3;
        int col = 2;
        System.out.printf("Water filled in glass #%d at row %d is %.2f", col, row, getWater(litres, 1, 1, row, col));
    }
}
