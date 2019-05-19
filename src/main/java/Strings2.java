public class Strings2 {

    //Given a string, return a string where for every char in the original, there are two chars.
    public String doubleChar(String str) {
        String result = "";
        for (int i = 0; i <= str.length() - 1; i++) {
            result = result + str.substring(i, i + 1) + str.substring(i, i + 1);

        }
        return result;
    }

    // Return the number of times that the string "hi" appears anywhere in the given string.
    public int countHi(String str) {

        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.substring(i, i + 2).equals("hi")) {
                count += 1;
            }
        }
        return count;
    }

    // Return true if the string "cat" and "dog" appear the same number of times in the given string.
    public boolean catDog(String str) {

        int cat = 0;
        int dog = 0;

        for (int i = 0; i < str.length() - 2; i++) {
            if (str.substring(i, i + 3).equals("cat")) {
                cat++;
            }
            if (str.substring(i, i + 3).equals("dog")) {
                dog++;
            }
        }
        return cat == dog;
    }

    // Return the number of times that the string "code" appears anywhere in the given string, except we'll
    // accept any letter for the 'd', so "cope" and "cooe" count.
    public int countCode(String str) {

        int count = 0;

        for (int i = 0; i < str.length() - 3; i++) {

            if (str.substring(i, i + 2).equals("co") && str.substring(i + 3, i + 4).equals("e")) {
                count++;
            }
        }

        return count;
    }

    // Given two strings, return true if either of the strings appears at the very end of the other string,
    // ignoring upper/lower case differences (in other words, the computation should not be "case sensitive").
    // Note: str.toLowerCase() returns the lowercase version of a string.
    public boolean endOther(String a, String b) {
        if (a.length() < b.length()) {
            String temp = a;
            a = b.toLowerCase();
            b = temp.toLowerCase();
        }

        return a.substring(a.length() - b.length()).equals(b);
    }

    // Return true if the given string contains an appearance of "xyz" where the xyz is not directly
    // preceded by a period (.). So "xxyz" counts but "x.xyz" does not.
    public boolean xyzThere(String str) {

        if (str.length() >= 3 && str.substring(0, 3).equals("xyz"))
            return true;

        for (int i = 1; i < str.length() - 2; i++) {
            if (str.charAt(i - 1) != '.' && str.substring(i, i + 3).equals("xyz"))
                return true;
        }

        return false;
    }

    // Return true if the given string contains a "bob" string, but where the middle 'o' char can be any char.
    public boolean bobThere(String str) {

        if (str.length() < 3) {
            return false;
        }
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == 'b' && str.charAt(i + 2) == 'b') {
                return true;
            }
        }
        return false;
    }

    // We'll say that a String is xy-balanced if for all the 'x' chars in the string, there exists a 'y' char
    // somewhere later in the string. So "xxy" is balanced, but "xyx" is not. One 'y' can balance multiple 'x's.
    // Return true if the given string is xy-balanced.
    public boolean xyBalance(String str) {

        int number = -1;

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == 'x') {
                number = i;
            }
        }
        if (number == -1) {
            return true;
        }

        for (int j = number; j < str.length(); j++) {
            if (str.charAt(j) == 'y') {
                return true;
            }
        }

        return false;

    }

    // Given two strings, a and b, create a bigger string made of the first char of a, the first char of b,
    // the second char of a, the second char of b, and so on. Any leftover chars go at the end of the result.
    public String mixString(String a, String b) {

        String result = "";

        int limit;

        if (a.length() < b.length()) {
            limit = a.length();
        } else {
            limit = b.length();
        }

        for (int i = 0; i < limit; i++) {
            result = result + a.charAt(i) + b.charAt(i);
        }
        for (int i = 0; i < a.length(); i++) {
            result = result + a.charAt(i);
        }
        for (int i = 0; i < b.length(); i++) {
            result = result + b.charAt(i);
        }

        return result;
    }

    // Given a string and an int n, return a string made of n repetitions of the last n characters of the string.
    // You may assume that n is between 0 and the length of the string, inclusive.
    public String repeatEnd(String str, int n) {

        String result = "";

        for (int i = 0; i < n; i++) {
            result = result + str.substring(str.length() - n);
        }
        return result;
    }

    // Given a string and an int n, return a string made of the first n characters of the string, followed by the
    // first n-1 characters of the string, and so on. You may assume that n is between 0 and the length of the
    // string, inclusive (i.e. n >= 0 and n <= str.length()).
    public String repeatFront(String str, int n) {

        String result = "";

        for (int i = 0; i < n; i++) {

            result = result + str.substring(0, n - i);
        }

        return result;

    }

    // Given two strings, word and a separator sep, return a big string made of count occurrences of the word,
    // separated by the separator string.
    public String repeatSeparator(String word, String sep, int count) {

        String result = "";
        int number = 1;

        for (int i = 0; i < count; i++) {
            result = result + word;
            if (number < count) {
                result = result + sep;
                number++;
            }
        }
        return result;
    }

    // Given a string, consider the prefix string made of the first N chars of the string. Does that prefix string appear
    // somewhere else in the string? Assume that the string is not empty and that N is in the range 1..str.length().
    public boolean prefixAgain(String str, int n) {

        String look = str.substring(0, n);

        return str.indexOf(look, 1) != -1;
    }

    // Given a string, does "xyz" appear in the middle of the string? To define middle, we'll say that the number
    // of chars to the left and right of the "xyz" must differ by at most one. This problem is harder than it looks.
    public boolean xyzMiddle(String str) {

        for (int i = 0; i < str.length() - 3; i++) {
            if (str.substring(i, i + 3).equals("xyz")) {
                String front = str.substring(0, i);
                String end = str.substring(i + 3);
                int a = Math.abs(front.length() - end.length());
                if (a <= 1) return true;
            }
        }
        return (str.equals("xyz"));
    }

    // Returns true if for every '*' (star) in the string, if there are chars both immediately before and after
    // the star, they are the same.
    public boolean sameStarChar(String str) {

        for (int i = 1; i < str.length() - 1; i++) {
            if (str.substring(i, i + 1).equals("*")) {
                if (!(str.substring(i - 1, i)).equals(str.substring(i + 1, i + 2))) {
                    return false;
                }
            }
        }
        return true;
    }


    public String zipZap(String str) {

        if (str.length() <= 2) {
            return str;
        }

        String result = "";

        for (int i = 0; i < str.length() - 2; i++) {

            if (str.charAt(i) == 'z' && str.charAt(i + 2) == 'p') {
                result += ("zp");
                i = i + 2;
            } else {
                result += str.charAt(i);
            }
        }

        return result;
    }
}
