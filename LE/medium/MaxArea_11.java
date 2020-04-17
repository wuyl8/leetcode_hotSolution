package LE.medium;

import org.junit.Test;

public class MaxArea_11 {
/*
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
说明：你不能倾斜容器，且 n 的值至少为 2。
示例：输入：[1,8,6,2,5,4,8,3,7]       输出：49

 */
    public int maxArea(int[] height) {
        return maxArea2(height);
    }

    //暴力法双循环 n^2
    private int maxArea1(int[] height){
        int maxArea = 0;
        for (int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                maxArea = Math.max(maxArea,Math.min(height[i],height[j])*(j-i));
            }
        }
        return maxArea;
    }
    //双指针(动态规划)
    private int maxArea2(int[] height){
        int start = 0;
        int end = height.length-1;
        int maxArea = 0;
        while (start!=end){
            maxArea = Math.max(maxArea,Math.min(height[start],height[end])*(end-start));
            if(height[start]>height[end]){
                end--;
            }else{
                start++;
            }
        }
        return maxArea;
    }

    @Test
    public void test(){
        Long currTime1 = System.currentTimeMillis();
        boolean flag = test1() && test2();
        Long currTime2 = System.currentTimeMillis();
        System.out.println("耗时："+(currTime2-currTime1)+"毫秒，测试"+(flag?"通过":"不通过"));
    }
    private boolean test1(){
        int[] height = {1,8,6};
        boolean flag = 6 == maxArea(height);
        System.out.println("test1返回："+flag+",测试"+(flag?"通过":"不通过"));
        return flag;
    }
    private boolean test2(){
        int[] height = {1,8,6,2,5,4,8,3,7};
        boolean flag = 49 == maxArea(height);
        System.out.println("test2返回："+flag+",测试"+(flag?"通过":"不通过"));
        return flag;
    }
}
