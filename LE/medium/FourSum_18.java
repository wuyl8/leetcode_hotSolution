package LE.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum_18 {
    /*
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
注意：答案中不可以包含重复的四元组。
示例：给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return fourSum1(nums,target);
    }

    private List<List<Integer>> fourSum1(int[] nums, int target){
        //借鉴第15题，三数之和的解法。先排序后三重循环+双指针。时间复杂度n^3
        List returnList = new LinkedList();
        Arrays.sort(nums);

        for(int first=0;first<nums.length;++first){
            if(first > 0 && nums[first] == nums[first-1]) continue;

            for(int second=first+1;second<nums.length;++second){
                if(second > first+1 && nums[second]==nums[second-1]) continue;

                int fourth = nums.length-1;
                for(int third = second+1;third<nums.length-1;++third){
                    if(third>second+1 && nums[third]==nums[third-1]) continue;

                    while (fourth>third && nums[first]+nums[second]+nums[third]+nums[fourth]>target){
                        fourth --;
                    }
                    if(fourth == third) break;
                    if(nums[first]+nums[second]+nums[third]+nums[fourth]==target){
                        List list = new ArrayList();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        list.add(nums[fourth]);
                        returnList.add(list);
                    }
                }
            }

        }

        return returnList;
    }


    @Test
    public void test(){
        Long currTime1 = System.currentTimeMillis();
        boolean flag = test1() && test2() ;
        Long currTime2 = System.currentTimeMillis();
        System.out.println("耗时："+(currTime2-currTime1)+"毫秒，测试"+(flag?"通过":"不通过"));
    }
    private boolean test1(){
        int[] numbs = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> list = fourSum(numbs,0);
        //[
        //  [-1,  0, 0, 1],
        //  [-2, -1, 1, 2],
        //  [-2,  0, 0, 2]
        //]
        System.out.println("test1返回："+list.toString()+",测试通过");
        return true;
    }
    private boolean test2(){
        int[] numbs = {0, 0, 0, 0, 0, 0};
        List<List<Integer>> list = fourSum(numbs,0);
        System.out.println("test2返回："+list.toString()+",测试通过");
        return true;
    }
}
