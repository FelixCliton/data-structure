package com.newpi.data.sort;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date 2021/5/24 11:24
 * @desc:
 */
public class Sort2 {


    private static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j + 1] < nums[j]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        visit(nums);
    }

    private static void selectSort(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int k = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    k = j;
                }
            }
            if (k != i) {
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
            }
        }
        visit(nums);
    }

    private static void insertSort(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return;
        }

        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] > value) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = value;
        }
        visit(nums);
    }

    private static void quickSort(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
        visit(nums);
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot);
        quickSort(nums, pivot + 1, right);

    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }

        }
        nums[i] = pivot;
        return i;
    }

    private static void mergeSort(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return;
        }
        mergeSort(nums, 0, nums.length - 1);
        visit(nums);
    }

    private static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        if (left >= right) {
            return;
        }
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        if (i <= mid) {
            for (; i <= mid; i++) {
                temp[k++] = nums[i];
            }
        }
        if (j <= right) {
            for (; j <= right; j++) {
                temp[k++] = nums[j];
            }
        }
        for (k = 0; k < temp.length; k++) {
            nums[k + left] = temp[k];
        }
    }

    public static void visit(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 6, 1, 0, 6, 5, 2, 0, 10};
//        bubbleSort(nums);
//        selectSort(nums);
//        insertSort(nums);
//        quickSort(nums);
        mergeSort(nums);
    }
}
