public class String3 {

    // Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez"
    // count, but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if
    // there is not an alphabetic letter immediately following it. (Note: Character.isLetter(char)
    // tests if a char is an alphabetic letter.)
    public int countYZ(String str) {

        int result = 0;
        str = str.toLowerCase();

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == 'z' || str.charAt(i) == 'y') {
                if (!Character.isLetter(str.charAt(i + 1)))
                    result++;
            }
        }

        if (str.charAt(str.length() - 1) == 'z' || str.charAt(str.length() - 1) == 'y') {
            result++;
        }

        return result;
    }

    // Given two strings, base and remove, return a version of the base string where all instances of the remove
    // string have been removed (not case sensitive). You may assume that the remove string is length 1 or more.
    // Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
    public String withoutString(String base, String remove) {

        String result = "";

        for (int i = 0; i < base.length(); i++) {
            if (base.substring(i).toLowerCase().startsWith(remove.toLowerCase())) {
                i = i + remove.length() - 1;
            } else {
                result = result + base.substring(i, i + 1);
            }
        }

        return result;
    }


    // Given a string, return true if the number of appearances of "is" anywhere in the string is equal to the
    // number of appearances of "not" anywhere in the string (case sensitive).
    public boolean equalIsNot(String str) {

        int is = 0;
        int not = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i).startsWith("is")) {
                is++;
                continue;
            }
            if (str.substring(i).startsWith("not")) {
                not++;
            }
        }
        return is == not;
    }


    // We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or
    // right. Return true if all the g's in the given string are happy.
    public boolean gHappy(String str) {

        str = "x" + str + "x";

        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) == 'g' && str.charAt(i - 1) != 'g' && str.charAt(i + 1) != 'g') {
                return false;
            }
        }
        return true;
    }


    // We'll say that a "triple" in a string is a char appearing three times in a row. Return the number of triples
    // in the given string. The triples may overlap.
    public int countTriple(String str) {

        int result = 0;

        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == str.charAt(i + 1) && str.charAt(i) == str.charAt(i + 2)) {
                result++;
            }
        }
        return result;
    }


    // Given a string, return the sum of the digits 0-9 that appear in the string, ignoring all other characters.
    // Return 0 if there are no digits in the string. (Note: Character.isDigit(char) tests if a char is one of
    // the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)
    public int sumDigits(String str) {

        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                result += Integer.parseInt(String.valueOf(str.charAt(i)));
            }
        }
        return result;

    }


    // Given a string, return the longest substring that appears at both the beginning and end of the string
    // without overlapping. For example, sameEnds("abXab") is "ab".
    public String sameEnds(String string) {

        String result = "";
        String temp = "";

        for (int i = 0; i < string.length(); i++) {

            temp += string.charAt(i);

            int templen = temp.length();

            if (i < string.length() / 2 && temp.equals(string.substring(string.length() - templen)))
                result = temp;
        }
        return result;
    }

    // Given a string, look for a mirror image (backwards) string at both the beginning and end of the given string.
    // In other words, zero or more characters at the very begining of the given string, and at the very end of the
    // string in reverse order (possibly overlapping). For example, the string "abXYZba" has the mirror end "ab".
    public String mirrorEnds(String string) {

        String result = "";

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == string.charAt(string.length() - 1 - i)) {
                result = string.substring(0, i + 1);
            } else {
                break;
            }
        }
        return result;
    }


    // Given a string, return the length of the largest "block" in the string. A block is a run of
    // adjacent chars that are the same.
    public int maxBlock(String str) {

        int result = 0;
        int tempResult = 0;

        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                result = 1;
                tempResult = 1;
            } else {
                if (str.charAt(i) == str.charAt(i - 1)) {
                    tempResult++;
                    if (result < tempResult) {
                        result = tempResult;
                    }
                }
                else {
                    tempResult = 1;
                }
            }
        }
        return result;
    }


}

