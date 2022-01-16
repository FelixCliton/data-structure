package com.newpi.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date 2021/6/5 23:26
 * @desc:
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int target = 0 - nums[i];
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[low] + nums[high];
                if (target == sum) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[low]);
                    list.add(nums[high]);
                    result.add(list);
                    break;
                } else {
                    if (target < sum) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return result;
    }


    private static void sort(int[] nums) {
        qiuckSort(nums, 0, nums.length - 1);
    }

    private static void qiuckSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(nums, left, right);
        qiuckSort(nums, left, pivot - 1);
        qiuckSort(nums, pivot + 1, right);
    }


    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int mark = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                mark++;
                int p = nums[mark];
                nums[mark] = nums[i];
                nums[i] = p;
            }
        }
        nums[left] = nums[mark];
        nums[mark] = pivot;
        return mark;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
