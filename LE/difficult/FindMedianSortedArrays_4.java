package LE.difficult;

import org.junit.Test;

public class FindMedianSortedArrays_4 {
    /*
    给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
你可以假设 nums1 和 nums2 不会同时为空。
示例 1:
nums1 = [1, 3]
nums2 = [2]
则中位数是 2.0
示例 2:
nums1 = [1, 2]
nums2 = [3, 4]
则中位数是 (2 + 3)/2 = 2.5
     */
    public double findMedianSortedArrays(int[] numbs1,int[] numbs2) {
        return findMedianSortedArrays1(numbs1,numbs2);
    }
    private double findMedianSortedArrays1(int[] nums1, int[] nums2){
        int[] mix = nums1;
        return 2;
    }

    @Test
    public void testFindMedianSortedArrays(){
        Long currTime1 = System.currentTimeMillis();
        Boolean flag = test1() && test2();
        Long currTime2 = System.currentTimeMillis();
        System.out.println("耗时："+(currTime2-currTime1)+"毫秒，测试"+(flag?"通过":"不通过"));
    }
    private Boolean test1(){
        int[] numbs1 = {1,3};
        int[] numbs2 = {2};
        Boolean flag = 2.0==findMedianSortedArrays(numbs1,numbs2);
        return flag;
    }
    private Boolean test2(){
        int[] numbs1 = {1,2};
        int[] numbs2 = {3,4};
        Boolean flag = 2.5==findMedianSortedArrays(numbs1,numbs2);
        return flag;
    }
}
