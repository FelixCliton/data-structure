package com.newpi.data.search;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date: 2021/1/27 7:42 PM
 * @desc:
 */
public class BinarySearch {

    /**
     * 求 X 的平方根，要求精确到小数点后六位
     *
     * @param x
     *
     * @return
     */
    public static BigDecimal sqrt(BigDecimal x) {

        Double max = Math.sqrt(Double.MAX_VALUE);
        Double min = 0D;
        Double mid = (max + min) / 2 - 0.000001;


        while (true) {
            if ((mid - 0.000001) * (mid - 0.000001) - x.doubleValue() <= 0 && (mid + 0.000001) * (mid + 0.000001) - x.doubleValue() >= 0) {
                break;
            }
            if ((mid + 0.000001) * (mid + 0.000001) - x.doubleValue() < 0) {
                min = mid;
            }
            if ((mid - 0.000001) * (mid - 0.000001) - x.doubleValue() > 0) {
                max = mid;
            }
            mid = (max + min) / 2;
        }
        return new BigDecimal(mid).setScale(6, RoundingMode.HALF_UP);
    }

    public static Integer findFirstEqualValue(Integer[] data, int k) {
        if (null == data || data.length <= 0) {
            return null;
        }
        int low = 0;
        int high = data.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (data[mid] > k) {
                high = mid - 1;
            } else if (data[mid] < k) {
                low = mid + 1;
            } else {
                if (mid == 0 || data[mid - 1] != k) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static Integer findLastEqualValue(Integer[] data, int k) {
        if (null == data || data.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = data.length - 1;

        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (data[mid] <= k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (low <= high && data[low] == k) {
            return low;
        }
        return -1;
    }

    public static Integer findFirstEqualOrBiggerValue(Integer[] data, int k) {
        if (null == data || data.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = data.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (data[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }


    public static Integer findEqualValueInRotatedSortedArray(Integer[] data, int k) {
        if (null == data || data.length == 0) {
            return -1;
        }

        int low = 0;
        int high = data.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (data[mid] == k) {
                return mid;
            }
            if (data[mid] <= data[high]) {
                if (data[mid] < k && data[high] >= k) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (data[mid] > k && data[low] <= k) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
