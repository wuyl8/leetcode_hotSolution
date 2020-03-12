package LE.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。
 */
public class IsValid_20 {
    public Boolean isValid(String s) {
        return isValid3(s);
    }
    //递归替换
    public Boolean isValid1(String s){
        String ns = s.replaceAll("\\s|(\\(\\))|(\\[\\])|(\\{\\})","");
        if(s.length()==0){
            return true;
        }else if(ns.length()==s.length()){
            return false;
        }else{
            return isValid1(ns);
        }
    }
//利用java中的stack 栈的特性
    public Boolean isValid2(String s){
        Stack<Character> stack = new Stack<Character>();
        if(s.length()%2==1){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (this.mappings.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
    private HashMap<Character, Character> mappings;
    public IsValid_20() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }
//在数组较短时速度更快，减少初始化开销
    public  Boolean isValid3(String s){
        char[] chars = new char[s.length()];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '}' && s.charAt(i) != ']' && s.charAt(i) != ')') {
                chars[index++] = s.charAt(i);
            } else if (index == 0) {
                return false;
            } else if (s.charAt(i) == '}' && chars[index - 1] == '{') {
                index--;
            } else if (s.charAt(i) == ']' && chars[index - 1] == '[') {
                index--;
            } else if (s.charAt(i) == ')' && chars[index - 1] == '(') {
                index--;
            } else {
                return false;
            }
        }
        return index == 0;
    }


    @Test
    public void testIsValid(){
//        testIsValid1();
        Boolean flag = testIsValid1() && testIsValid2() && testIsValid3() && testIsValid4();
        String message = flag?"通过":"不通过";
        System.out.println("测试"+message);
    }
    public Boolean testIsValid1(){
        //Boolean flag = isValid("()[]{}");
        Boolean flag = isValid("([]){}([]){}");
        String message = flag?"通过":"不通过";
        System.out.println("测试1"+message);
        return flag;
    }
    public Boolean testIsValid2(){
        Boolean flag = isValid("(]");
        String message = !flag?"通过":"不通过";
        System.out.println("测试2"+message);
        return !flag;
    }
    public Boolean testIsValid3(){
        Boolean flag = isValid("([)]");
        String message = !flag?"通过":"不通过";
        System.out.println("测试3"+message);
        return !flag;
    }
    public Boolean testIsValid4(){
        Boolean flag = isValid("{[]}");
        String message = flag?"通过":"不通过";
        System.out.println("测试4"+message);
        return flag;
    }
}
