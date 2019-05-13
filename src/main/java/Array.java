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

    public int[] solution3(int[] A, int K) {
        int size = A.length;
        int[] result = new int[size];

        for (int iteration = 1; iteration <= K; iteration++) {
            for (int i = size - 1; i > 0; i--) {
                int current = A[i];
                A[i] = A[i - 1];
                A[i - 1] = current;
            }
        }

        return A;
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

        return Arrays.equals(a, b);


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

        return one > four;
    }

    public boolean isEverywhere(int[] nums, int val) {

        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] + 1 == nums[i + 1]) {
                count++;
            }

        }
        return count == val;
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
        return (two == four);
    }

    // Given an array of ints, return true if there is a 1 in the array
    // with a 2 somewhere later in the array.
    public boolean has12(int[] nums) {

        boolean count = false;

        for (int num : nums) {

            if (num == 1) {
                count = true;
            }
            if (num == 2 && count) {
                return true;
            }
        }

        return false;
    }

    // Return the sum of the numbers in the array, except ignore sections
    // of numbers starting with a 6 and extending to the next 7
    // (every 6 will be followed by at least one 7). Return 0 for no numbers.
    public int sum67(int[] nums) {

        boolean flagOfSixe = false;
        int sum = 0;

        for (int num : nums) {

            if (num == 6) {
                flagOfSixe = true;
                continue;
            }
            if (num == 7 && flagOfSixe) {
                flagOfSixe = false;
                continue;
            }
            if (!flagOfSixe) {
                sum += num;
            }
        }
        return sum;
    }

    // Given an array of ints, return true if the value 3 appears in the array
    // exactly 3 times, and no 3's are next to each other.
    public boolean haveThree(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int three = 0;
        boolean flag = false;

        for (int num : nums) {
            if (flag && num == 3) {
                return false;
            }
            if (num != 3) {
                flag = false;
            }
            if (num == 3) {
                three++;
                flag = true;
            }
        }

        return three == 3;

    }

    // Return an array that is "left shifted" by one -- so {6, 2, 5, 3}
    // returns {2, 5, 3, 6}. You may modify and return the given array, or return a new array
    public int[] shiftLeft(int[] nums) {

        if (nums.length == 0) return nums;
        int temp = nums[0];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[(i + 1) % nums.length];
        }

        nums[nums.length - 1] = temp;

        return nums;
    }

    // Given an array of ints, return true if every 2 that appears in the array is next to another 2.
    public boolean twoTwo(int[] nums) {

        boolean flag = true;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 2) {

                if ((i != 0 && nums[i - 1] == 2) || (nums.length - 1 > i && nums[i + 1] == 2)) {
                    flag = true;
                    i++;
                } else {
                    flag = false;
                }
            }
        }
        return flag;
    }

    // For each multiple of 10 in the given array, change all the values following it to be
    // that multiple of 10, until encountering another multiple of 10.
    // So {2, 10, 3, 4, 20, 5} yields {2, 10, 10, 10, 20, 20}.
    public int[] tenRun(int[] nums) {

        int[] result = new int[nums.length];
        // boolean flag = true;
        int temp;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] % 10 != 0) {
                result[i] = nums[i];
                continue;
            } else {
                temp = nums[i];
            }
            result[i] = temp;

        }
        return result;
    } //TODO

    // Given a non-empty array of ints, return a new array containing the elements from the
    // original array that come before the first 4 in the original array. The original array will
    // contain at least one 4. Note that it is valid in java to create an array of length 0.
    public int[] pre4(int[] nums) {

        int four = 0;
        for (int num : nums) {
            if (num == 4) {
                break;
            }
            four++;
        }

        int[] result = new int[four];

        System.arraycopy(nums, 0, result, 0, four);

        return result;
    }

    // Given a non-empty array of ints, return a new array containing the elements from the
    // original array that come after the last 4 in the original array. The original array will
    // contain at least one 4. Note that it is valid in java to create an array of length 0.
    public int[] post4(int[] nums) {

        int four = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 4) {
                four = i;
            }
        }

        int[] result = new int[nums.length - four - 1];
        for (int i = 0; i < nums.length - four - 1; i++) {
            result[i] = nums[four + i + 1];
        }

        return result;

    }




}
