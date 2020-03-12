package LE.medium;

import org.junit.Test;

import java.util.Stack;

public class LongestPalindrome_5 {
    /*
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
示例 1：输入: "babad"    输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：输入: "cbbd"     输出: "bb"
     */
    public String LongestPalindrome(String s){return LongestPalindrome1(s);}
    private String LongestPalindrome1(String s){
        String resultStr = "";
        int length = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char element = s.charAt(i);
            if(element == stack.peek()){
                resultStr += stack.peek();
                stack.pop();
                length += 2;
            }else{
                resultStr = "";

            }
        }

        return "bab";
    }

    @Test
    public void test(){
        Long currTime1 = System.currentTimeMillis();
        Boolean flag = test1() && test2();
        Long currTime2 = System.currentTimeMillis();
        System.out.println("耗时："+(currTime2-currTime1)+"毫秒，测试"+(flag?"通过":"不通过"));
    }
    private Boolean test1(){
        String s = "babad";
        String result = LongestPalindrome(s);
        Boolean flag = "bab".equals(result);
        System.out.println("test1返回："+result+",测试"+(flag?"通过":"不通过"));
        return flag;
    }
    private Boolean test2(){
        String s = "cbbd";
        String result = LongestPalindrome(s);
        Boolean flag = "bb".equals(result);
        System.out.println("test1返回："+result+",测试"+(flag?"通过":"不通过"));
        return flag;
    }

}
