package LE.easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber_136 {
    /*给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
示例 1:输入: [2,2,1]     输出: 1
示例 2:输入: [4,1,2,1,2]     输出: 4
     */
    private int singleNumber(int[] nums) {
        return singleNumber3(nums);
    }
    //排序后只遍历一次就可以找出该数
    private int singleNumber1(int[] numbs){
        Arrays.sort(numbs);
        for(int i=0;i<numbs.length;){
            if(i+1==numbs.length||numbs[i]!=numbs[i+1])return numbs[i];
            i+=2;
        }
        return 0;
    }
    //hash表 复杂度：n
    private int singleNumber2(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            Integer count = map.get(i);
            count = count == null ? 1 : ++count;
            map.put(i, count);
        }
        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count == 1) {
                return i;
            }
        }
        return -1; // can't find it.
    }
    //异或
//    方法 4：位操作
//            概念
//
//    如果我们对 0 和二进制位做 XOR 运算，得到的仍然是这个二进制位
//    a \oplus 0 = aa⊕0=a
//    如果我们对相同的二进制位做 XOR 运算，返回的结果是 0
//    a \oplus a = 0a⊕a=0
//    XOR 满足交换律和结合律
//    a \oplus b \oplus a = (a \oplus a) \oplus b = 0 \oplus b = ba⊕b⊕a=(a⊕a)⊕b=0⊕b=b
//    所以我们只需要将所有的数进行 XOR 操作，得到那个唯一的数字。
    private int singleNumber3(int[] nums){
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }
    @Test
    public void testSingleNumber(){
        Long currTime1 = System.currentTimeMillis();
        Boolean flag = test1() && test2();
        Long currTime2 = System.currentTimeMillis();
        System.out.println("耗时："+(currTime2-currTime1)+"毫秒，测试"+(flag?"通过":"不通过"));
    }
    private Boolean test1(){
        int[] numbs = {2,2,1};
        Boolean flag = 1==singleNumber(numbs);
        System.out.println("测试1"+(flag?"通过":"不通过"));
        return flag;
    }
    private Boolean test2(){
        int[] numbs = {4,1,2,1,2};
        Boolean flag = 4==singleNumber(numbs);
        System.out.println("测试2"+(flag?"通过":"不通过"));
        return flag;
    }

}
