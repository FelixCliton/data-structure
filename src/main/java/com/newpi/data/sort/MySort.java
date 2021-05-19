package com.newpi.data.sort;

import java.util.Arrays;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date: 2021/5/17 4:35 PM
 * @desc:
 */
public class MySort {


    public static void visit(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            boolean swapFlag = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapFlag = true;
                }
            }
            if (!swapFlag) {
                break;
            }
        }
        visit(nums);
    }


    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int k = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[k] > nums[j]) {
                    k = j;
                }
            }
            if (i != k) {
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
            }
        }
        visit(nums);
    }

    public static void insertSort(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] > temp) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = temp;

        }

        visit(nums);
    }

    public static void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        visit(nums);
    }

    private static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        mergeSort(nums, left, middle);
        mergeSort(nums, middle + 1, right);
        merge(nums, left, right, middle);
    }

    private static void merge(int nums[], int left, int right, int middle) {
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= right) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        if (i <= middle) {
            for (; i <= middle; i++) {
                temp[k++] = nums[i];
            }
        }
        if (j <= right) {
            for (; j <= right; j++) {
                temp[k++] = nums[j];
            }
        }
        for (i = 0; i < temp.length; i++) {
            nums[left + i] = temp[i];
        }

    }

    public static void quickSort(int[] nums) {
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
            while (i < j && nums[j] > pivot) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }

            while (i < j && nums[i] < pivot) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = pivot;
        return i;
    }


    public static int findKthSmallElement(int[] nums, int k) {
        if (null == nums || nums.length < k) {
            return -1;
        }
        int index = findKthSmallElement(nums, k, 0, nums.length - 1);
        return nums[index];
    }

    private static int findKthSmallElement(int[] nums, int k, int left, int right) {
        int pivot = partition(nums, left, right);
        if (pivot + 1 == k) {
            return pivot;
        }
        if (pivot + 1 < k) {
            return findKthSmallElement(nums, k, pivot + 1, right);
        } else {
            return findKthSmallElement(nums, k, left, pivot);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 3, 4, 2, 1};
        bubbleSort(Arrays.copyOf(nums, nums.length));

        selectSort(Arrays.copyOf(nums, nums.length));

        insertSort(Arrays.copyOf(nums, nums.length));

        mergeSort(Arrays.copyOf(nums, nums.length));

        quickSort(Arrays.copyOf(nums, nums.length));

        System.out.println(findKthSmallElement(nums, 3));

        System.out.println(findKthSmallElement(nums, 2));
    }
}
