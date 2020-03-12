package LE.utils;

import org.junit.Test;

public class MathPlus {

    //高斯公式求阶加 termial：n? = n(n+1)/2
    public static long termial(int n){
        return n*(n+1)/2;
    }

    //经过测试，阶乘数值过大可能出现结果不精确的问题double精度为10的15次方
    public static double factorial(int n){
        return (n>1)?n*factorial(n-1):1;
    }
    //m>n>0 m!/n!
    public static double factorial(int m,int n){
        double result = 1;
        for(int i=m;i>n;i--){
            result *= i;
        }
        return result;
    }

//组合：C(n,m)=C(n,n-m）= n!/m!*(n-m)!。（n≥m)
    public static long combination(int n,int m){
        if(n<m){
            throw new IllegalArgumentException("n<m");
        }
        return (long)(factorial(n,m)/factorial(n-m));
    }


    //斐波那契数列 F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)（n>=3，n∈N*）
    public static int fibonacci(int n){
        double sqrt5=Math.sqrt(5);
        double fibon=Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
        return (int)(fibon/sqrt5);
    }

    @Test
    public void test(){
        System.out.println(factorial(35));
        System.out.println(factorial(34));
        System.out.println(factorial(35,1));
        System.out.println(factorial(35,17)/factorial(18));
        System.out.println(combination(35,2));
    }
}
