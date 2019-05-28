public class Array3 {

    // Consider the leftmost and righmost appearances of some value in an array. We'll say that the "span"
    // is the number of elements between the two inclusive. A single value has a span of 1. Returns the largest span
    // found in the given array. (Efficiency is not a priority)
    public int maxSpan(int[] nums) {

        if (nums.length < 2) {
            return nums.length;
        }

        int leftCount = 0;
        int rightCount = 0;
        int leftNumber = nums[0];
        int rightNumber = nums[nums.length - 1];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == leftNumber) {
                leftCount = i + 1;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == rightNumber) {
                rightCount = nums.length - i;
            }
        }

        if (leftCount > rightCount) {
            return leftCount;
        } else {
            return rightCount;
        }
    }

    // the same method, but in one loop - it's faster
    public int maxSpan2(int[] nums) {

        if (nums.length < 2) {
            return nums.length;
        }

        int leftCount = 1;
        int rightCount = 1;
        int leftNumber = nums[0];
        int rightNumber = nums[nums.length - 1];
        boolean right = true;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == leftNumber) {
                leftCount = i + 1;
            }
            if (nums[i] == rightNumber && right) {
                right = false;
                rightCount = nums.length - i;
            }
        }


        if (leftCount > rightCount) {
            return leftCount;
        } else {
            return rightCount;
        }
    }

    // Return an array that contains exactly the same numbers as the given array, but rearranged so that every 3 is
    // immediately followed by a 4. Do not move the 3's, but every other number may move. The array contains the same
    // number of 3's and 4's, every 3 has a number after it that is not a 3, and a 3 appears in the array before any 4.
    public int[] fix34(int[] nums) {

        int four = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 3) {

                for (int j = four; j < nums.length; j++) {
                    if (nums[j] == 4) {
                        int temp = nums[i + 1];
                        nums[i + 1] = 4;
                        nums[j] = temp;
                        four = j;
                        break;
                    }
                }
            }
        }
        return nums;
    }

    // (This is a slightly harder version of the fix34 problem.) Return an array that contains exactly the same numbers
    // as the given array, but rearranged so that every 4 is immediately followed by a 5. Do not move the 4's, but
    // every other number may move. The array contains the same number of 4's and 5's, and every 4 has a number after
    // it that is not a 4. In this version, 5's may appear anywhere in the original array.
    public int[] fix45(int[] nums) {

        int five = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 4) {
                continue;
            }
            for (int j = five; j < nums.length; j++) {

                if (nums[j] != 5) {
                    continue;
                }
                if (j != 0 && nums[j - 1] == 4) {
                    continue;
                }
                int temp = nums[i + 1];
                nums[i + 1] = 5;
                nums[j] = temp;
                five = j;
                break;
            }
        }
        return nums;
    }

    // Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers
    // on one side is equal to the sum of the numbers on the other side.
    public boolean canBalance(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            int left = 0;
            int right = 0;

            for (int j = 0; j < i + 1; j++) {
                left += nums[j];
            }

            for (int j = i + 1; j < nums.length; j++) {
                right += nums[j];
            }

            if (left == right) {
                return true;
            }
        }
        return false;
    }

    // the same method, faster in my opinion...
    public boolean canBalance2(int[] nums) {


        int sum = 0;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            left += nums[i];
            if (left == sum - left) {
                return true;
            }
        }
        return false;
    }

    // Given two arrays of ints sorted in increasing order, outer and inner, return true if all of the numbers in
    // inner appear in outer. The best solution makes only a single "linear" pass of both arrays, taking advantage
    // of the fact that both arrays are already in sorted order.
    public boolean linearIn(int[] outer, int[] inner) {

        int innerLength = 0;

        for (int i = 0; i < inner.length; i++) {
            for (int j = i; j < outer.length; j++) {
                if (inner[i] == outer[j]) {
                    innerLength++;
                    break;
                }
            }
        }
        return innerLength == inner.length;
    }

    // Given n>=0, create an array length n*n with the following pattern, shown here for n=3 :
    // {0, 0, 1,    0, 2, 1,    3, 2, 1} (spaces added to show the 3 groups).
    public int[] squareUp(int n) {

        int result[] = new int[n * n];
        int counter = n;
        int number = 1;

        for (int i = n * n - 1; i >= 0; i--) {

            if ((i + 1) % n == 0) {
                number = 1;
                counter--;
            }
            if (counter < number - 1) {
                result[i] = 0;
                continue;
            }
            result[i] = number;
            number++;
        }

        return result;
    }

    // Given n>=0, create an array with the pattern {1,    1, 2,    1, 2, 3,   ... 1, 2, 3 .. n} (spaces added to
    // show the grouping). Note that the length of the array will be 1 + 2 + 3 ... + n, which is known to sum to
    // exactly n*(n + 1)/2.
    public int[] seriesUp(int n) {

        int result[] = new int[n * (n + 1) / 2];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < i + 2; j++) {
                result[count] = j;
                count++;
            }
        }
        return result;
    }

    // We'll say that a "mirror" section in an array is a group of contiguous elements such that somewhere in the
    // array, the same group appears in reverse order. For example, the largest mirror section in
    // {1, 2, 3, 8, 9, 3, 2, 1} is length 3 (the {1, 2, 3} part). Return the size of the largest mirror section
    // found in the given array.
    public int maxMirror(int[] nums) {

        int result = 0;

        for (int start = 0; start < nums.length; start++) {

            for (int begin = nums.length - 1; begin >= 0; begin--) {

                int size = 0;
                int i = start;
                int j = begin;

                while (i < nums.length && j >= 0 && nums[i] == nums[j]) {
                    size++;
                    i++;
                    j--;
                }

                result = Math.max(result, size);
            }
        }

        return result;
    }

    // Say that a "clump" in an array is a series of 2 or more adjacent elements of the same value.
    // Return the number of clumps in the given array.
    public int countClumps(int[] nums) {

        int result = 0;
        boolean flag = true;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                if (flag) {
                    result++;
                    flag = false;
                }
            } else {
                flag = true;
            }
        }

        return result;

    }


}
