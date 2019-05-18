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
