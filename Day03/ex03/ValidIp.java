import java.util.*;

class ValidIp {
    static ArrayList<String> getValidIpOf(String str, int depth) {
        String next = "";
        ArrayList<String> list = new ArrayList<>();

        if(depth == 0 && (str.length() == 0 || str.charAt(0) == '0')) return list;

        if(depth < 3) {
            for (int i = 0; i < str.length(); i++) {
                next += str.charAt(i);
                if(Integer.parseInt(next) > 255 || next.length() > 1 && next.charAt(0) == '0') break;
                list.add(next);
            }
        } else {
            if(str.length() > 0 && Integer.parseInt(str) <= 255 && (str.length() != 2 || Integer.parseInt(str) >= 10))
                list.add(str);
        }

        ArrayList<String> ips = new ArrayList<>();

        if(depth < 4) {
            for (int i = 0; i < list.size(); i++) {
                ArrayList<String> subList = getValidIpOf(str.substring(list.get(i).length()), depth + 1);
                if(subList.size() > 0) {
                    for (int j = 0; j < subList.size(); j++) {
                        String ip = list.get(i) + "." + subList.get(j);

                        if(ip.charAt(ip.length() - 1) != '.' && ip.length() >= str.length())
                            ips.add(ip);
                    }
                } else ips.add(list.get(i));
            }
        }

        if(depth == 0) {
            ArrayList<String> tmp = new ArrayList<>();
            for (int i = 0; i < ips.size(); i++)
                if(ips.get(i).length() == str.length() + 3) tmp.add(ips.get(i));
            ips = tmp;
        }

        return ips;
    }

    static ArrayList<String> getValidIpOf(String str) {
        return getValidIpOf(str, 0);
    }

    public static void main(String[] args) {
        String str = "1921680";

        ArrayList<String> list = getValidIpOf(str);
        System.out.print("ValidIpOf(" + str + "): ");
        System.out.print(list);
        System.out.println(" - count: " + list.size());
    }
}