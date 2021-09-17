import java.util.*;

class Anagram {
    static boolean isAnagram(String s1, String s2) {
        if(s1.length() != s2.length()) return false;

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j) && !list.contains(j)) {
                    list.add(j);
                }
            }
        }

        return list.size() == s1.length();
    }

    public static void main(String[] args) {
        String s1 = "chien";
        String s2 = "niche";

        System.out.println(" <" + s2 + "> anagramme de <" + s1 + ">: " + (isAnagram(s1, s2) ? "yes" : "no"));
    }
}