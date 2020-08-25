package elements;

public class LookAndSay {

    public static void main(String[] args) {

        System.out.println(lookAndSay(1, 10));
    }

    private static String lookAndSay(int n, int times) {

        String result = "1" + n;
        for (int i=0; i<times; i++) {
            System.out.println("step:" + result);
            result = say(result);
        }
        System.out.println("step:" + result);
        return result;
    }

    private static String say(String n) {

        String result = "";
        int counter = 1;
        for (int i=0; i<n.length()-1; i++) {
            if (n.charAt(i) == n.charAt(i+1)) {
                counter++;
                continue;
            }
            result += counter + "" + n.charAt(i);
            counter = 1;
        }

        if (n.charAt(n.length()-1) == n.charAt(n.length()-2)) {
            result += "" + counter + "" + n.charAt(n.length()-1);
        }
        else {
            result += "1" + n.charAt(n.length()-1);
        }

        return result;
    }

}
