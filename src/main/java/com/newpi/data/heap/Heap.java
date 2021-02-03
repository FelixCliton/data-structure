package com.newpi.data.heap;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date: 2021/2/1 6:59 PM
 * @desc:
 */
public class Heap {


    public static void buildHeap(Integer[] data) {
        for (int i = data.length / 2; i >= 0; i--) {
            heapAdjust(data, i, data.length);
        }
    }


    public static void insert(Integer[] data, Integer k) {

    }


    /**
     * 堆排序
     *
     * @param nums
     */
    public static void heapSort(Integer[] nums) {

        buildHeap(nums);
        for (int j = nums.length - 1; j >= 0; j--) {
            int temp = nums[j];
            nums[j] = nums[0];
            nums[0] = temp;
            heapAdjust(nums, 0, j);
        }
    }

    public static void heapAdjust(Integer[] nums, int rootIdx, int len) {
        int leftChildIdx = 2 * rootIdx < len ? 2 * rootIdx : -1;
        int rightChileIdx = 2 * rootIdx + 1 < len ? 2 * rootIdx + 1 : -1;
        int largestIdx = rootIdx;
        if (leftChildIdx != -1 && nums[largestIdx] < nums[leftChildIdx]) {
            largestIdx = leftChildIdx;
        }
        if (rightChileIdx != -1 && nums[largestIdx] < nums[rightChileIdx]) {
            largestIdx = rightChileIdx;
        }
        if (largestIdx != rootIdx) {
            int temp = nums[largestIdx];
            nums[largestIdx] = nums[rootIdx];
            nums[rootIdx] = temp;
            heapAdjust(nums, largestIdx, len);
        }
    }


    public static void visit(Integer[] data) {
        for (Integer num : data) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


}
