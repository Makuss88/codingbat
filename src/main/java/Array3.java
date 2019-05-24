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

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == leftNumber) {
                leftCount = i;
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

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == leftNumber) {
                leftCount = i;
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


}
