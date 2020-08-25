package elements;

public class SpreadsheetColumn {

    public static void main(String[] args) {

        String val = "A";
        System.out.println(val + "=" + getColumn(val));
        val = "D";
        System.out.println(val + "=" + getColumn(val));
        val = "AB";
        System.out.println(val + "=" + getColumn(val));
        val = "ZZ";
        System.out.println(val + "=" + getColumn(val));
        val = "AAA";
        System.out.println(val + "=" + getColumn(val));
    }

    public static int getColumn(String code) {

        int tot = 0;
        for (int i = 0; i < code.length(); i++) {
            tot += (code.charAt(i) - 'A' + 1) * Math.pow(26, code.length() - 1 - i);
        }

        return tot;
    }
}
