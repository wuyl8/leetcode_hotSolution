package LE.easy;

import org.junit.Test;

public class MaxProfit_121 {
    /*给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
注意你不能在买入股票前卖出股票。

示例 1:输入: [7,1,5,3,6,4]  输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
示例 2:输入: [7,6,4,3,1]  输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     */

    //转换问题为求数组的最大连续子数组，然后使用动态规划
    public int maxProfit(int[] prices) {
        return maxProfit2(prices);
    }
    public int maxProfit1(int[] prices) {
        if(prices.length==0||prices.length==1){
            return 0;
        }
        int[] dValue = new int[prices.length-1];
        for(int i=0;i<prices.length-1;i++){
            dValue[i] = prices[i+1]-prices[i];
        }
        int sum = 0;
        int ans = dValue[0];
        for(int value:dValue){
            if(sum>0){
                sum+=value;
            }else{
                sum = value;
            }
            ans = Math.max(sum,ans);
        }
        return Math.max(0,ans);
    }
    public int maxProfit2(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int price : prices) {
            if (price < minprice)
                minprice = price;
            else if (price - minprice > maxprofit)
                maxprofit = price - minprice;
        }
        return maxprofit;
    }
    @Test
    public void testMaxProfit(){
        Long currTime1 = System.currentTimeMillis();
        Boolean flag = test1() && test2() && test3()&&test4()&&test5()&&test6();
        Long currTime2 = System.currentTimeMillis();
        System.out.println("耗时："+(currTime2-currTime1)+"毫秒，测试"+(flag?"通过":"不通过"));
    }
    private Boolean test1(){
        int[] prices = {7,1,5,3,6,4};
        Boolean flag = 5==maxProfit(prices);
        System.out.println("测试1"+(flag?"通过":"不通过"));
        return flag;
    }
    private Boolean test2(){
        int[] prices = {10,2,9,1,2,1,3,1};
        Boolean flag = 7==maxProfit(prices);
        System.out.println("测试2"+(flag?"通过":"不通过"));
        return flag;
    }
    private Boolean test3(){
        int[] prices = {1,6,4,9,2,11,1};
        Boolean flag = 10==maxProfit(prices);
        System.out.println("测试3"+(flag?"通过":"不通过"));
        return flag;
    }
    private Boolean test4(){
        int[] prices = {};
        Boolean flag = 0==maxProfit(prices);
        System.out.println("测试4"+(flag?"通过":"不通过"));
        return flag;
    }
    private Boolean test5(){
        int[] prices = {1};
        Boolean flag = 0==maxProfit(prices);
        System.out.println("测试5"+(flag?"通过":"不通过"));
        return flag;
    }
    private Boolean test6(){
        int[] prices = {1,2};
        Boolean flag = 1==maxProfit(prices);
        System.out.println("测试6"+(flag?"通过":"不通过"));
        return flag;
    }
}
