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

}
