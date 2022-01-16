package com.newpi.data.search;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date: 2021/5/18 3:34 PM
 * @desc:
 */
public class BinarySearch2 {

    public static int findFirstEqualValue(int[] nums, int k) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (nums[mid] > k) {
                high = mid - 1;
            } else if (nums[mid] < k) {
                low = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] != k) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -1;
    }


    public static int findLastEqualValue(int[] nums, int k) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (nums[mid] > k) {
                high = mid - 1;
            } else if (nums[mid] < k) {
                low = mid + 1;
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] != k) {
                    return mid;
                }
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int findFirstBiggerOrEqualValue(int[] nums, int k) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] < k) {
                low = mid + 1;
            } else if (nums[mid] >= k) {
                high = mid;
            }
        }
        if (nums[low] >= k) {
            return low;
        }
        return -1;
    }

}
