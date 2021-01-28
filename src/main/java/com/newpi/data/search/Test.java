package com.newpi.data.search;

import java.math.BigDecimal;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date: 2021/1/27 8:19 PM
 * @desc:
 */
public class Test {

    private Integer[] data = new Integer[]{1,2,3,3,3,4,5,7,8,8,9,10,12,12,16};

    @org.junit.Test
    public void testSqrt(){

        BigDecimal bigDecimal = BinarySearch.sqrt(new BigDecimal(1200D));

        System.out.println(bigDecimal.doubleValue());

    }

    @org.junit.Test
    public void testFindFirstEqualValue(){
        System.out.println(BinarySearch.findFirstEqualValue(data,3));
        System.out.println(BinarySearch.findFirstEqualValue(data,6));
    }

    @org.junit.Test
    public void testFindLastEqualValue(){
        System.out.println(BinarySearch.findLastEqualValue(data,3));
        System.out.println(BinarySearch.findLastEqualValue(data,6));
    }

    @org.junit.Test
    public void findFirstEqualOrBiggerValue(){
        System.out.println(BinarySearch.findFirstEqualOrBiggerValue(data,3));
        System.out.println(BinarySearch.findFirstEqualOrBiggerValue(data,6));
        System.out.println(BinarySearch.findFirstEqualOrBiggerValue(data,11));
    }

    @org.junit.Test
    public void findValueInRotatedArray(){
//        Integer[] data = new Integer[]{7,8,9,10,1,2,3,4,5,6};
        Integer[] data = new Integer[]{4,5,6,7,8,1,2,3};
//        System.out.println(BinarySearch.findEqualValueInRotatedSortedArray(data,9));
//        System.out.println(BinarySearch.findEqualValueInRotatedSortedArray(data,7));
//        System.out.println(BinarySearch.findEqualValueInRotatedSortedArray(data,10));
//        System.out.println(BinarySearch.findEqualValueInRotatedSortedArray(data,1));
//        System.out.println(BinarySearch.findEqualValueInRotatedSortedArray(data,4));
//        System.out.println(BinarySearch.findEqualValueInRotatedSortedArray(data,6));
        System.out.println(BinarySearch.findEqualValueInRotatedSortedArray(data,8));
    }
}
