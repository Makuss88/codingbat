import java.util.Arrays;

public class Array2 {

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


    // We'll say that a value is "everywhere" in an array if for every pair of adjacent elements in the array,
    // at least one of the pair is that value. Return true if the given value is everywhere in the array.
    public boolean isEverywhere(int[] nums, int val) {

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != val && nums[i + 1] != val)
                return false;
        }
        return true;
    }

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

        int temp = 0;
        boolean ten = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 10 == 0) {
                temp = nums[i];
                ten = true;
            } else {
                if (ten) {
                    nums[i] = temp;
                }
            }
        }
        return nums;
    }

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

    // We'll say that an element in an array is "alone" if there are values before and after it,
    // and those values are different from it. Return a version of the given array where every instance
    // of the given value which is alone is replaced by whichever value to its left or right is larger.
    public int[] notAlone(int[] nums, int val) {

        if (nums.length <= 2) {
            return nums;
        }

        int[] result = new int[nums.length];

        result[0] = nums[0];
        result[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length - 1; i++) {

            if (nums[i] == val && nums[i - 1] != val && nums[i + 1] != val) {
                if (nums[i - 1] > nums[i + 1]) {
                    result[i] = nums[i - 1];
                    continue;
                } else {
                    result[i] = nums[i + 1];
                    continue;
                }
            }
            result[i] = nums[i];
        }
        return result;
    }

    // Return an array that contains the exact same numbers as the given array, but rearranged so that
    // all the zeros are grouped at the start of the array. The order of the non-zero numbers does not
    // matter. So {1, 0, 0, 1} becomes {0 ,0, 1, 1}. You may modify and return the given array or make a new array.
    public int[] zeroFront(int[] nums) {

        if (nums.length == 0) {
            return nums;
        }

        int zeros = 0;
        int temp = 0;
        int result[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
                result[i] = nums[i];
            } else {
                temp = nums[i];
            }
        }

        for (int i = zeros; i < nums.length; i++) {
            result[i] = temp;
        }
        return result;
    }

    // Return a version of the given array where all the 10's have been removed. The remaining elements should
    // shift left towards the start of the array as needed, and the empty spaces a the end of the array should be 0.
    // So {1, 10, 10, 2} yields {1, 2, 0, 0}. You may modify and return the given array or make a new array.
    public int[] withoutTen(int[] nums) {

        int result[] = new int[nums.length];
        int count = 0;

        for (int num : nums) {
            if (num % 10 != 0) {
                result[count] = num;
                count++;
            }
        }
        return result;

    }

    // Return a version of the given array where each zero value in the array is replaced by the largest odd value to
    // the right of the zero in the array. If there is no odd value to the right of the zero, leave the zero as a zero.
    public int[] zeroMax(int[] nums) {

        int max;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                max = 0;
                for (int k = i + 1; k < nums.length; k++) {

                    if (nums[k] > max && nums[k] % 2 == 1) {
                        max = nums[k];
                    }
                }
                if (max != 0) {
                    nums[i] = max;
                }
            }
        }
        return nums;

    }

    // Return an array that contains the exact same numbers as the given array, but rearranged so that all the even
    // numbers come before all the odd numbers. Other than that, the numbers can be in any order. You may modify and
    // return the given array, or make a new array.
    public int[] evenOdd(int[] nums) {

        int odd = 0;
        int even = 0;
        int result[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                odd++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                result[even] = nums[i];
                even++;
            } else {
                result[odd] = nums[i];
                odd++;
            }
        }

        return result;
    }

    // This is slightly more difficult version of the famous FizzBuzz problem which is sometimes given as a first
    // problem for job interviews. (See also: FizzBuzz Code.) Consider the series of numbers beginning at start and
    // running up to but not including end, so for example start=1 and end=5 gives the series 1, 2, 3, 4. Return a new
    // String[] array containing the string form of these numbers, except for multiples of 3, use "Fizz" instead of the
    // number, for multiples of 5 use "Buzz", and for multiples of both 3 and 5 use "FizzBuzz". In Java,
    // String.valueOf(xxx) will make the String form of an int or other type. This version is a little more complicated
    // than the usual version since you have to allocate and index into an array instead of just printing, and we vary
    // the start/end instead of just always doing 1..100.
    public String[] fizzBuzz(int start, int end) {

        String[] result = new String[end - start];

        int count = 0;

        for (int i = start; i < end; i++) {

            if (i % 5 == 0 && i % 3 == 0) {
                result[count] = "FizzBuzz";
            } else if (i % 5 == 0) {
                result[count] = "Buzz";
            } else if (i % 3 == 0) {
                result[count] = "Fizz";
            } else {
                result[count] = String.valueOf(i);
            }
            count++;
        }
        return result;
    }

}