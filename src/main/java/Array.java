import java.util.Arrays;

public class Array {

    public int[] solution(int[] A, int K) {

        int count = K % A.length;
        int[] result = new int[A.length];

        for (int i = 0; i < count; i++) {
            int con = 0;
            for (int j = 0; j < A.length; j++) {
                if (j == 0) {
                    result[j] = A[A.length - 1];
                } else {
                    result[j] = A[con];
                    con++;
                }
            }
            A = Arrays.copyOf(result, result.length);
        }
        return result;
    }

    public int[] solution2(int[] A, int K) {

        if (A == null)
            return null;

        int count = A.length;

        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            result[(i + K) % count] = A[i];
        }

        return result;
    }

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

    public boolean has77(int[] nums) {

        if (nums.length <= 1) {
            return false;
        }

        for (int i = 2; i < nums.length; i++) {

            if ((nums[i - 2] == 7 && nums[i - 1] == 7) ||
                    (nums[i - 2] == 7 && nums[i] == 7)) {
                return true;
            }

            if ((nums[i - 1] == 7 && nums[i] == 7)) {
                return true;
            }
        }

        return false;

    }

    public int[] solution3(int[] A, int K) {
        int size = A.length;
        int[] result = new int[size];

        //  System.out.println(Arrays.toString(A));

        for (int iteration = 1; iteration <= K; iteration++) {
            for (int i = size - 1; i > 0; i--) {
                int current = A[i];
                A[i] = A[i - 1];
                A[i - 1] = current;
            }
        }

        //System.out.println(Arrays.toString(A));
        result = A;
        return result;
    }

    public boolean modThree(int[] nums) {

        for (int i = 0; i < nums.length - 2; i++) {

            if (nums[i] % 2 == 0 && nums[i + 1] % 2 == 0 && nums[i + 2] % 2 == 0) {
                return true;
            }
            if (nums[i] % 2 != 0 && nums[i + 1] % 2 != 0 && nums[i + 2] % 2 != 0) {
                return true;
            }

        }

        return false;
    }

    public boolean sameEnds(int[] nums, int len) {
        if (len == nums.length || len == 0) {
            return true;
        }

        int a[] = new int[len];
        int b[] = new int[len];

        for (int i = 0; i < len; i++) {
            a[i] = nums[i];
            b[i] = nums[nums.length - len + i];
        }

        if (Arrays.equals(a, b)) {
            return true;
        } else {
            return false;
        }


    }

    public boolean more14(int[] nums) {
        int one = 0;
        int four = 0;

        for (int num : nums) {
            if (num == 1) {
                one++;
            }
            if (num == 4) {
                four++;
            }
        }

        if (one > four) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEverywhere(int[] nums, int val) {

        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] + 1 == nums[i + 1]) {
                count++;
            }

        }
        if (count == val) {
            return true;
        }
        return false;
    } // doesn't work..

    public boolean either24(int[] nums) {
        if (nums.length < 2) {
            return false;
        }

        int two = 0;
        int four = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            if ((nums[i] == 2 && nums[i + 1] == 2)) {
                two++;
            }
            if ((nums[i] == 4 && nums[i + 1] == 4)) {
                four++;
            }

        }
        if (two == four) {
            return false;
        }
        return true;
    }
}
