import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AP1 {

    // Given an array of scores, return true if each score is equal or greater than the one before.
    // The array will be length 2 or more.
    public boolean scoresIncreasing(int[] scores) {

        for (int x = 0; x < scores.length - 1; x++) {
            if (scores[x + 1] < scores[x]) {
                return false;
            }
        }

        return true;

    }

    // Given an array of scores, return true if there are scores of 100 next to each other in the array.
    // The array length will be at least 2.
    public boolean scores100(int[] scores) {

        for (int i = 0; i < scores.length - 1; i++) {
            if (scores[i] == 100 && scores[i + 1] == 100) {
                return true;
            }
        }

        return false;

    }

    // Given an array of scores sorted in increasing order, return true if the array contains 3 adjacent
    // scores that differ from each other by at most 2, such as with {3, 4, 5} or {3, 5, 5}.
    public boolean scoresClump(int[] scores) {

        for (int i = 0; i < scores.length - 2; i++) {
            if (scores[i + 2] - scores[i] <= 2) {
                return true;
            }
        }

        return false;
    }

    // Given an array of scores, compute the int average of the first half and the second half,
    // and return whichever is larger. We'll say that the second half begins at index length/2.
    // The array length will be at least 2.
    public int scoresAverage(int[] scores) {

        int start = 0;
        int end = 0;
        int len = scores.length / 2;

        for (int i = 0; i < len; i++) {
            start += scores[i];
            end += scores[i + len];
        }

        start = start / len;
        end = end / len;

        return start > end ? start : end;
    }

    // Given an array of strings, return the count of the number of strings with the given length.
    public int wordsCount(String[] words, int len) {

        int result = 0;

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == len) {
                result++;
            }
        }

        return result;
    }

    // Given an array of strings, return a new array containing the first N strings. N will be in the range 1..length.
    public String[] wordsFront(String[] words, int n) {

        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            result[i] = words[i];
        }


        return result;
    }

    // Given an array of strings, return a new List (e.g. an ArrayList) where all the strings of the given
    // length are omitted. See wordsWithout() below which is more difficult because it uses arrays.
    public List wordsWithoutList(String[] words, int len) {

        List<String> result = new ArrayList<>();
        List<String> temp = new ArrayList<>(Arrays.asList(words));

        for (int i = 0; i < words.length; i++) {
            if (temp.get(i).length() != len) {
                result.add(words[i]);
            }
        }

        return result;
    }

    //

}
