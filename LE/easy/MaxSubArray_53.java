package LE.easy;

import org.junit.Test;
/*
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:
输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubArray_53 {
    private int maxSubArray(int[] nums) {
        return maxSubArray3(nums);
    }
    //从左到右遍历比较
    public int maxSubArray1(int[] nums){
        int max = nums[0];
        int maxParam = nums[0];
        for(int j=0;j<nums.length;j++){
            if(nums[j]>maxParam){
                maxParam = nums[j];
            }
            if(nums[j]<=0 || (j>0 && nums[j-1]>0)){
                continue;
            }
            int result = 0;
            if(nums[j]>0){
                for(int i=j;i<nums.length;i++){
                    result += nums[i];
                    if(result>max){
                        max = result;
                    }
                }
            }
        }
        return max>maxParam?max : maxParam;
    }
//贪心算法
    private int maxSubArray2(int[] nums){
        int n = nums.length;
        int currSum = nums[0], maxSum = nums[0];

        for(int i = 1; i < n; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
    //动态规划
    private int maxSubArray3(int[] nums){
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
    @Test
    public void testMaxSubArray(){
        Boolean flag = test1()&&test2()&&test3()&&test4();
        String message = flag?"通过":"不通过";
        System.out.println("测试"+message);
    }
    private Boolean test1(){
        int[] numbs = {3,1,-3,4,-1,2,1,-5,4};
        Boolean flag = 7==maxSubArray(numbs);
        System.out.println("测试1"+(flag?"通过":"不通过"));
        return flag;
    }
    private Boolean test2(){
        int[] numbs = {-2,1,-3,4,-1,2,1,-5,4};
        Boolean flag = 6==maxSubArray(numbs);
        System.out.println("测试2"+(flag?"通过":"不通过"));
        return flag;
    }
    private Boolean test3(){
        int[] numbs = {-2,-1,0,1,0,-1,2};
        Boolean flag = 2==maxSubArray(numbs);
        System.out.println("测试3"+(flag?"通过":"不通过"));
        return flag;
    }
    private Boolean test4(){
        int[] numbs = {-2,-1};
        Boolean flag = -1==maxSubArray(numbs);
        System.out.println("测试4"+(flag?"通过":"不通过"));
        return flag;
    }
}
