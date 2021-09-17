

class KnuthMorrisPratt {
    static boolean inString(String needle, String str) {
        int index = 0;

        for (int i = 0; i < str.length(); i++) {
            index = (str.charAt(i) == needle.charAt(index)) ? (index + 1) : 0;
            if(index == needle.length()) break;
        }

        return index == needle.length();
    }

    public static void main(String[] args) {
        String str = "abdeociksqaefcdaedlsoaisjdkjd";

        String needle = "sqaefcdaed";
        System.out.println("inString(" + needle + ", " + str + ") = " + (inString(needle, str) ? "yes" : "no")); // YES

        needle = "jdkjk";
        System.out.println("inString(" + needle + ", " + str + ") = " + (inString(needle, str) ? "yes" : "no")); // NO
    }
}