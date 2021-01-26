package com.newpi.data.sort;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date: 2021/1/26 9:55 AM
 * @desc:
 */
public class Sort {

    public static void bubbleSort(Integer[] data) {
        for (int i = 0; i < data.length; i++) {
            boolean swapFlag = false;
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    Integer temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    swapFlag = true;
                }
            }
            if (!swapFlag) {
                break;
            }
        }
    }


    public static void insertSort(Integer[] data) {

        if (data.length <= 1) {
            return;
        }
        for (int i = 1; i < data.length; i++) {
            int value = data[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (data[j] > value) {
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            data[j + 1] = value;
        }
    }

    /**
     * 选择排序算法的实现思路有点类似插入排序，也分已排序区间和未排序区间。但是选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
     *
     * @param data
     */
    public static void selectionSort(Integer[] data) {

        if (data.length <= 1) {
            return;
        }

        for (int i = 0; i < data.length; i++) {
            int k = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[k] > data[j]) {
                    k = j;
                }
            }
            Integer temp = data[i];
            data[i] = data[k];
            data[k] = temp;
        }

    }


    /**
     * @param data
     */
    public static void mergeSort(Integer[] data) {
        mergeSort(data, 0, data.length - 1);
    }


    private static void mergeSort(Integer[] data, int left, int right) {

        if (left >= right) {
            return;
        }

        int middle = (left + right) / 2;

        mergeSort(data, left, middle);
        mergeSort(data, middle + 1, right);
        merge(data, left, middle, right);
    }

    private static void merge(Integer[] data, int left, int middle, int right) {
        Integer[] temp = new Integer[right - left + 1];
        int k = 0;
        int i = left;
        int j = middle + 1;
        while (i <= middle && j <= right) {
            if (data[i] > data[j]) {
                temp[k++] = data[j++];
            } else {
                temp[k++] = data[i++];
            }
        }
        if (i <= middle) {
            for (; i <= middle; i++) {
                temp[k++] = data[i];
            }
        }
        if (j <= right) {
            for (; j <= right; j++) {
                temp[k++] = data[j];
            }
        }
        for (i = 0; i < temp.length; i++) {
            data[left + i] = temp[i];
        }
    }


    public static void quickSort(Integer[] data) {
        quickSort(data, 0, data.length - 1);
    }

    private static void quickSort(Integer[] data, int left, int right) {

        if (left >= right) {
            return;
        }

        int p = partition(data, left, right);
        quickSort(data, left, p);
        quickSort(data, p + 1, right);
    }

    private static int partition(Integer[] data, int left, int right) {
        Integer pivot = data[left];
        int i = left;
        int j = right;
        while (i < j) {

            while (i < j && data[j] > pivot) {
                j--;
            }
            if (i < j) {
                data[i++] = data[j];
            }

            while (i < j && data[i] < pivot) {
                i++;
            }
            if (i < j) {
                data[j--] = data[i];
            }
        }
        data[i] = pivot;
        return i;
    }

    public static Integer findKthElement(Integer[] data, int k) {

        if (k > data.length) {
            return null;
        }
        int index= findKthElement(data, k, 0, data.length - 1);
        return data[index];
    }

    private static int findKthElement(Integer[] data, int k, int left, int right) {
        int p = partition(data, left, right);
        if (p + 1 == k) {
            return p;
        } else {
            if (p + 1 < k) {
                return findKthElement(data, k, p + 1, right);
            } else {
                return findKthElement(data, k, left, p);
            }
        }
    }

    public static void visit(Integer[] data) {
        for (Integer num : data) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
