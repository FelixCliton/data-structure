package com.newpi.data.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date 2021/5/18 22:09
 * @desc:
 */
public class Heap2 {

    public static void buildHeap(int[] nums) {
        visit(nums);
        for (int i = nums.length / 2; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }
        visit(nums);
    }

    /**
     * 大顶堆
     *
     * @param nums
     * @param rootIndex
     * @param length
     */
    public static void adjustHeap(int[] nums, int rootIndex, int length) {
        int leftChildIndex = 2 * rootIndex + 1 < length ? 2 * rootIndex + 1 : -1;
        int rightChildIndex = 2 * rootIndex + 2 < length ? 2 * rootIndex + 2 : -1;
        int largestIndex = rootIndex;

        if (leftChildIndex != -1 && nums[largestIndex] < nums[leftChildIndex]) {
            largestIndex = leftChildIndex;
        }
        if (rightChildIndex != -1 && nums[largestIndex] < nums[rightChildIndex]) {
            largestIndex = rightChildIndex;
        }
        if (largestIndex != rootIndex) {
            int temp = nums[rootIndex];
            nums[rootIndex] = nums[largestIndex];
            nums[largestIndex] = temp;
            adjustHeap(nums, largestIndex, length);
        }
    }

    public static void heapSort(int[] nums) {
        buildHeap(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            adjustHeap(nums, 0, i);
        }
        visit(nums);
    }

    public static void visit(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
        System.out.println();
    }



    public static void main(String[] args) {
        int[] nums = new int[]{3, 7, 8, 1, 10, 3, 4, 7, 5, 2, 6};
        heapSort(nums);
    }
}
