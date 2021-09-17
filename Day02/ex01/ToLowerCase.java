class ToLowerCase {
    static String toLower(String str) {
        String newStr = "";

        for (int i = 0; i < str.length(); i++) {
            int a = (int)str.charAt(i);
            if(a >= 65 && a <= 90)
                newStr += (char)(a + ((int)'a') - (int)'A');
            else
                newStr += str.charAt(i);
        }

        return newStr;
    }

    public static void main(String[] args) {
        System.out.println(toLower("TEST"));
    }
}