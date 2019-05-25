public class Array3 {

    // Consider the leftmost and righmost appearances of some value in an array. We'll say that the "span"
    // is the number of elements between the two inclusive. A single value has a span of 1. Returns the largest span
    // found in the given array. (Efficiency is not a priority.)\
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


}
