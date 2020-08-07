package WorkWithString;

public class Main {
    public static void main(String[] args) {
//        String str = "Hello World!";
        int startString = 4;
        int endString = 7;
        String s = "dukeprogramming";
        String x = s.substring(startString,endString);
        char searchSymbol = 'g';
        char searchSymbolTmp = 'f';
        int findSymbol = 8;
        String startsWithWord = "duke";
        String endWithWord = "king";
        int symbolCharAt = 3;
        char oldChar = 'r';
        char newChar = '*';


        System.out.println("String: \t\t\t\t\t" + s);
        System.out.println("Substring of '" + s + "' - (" +startString + "," + endString + "): \t" + x);
        System.out.println("Length of string: \t\t\t" + s.length());
        System.out.println("Index Of '" + searchSymbol + "':\t\t\t\t" + s.indexOf(searchSymbol));
        System.out.println("Index Of '" + searchSymbolTmp +"': \t\t\t\t" + s.indexOf(searchSymbolTmp));
        System.out.println("Index Of ('" + searchSymbol + "', " + findSymbol + "): \t\t\t" + s.indexOf(searchSymbol, findSymbol));
        System.out.println("Starts with '" + startsWithWord + "': \t\t" + s.startsWith(startsWithWord));
        System.out.println("End with '" + endWithWord + "': \t\t\t" + s.endsWith(endWithWord));
        System.out.println("Char At " + symbolCharAt + ":\t\t\t\t\t" + s.charAt(2));
        System.out.println("To upper case: \t\t\t\t" + s.toUpperCase());
        System.out.println("Replace '" + oldChar + "' symbol to '" + newChar + "':\t" + s.replace(oldChar, newChar));
    }
}
