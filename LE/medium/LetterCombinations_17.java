package LE.medium;

import org.junit.Test;

import java.util.*;

public class LetterCombinations_17 {
    /*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
示例:输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     */
    public List<String> letterCombinations(String digits) {
        return letterCombinations1(digits);
    }
    private List<String> letterCombinations1(String digits) {
        List<String> returnList = new LinkedList<>();
        if(0 == digits.length()){
            return returnList;
        }
        Map<Character,String> map = new HashMap();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        this.backTrack(returnList,map,digits,0,new StringBuffer());

        return returnList;
    }
    //递归，回溯算法。BFS层级优先搜索。
    private void backTrack(List<String> returnList,Map<Character,String> map,String digits,int index,StringBuffer combine){
        if(digits.length() == index){
            returnList.add(combine.toString());
        }else{
            char c = digits.charAt(index);
            String letter = map.get(c);
            for(int i=0;i<letter.length();i++){
                combine.append(letter.charAt(i));
                this.backTrack(returnList,map,digits,index+1,combine);
                combine.deleteCharAt(index);
            }
        }
    }

    @Test
    public void test(){
        Long currTime1 = System.currentTimeMillis();
        boolean flag = test1()&& test2();
        Long currTime2 = System.currentTimeMillis();
        System.out.println("耗时："+(currTime2-currTime1)+"毫秒，测试"+(flag?"通过":"不通过"));
    }
    private boolean test1(){
        String digits = "23";
        List<String> list = letterCombinations(digits);
        List<String> trueList = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        Boolean flag = trueList.equals(list);
        System.out.println("test1返回："+list.toString()+",测试"+(flag?"通过":"不通过"));
        return flag;
    }
    private boolean test2(){
        String digits = "29";
        List<String> list = letterCombinations(digits);
        List<String> trueList = Arrays.asList("aw", "ax", "ay", "az", "bw", "bx", "by", "bz", "cw","cx","cy","cz");
        Boolean flag = trueList.equals(list);
        System.out.println("test2返回："+list.toString()+",测试"+(flag?"通过":"不通过"));
        return flag;
    }
}
