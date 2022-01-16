package com.newpi.data.heap;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date: 2021/2/1 6:59 PM
 * @desc:
 */
public class Heap {


    public static void buildHeap(int[] data) {
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
    public static void heapSort(int[] nums) {

        buildHeap(nums);
        for (int j = nums.length - 1; j >= 0; j--) {
            int temp = nums[j];
            nums[j] = nums[0];
            nums[0] = temp;
            heapAdjust(nums, 0, j);
        }
    }

    public static void heapAdjust(int[] nums, int rootIdx, int len) {
        int leftChildIdx = 2 * rootIdx+1 < len ? 2 * rootIdx+1 : -1;
        int rightChileIdx = 2 * rootIdx + 2 < len ? 2 * rootIdx + 2 : -1;
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


    public static void visit(int[] data) {
        for (Integer num : data) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 7, 8, 1, 10, 3, 4, 7, 5, 2, 6};
        heapSort(nums);
        visit(nums);
    }
}
