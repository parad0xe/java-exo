class ToLowerCase {
    static String toLower(String str) {
        String new_str = "";

        for (int i = 0; i < str.length(); i++) {
            int a = (int)str.charAt(i);
            if(a >= 65 && a <= 90)
                new_str += (char)(a + ((int)'a') - (int)'A');
            else
                new_str += str.charAt(i);
        }

        return new_str;
    }

    public static void main(String[] args) {
        System.out.println(toLower("TEST"));
    }
}