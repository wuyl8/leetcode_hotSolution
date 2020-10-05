package LE.medium;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum_15 {
    /*
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
注意：答案中不可以包含重复的三元组。
示例：给定数组 nums = [-1, 0, 1, 2, -1, -4]
满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

     */
    public List<List<Integer>> threeSum(int[] nums) {
        return threeSum2(nums);
    }
    private List<List<Integer>> twoSum(int[] numbs,int target,int exsit){
        List<List<Integer>> list = new ArrayList<>();
        // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        for(int i = 0; i < numbs.length; i++){
            if(i==exsit) continue;
            if(hashMap.containsKey(numbs[i])){
                List<Integer> paramList = new ArrayList<>();
                paramList.add(numbs[exsit]);
                paramList.add(target-numbs[i]);
                paramList.add(numbs[i]);
                Collections.sort(paramList);
                list.add(paramList);
            }
            // 将数据存入 key为补数 ，value为下标
            hashMap.put(target-numbs[i],i);
        }
        return list;
    }
//自己写的方法 超时了。。。 优化方向 去重逻辑的去除
    private List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        for(int i = 0;i<nums.length;i++){
            int target = 0-nums[i];
            //寻找两数和为mix的 数组后面的数集合
            List<List<Integer>> paramList = twoSum(nums,target,i);
            list.addAll(paramList);
        }
        return list.stream().distinct().collect(Collectors.toList());
    }
//排序后 双指针，[-4,-1,-1,0,1,2]
    private List<List<Integer>> threeSum2(int[] numbs) {
        List<List<Integer>> returnList = new LinkedList<>();
        Arrays.sort(numbs);

        for(int first=0;first<numbs.length-1;first++){
            //枚举值重复直接跳过，避免重复
            if (first>0 && numbs[first] == numbs[first-1]) continue;
            int third = numbs.length-1;
            int target = -numbs[first];
            for(int second =first+1;second<numbs.length-1;second++){
                if(second>first+1 && numbs[second]==numbs[second-1]) continue;
                //保持右指针始终在左指针的右边
                while (second < third && numbs[third]+numbs[second] > target){
                    third --;
                }
                if (third == second) break;
                if(target == numbs[second]+numbs[third]){
                    List list = new ArrayList();
                    list.add(numbs[first]);
                    list.add(numbs[second]);
                    list.add(numbs[third]);
                    returnList.add(list);
                }
            }
        }
        return returnList;
    }

    @Test
    public void test(){
        Long currTime1 = System.currentTimeMillis();
        boolean flag = test1() && test2() &&test3() && test4() && test5();
        Long currTime2 = System.currentTimeMillis();
        System.out.println("耗时："+(currTime2-currTime1)+"毫秒，测试"+(flag?"通过":"不通过"));
    }
    private boolean test1(){
        int[] numbs = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = threeSum(numbs);
        System.out.println("test1返回："+list.toString()+",测试通过");
        return true;
    }
    private boolean test2(){
        int[] numbs = {1,8,6,2,5,4,8,3,7};
        List<List<Integer>> list = threeSum(numbs);
        System.out.println("test2返回："+list.toString()+",测试通过");
        return true;
    }
    private boolean test3(){
        int[] numbs = {0,0,0,0};
        List<List<Integer>> list = threeSum(numbs);
        System.out.println("test3返回："+list.toString()+",测试通过");
        return true;
    }
    private boolean test4(){
        int[] numbs = {1,2,-2,-1};
        List<List<Integer>> list = threeSum(numbs);
        System.out.println("test4返回："+list.toString()+",测试通过");
        return true;
    }
    private boolean test5(){
        //[-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]
        //[[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2]]
        int[] numbs = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> list = threeSum(numbs);
        System.out.println("test5返回："+list.toString()+",测试通过");
        return true;
    }
}
