import java.util.*;

class RomainToInt {
    static List<Character> symbols = new ArrayList<Character>(){
        { add('I'); add('V'); add('X'); add('L'); add('C'); add('D'); add('M'); }
    };

    static int[] values = {1, 5, 10, 50, 100, 500, 1000};

    static String toUpper(String str) {
        String new_str = "";

        for (int i = 0; i < str.length(); i++) {
            int a = (int)str.charAt(i);
            if(a >= 97 && a <= 122)
                new_str += (char)(((a - ((int)'a'))) + (int)'A');
            else
                new_str += str.charAt(i);
        }

        return new_str;
    }

    static String cleanRomainString(String romain) {
        String n_romain = "";

        for (int i = 0; i < romain.length(); i++) {
            if(!symbols.contains(romain.charAt(i))) continue;
            n_romain += romain.charAt(i);
        }

        return n_romain;
    }

    static int romainToInt(String romain) {
        int value = 0;
        int lastOddValue = -1;
        int lastOddValueCount = 0;

        romain = cleanRomainString(toUpper(romain));

        for (int i = 0; i < romain.length(); i++) {
            char symbol = romain.charAt(i);
            int symbolIndex = symbols.indexOf(symbol);
            int symbolValue = values[symbolIndex];

            boolean hasNext = i + 1 < romain.length();
            char nextSymbol = '\0';
            int nextSymbolIndex = 0, nextSymbolValue = 0;

            if(hasNext) {
                nextSymbol = romain.charAt(i + 1);
                nextSymbolIndex = symbols.indexOf(nextSymbol);
                nextSymbolValue = values[nextSymbolIndex];
            }

            if(lastOddValue == symbolValue) {
                if(lastOddValueCount + 1 > 3)
                    return -1;
            } else lastOddValueCount = 0;

            boolean isOddIndex = (symbolIndex % 2 == 0) ? true : false;
            boolean nextIsOddIndex = (hasNext && nextSymbolIndex % 2 == 0) ? true : false;
            boolean nextIsLast = (i + 1 == romain.length() - 1) ? true : false;

            if(isOddIndex) {
                lastOddValue = symbolValue;
                lastOddValueCount++;
            } else if(i - 1 >= 0 && romain.charAt(i - 1) == symbol) {
                return -1;
            }

            if(hasNext && nextSymbolValue > symbolValue) {
                if(!nextIsLast || ((symbolIndex != nextSymbolIndex - 1) && (symbolIndex != nextSymbolIndex - 2)))
                    return -1;

                if(i - 1 >= 0 && romain.charAt(i - 1) == symbol)
                    return -1;
            }

            if(hasNext && symbolValue < nextSymbolValue)
                value -= symbolValue;
            else
                value += symbolValue;
        }

        return value;
    }

    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("\033[31m  Usage: prog <string>");
            return;
        }

        String r = args[0];
        System.out.println(r + " = " + romainToInt(r));
    }
}