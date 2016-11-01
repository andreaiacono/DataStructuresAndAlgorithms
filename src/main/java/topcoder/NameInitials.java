package topcoder;

public class NameInitials {

    public String getInitials(String name) {
        StringBuilder result = new StringBuilder("" + name.charAt(0));
        for (int j=0; j<name.length(); j++) {
            if (j > 0 && name.charAt(j-1) == ' ') {
                result.append(name.charAt(j));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        NameInitials nameInitials = new NameInitials();
        System.out.println(nameInitials.getInitials("john fitzgerald kennedy"));
        System.out.println(nameInitials.getInitials("single"));
        System.out.println(nameInitials.getInitials("looks good to me"));
        System.out.println(nameInitials.getInitials("a aa aaa aa a bbb bb b bb bbb"));
        System.out.println(nameInitials.getInitials("single"));
    }
}
