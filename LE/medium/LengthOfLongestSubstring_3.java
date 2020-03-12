package LE.medium;

import org.junit.Test;

import java.util.HashSet;

/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
示例 1:输入: "abcabcbb"
输出: 3   解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:输入: "bbbbb"
输出: 1   解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:输入: "pwwkew"
输出: 3   解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring_3 {
    public int lengthOfLongestSubstring(String s) {
        return lengthOfLongestSubstring2(s);
    }
    //leetcode标准答案 性能最优
    private int lengthOfLongestSubstring1(String s){
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
    //暴力双循环 复杂度：n^2
    private int lengthOfLongestSubstring2(String s){
        if(s.length()==1){
            return 1;
        }
        int maxCount = 0;
        HashSet hashSet = new HashSet();
        for(int i=0;i<s.length();i++){
            maxCount = Math.max(maxCount,hashSet.size());
            hashSet.clear();
            char firstChar = s.charAt(i);
            hashSet.add(firstChar);
            for(int j=i+1;j<s.length();j++){
                char curChar = s.charAt(j);
                if(hashSet.contains(curChar)){
                    break;
                }
                hashSet.add(curChar);
            }
        }
        return maxCount;
    }
    //双指针 复杂度：n
    private int lengthOfLongestSubstring3(String s){
        if(s.length()==0){
            return 0;
        }
        int maxCount = 1;
        int start = 0;
        for(int end=1;end<s.length();end++){
            String subString = s.substring(start,end+1);
            char curChar = s.charAt(end);
            int curCharIndex = subString.indexOf(curChar);
            if(end-start != curCharIndex){
                maxCount = Math.max(maxCount,end-start);
                start = curCharIndex+start+1;
            }else{
                maxCount = Math.max(maxCount,subString.length());
            }
        }
        return maxCount;
    }

    @Test
    public void testLengthOfLongestSubstring(){
        Long currTime1 = System.currentTimeMillis();
        Boolean flag = test1() && test2()&&test3()&&test4()&&test5()&&test6()&&test7();
        Long currTime2 = System.currentTimeMillis();
        System.out.println("耗时："+(currTime2-currTime1)+"毫秒，测试"+(flag?"通过":"不通过"));
    }
    private Boolean test1(){
        String string = "abcabcbb";
        Boolean flag = 3==lengthOfLongestSubstring(string);
        System.out.println("测试1"+(flag?"通过":"不通过"));
        return flag;
    }
    private Boolean test2(){
        String string = "bbbbb";
        Boolean flag = 1==lengthOfLongestSubstring(string);
        System.out.println("测试2"+(flag?"通过":"不通过"));
        return flag;
    }
    private Boolean test3(){
        String string = "pwwkew";
        Boolean flag = 3==lengthOfLongestSubstring(string);
        System.out.println("测试3"+(flag?"通过":"不通过"));
        return flag;
    }
    private Boolean test4(){
        String string = "p";
        Boolean flag = 1==lengthOfLongestSubstring(string);
        System.out.println("测试4"+(flag?"通过":"不通过"));
        return flag;
    }
    private Boolean test5(){
        String string = "";
        Boolean flag = 0==lengthOfLongestSubstring(string);
        System.out.println("测试5"+(flag?"通过":"不通过"));
        return flag;
    }
    private Boolean test6(){
        String string = "au";
        Boolean flag = 2==lengthOfLongestSubstring(string);
        System.out.println("测试6"+(flag?"通过":"不通过"));
        return flag;
    }
    private Boolean test7(){
        String string = "dvdf";
        Boolean flag = 3==lengthOfLongestSubstring(string);
        System.out.println("测试7"+(flag?"通过":"不通过")+","+lengthOfLongestSubstring(string));
        return flag;
    }
}
