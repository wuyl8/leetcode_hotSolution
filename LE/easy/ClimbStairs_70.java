package LE.easy;

import LE.utils.MathPlus;
import org.junit.Test;

/*
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶

8-34
1+1+1+1+1+1+1+1
2+1+1+1+1+1+1 7
2+2+1+1+1+1 15=C(6,2)
2+2+2+1+1   10=C(5,3)
2+2+2+2

10-89
                 1=C(10,0)
                 9=C(9,1)
2+2+1+1+1+1+1+1 28=C(8,2)=40320/2/720
2+2+2+1+1+1+1   35=C(7,3)
2+2+2+2+1+1     15=C(6,4)
                1=C(5,5)

计算公式：  ；
阶乘 factorial n!
C(n,m)=C(n,n-m）= n!/m!*(n-m)!。（n≥m)

爬到10阶=爬9阶+爬8阶。因此 f(n)=f(n-1)+f(n-2) 符合斐波那契数列的规律
 */
public class ClimbStairs_70 {
    public int climbStairs(int n) {
        return climbStairs4(n);
    }
    //经过测试此方法在求和25以上的斐波那契数值时有不精确的情况，
    // 因阶乘返回double数据只有10的15次方精度
    private int climbStairs1(int n){
        int result = 0;
        int figure =n/2;
        for(int i=0;i<=figure;i++){
            result+= MathPlus.combination(n-i,i);
        }
        return result;
    }
    //斐波拉契数列
    private int climbStairs2(int n){
        double sqrt5=Math.sqrt(5);
        double fibon=Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
        return (int)(fibon/sqrt5);
    }
    //递归与迭代
    private int climbStairs3(int n){
        if(n==1 || n==2){
            return n;
        }
        return (climbStairs3(n-1)+climbStairs3(n-2));
    }
    private int climbStairs4(int n){
        int[] arr = new int[n+2];
        arr[1]=1;
        arr[2]=2;
        for(int i=3;i<=n;i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        return  arr[n];
    }

    @Test
    public void testClimbStairs(){
        Long currTime1 = System.currentTimeMillis();
        Boolean flag = test1() && test2() && test5() &&test10() &&test35();
        Long currTime2 = System.currentTimeMillis();
        System.out.println("耗时："+(currTime2-currTime1)+"毫秒，测试"+(flag?"通过":"不通过"));
    }
    private Boolean test1(){
        Boolean flag = 1==climbStairs(1);
        System.out.println("测试1"+(flag?"通过":"不通过"));
        return flag;
    }
    private Boolean test2(){
        Boolean flag = 2== climbStairs(2);
        System.out.println("测试2"+(flag?"通过":"不通过"));
        return flag;
    }
    private Boolean test5(){
        Boolean flag = 8== climbStairs(5);
        System.out.println("测试5"+(flag?"通过":"不通过"));
        return flag;
    }
    private Boolean test10(){
        Boolean flag = 89== climbStairs(10);
        System.out.println("测试10"+(flag?"通过":"不通过"));
        return flag;
    }
    private Boolean test35(){
        Boolean flag = 14930352== climbStairs(35);
        System.out.println("测试35"+(flag?"通过 ":"不通过 ")+climbStairs(35));
        return flag;
    }
}
