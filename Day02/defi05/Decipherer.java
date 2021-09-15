
class Decipherer {
    public static String decode(String cipher) {
        int key = (int)cipher.length() / 2;
        String sub = cipher.substring(5, 5 + key);
        return new StringBuilder(sub.replace("@#?", " "))
                .reverse()
                .toString();
    }

    public static void main(String[] args) {
        System.out.println(decode("0@sn9sirppa@#?ia'jgtvryko1"));
        System.out.println(decode("q8e?wsellecif@#?sel@#?setuotpazdsy0*b9+mw@x1vj"));
        System.out.println(decode("aopi?sedohtém@#?sedhtmg+p9l!"));
    }
}