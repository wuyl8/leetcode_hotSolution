package LE.easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
/*
    给予一个数组，与一整数。查找出数组中两数和相加为整数的两个下标
 */
public class TwoSum_53 {

    public int[] twoSum1(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] == target-nums[j]){
                    return new int[] {i,j};
                }
            }
        }
        throw new IllegalArgumentException("NO TWO SUM SOLUTION");
    }

    public  int[] twoSum2(int[] nums, int target){
        HashMap<Integer,Integer> hashMap = new HashMap();
        for (int i=0;i<nums.length;i++){
            hashMap.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int key = target-nums[i];
            if(hashMap.containsKey(target-nums[i]) && i!=hashMap.get(key)){
                return new int[]{i,hashMap.get(key)};
            }
        }
        throw new IllegalArgumentException("no two sum solution");
    }

    public int[] twoSum3(int[] nums,int target){
        HashMap<Integer,Integer> hashMap = new HashMap();
        for(int i=0;i<nums.length;i++){
            int key = target-nums[i];
            if(hashMap.containsKey(target-nums[i]) && i!=hashMap.get(key)){
                return new int[]{hashMap.get(key),i};
            }
            hashMap.put(nums[i],i);
        }
        throw new IllegalArgumentException("no two sum solution");
    }

    public int[] twoSum4(int[] nums, int target) {
        int[] indexs = new int[2];
        // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hashMap.containsKey(nums[i])){
                indexs[0] = hashMap.get(nums[i]);
                indexs[1] = i;
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hashMap.put(target-nums[i],i);
        }
        return indexs;
    }

    public int[] twoSum(int[] numbs,int target){
        return twoSum4(numbs,target);
    }

    @Test
    public void testTwoSum(){
        Boolean flag = testTwoSum1() && testTwoSum2()&&testTwoSum3()&&testTwoSum4();
        String message = flag?"通过":"不通过";
        System.out.println("测试"+message);
    }
    public  boolean testTwoSum1(){
        int[] numbs = {2,7,12,11};
        int target = 13;
        int[] trueResult = {0,3};
        int[] result = twoSum(numbs,target);
        //Arrays.sort(result);
        Boolean flag = Arrays.equals(trueResult,result);
        System.out.println("测试1结果："+flag+"，result={"+result[0]+","+result[1]+"}");
        return flag;
    }
    public  boolean testTwoSum2(){
        int[] numbs = {3,2,4};
        int target = 6;
        int[] trueResult = {1,2};
        int[] result = twoSum(numbs,target);
        //Arrays.sort(result);
        Boolean flag = Arrays.equals(trueResult,result);
        System.out.println("测试2结果："+flag+"，result={"+result[0]+","+result[1]+"}");
        return flag;
    }
    public  boolean testTwoSum3(){
        int[] numbs = {3,3};
        int target = 6;
        int[] result = twoSum(numbs,target);
        int[] trueResult = {0,1};
        //Arrays.sort(result);
        Boolean flag = Arrays.equals(trueResult,result);
        System.out.println("测试3结果："+flag+"，result={"+result[0]+","+result[1]+"}");
        return flag;
    }
    public  boolean testTwoSum4(){
        int[] numbs = {2,7,12,11};
        int target = 6;
        try{
            int[] result = twoSum(numbs,target);
        }catch(IllegalArgumentException e){
            System.out.println("测试用例4，通过");
            return true;
        }catch (Exception e){
            System.out.println("测试用例4，不通过");
            return false;
        }
        System.out.print("测试用例4，不通过");
        return false;
    }
}
