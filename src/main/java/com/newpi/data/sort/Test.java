package com.newpi.data.sort;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date: 2021/1/26 2:37 PM
 * @desc:
 */
public class Test {

    Integer[] data = new Integer[]{4, 5, 6, 3, 2, 1};

    @org.junit.Test
    public void testBubbleSort() {

        Sort.bubbleSort(data);
        Sort.visit(data);
    }

    @org.junit.Test
    public void testInsertSort() {

        Sort.insertSort(data);
        Sort.visit(data);
    }


    @org.junit.Test
    public void testSelectionSort() {

        Sort.selectionSort(data);
        Sort.visit(data);
    }


    @org.junit.Test
    public void testMergeSort() {

        Sort.mergeSort(data);
        Sort.visit(data);
    }

    @org.junit.Test
    public void testQuickSort() {

//        Sort.quickSort(data);
        Sort.quickSort(new Integer[]{-1,0,1,2,-1,-4});
//        Sort.visit(data);
    }

    @org.junit.Test
    public void testFindKthElement() {
        Integer element = Sort.findKthElement(data, 3);
        System.out.println(element);
        element = Sort.findKthElement(data, 4);
        System.out.println(element);
        element = Sort.findKthElement(data, 2);
        System.out.println(element);
    }
}
