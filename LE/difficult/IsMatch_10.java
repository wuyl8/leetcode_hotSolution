package LE.difficult;

import org.junit.Test;

public class IsMatch_10 {
/*
模拟正则表达式的状态机 .任意字符 *任意数量
 */
    public boolean isMatch(String s, String p) {
        return isMatch1(s,p);
    }

    private boolean isMatch1(String s, String p){
        //TODO
        boolean flag = true;
        if(p.contains(".")){

        }else if(p.contains("*")){
            flag = s.equals(p);
        }

        return flag;
    }

    @Test
    public void test(){
        Long currTime1 = System.currentTimeMillis();
        boolean flag = test1() && test2();
        Long currTime2 = System.currentTimeMillis();
        System.out.println("耗时："+(currTime2-currTime1)+"毫秒，测试"+(flag?"通过":"不通过"));
    }
    private Boolean test1(){
        String s = "aa"; String p = "a*";
        Boolean flag = isMatch(s,p);
        System.out.println("test1返回："+flag+",测试"+(flag?"通过":"不通过"));
        return flag;
    }
    private Boolean test2(){
        String s = "ab"; String p = ".*";
        Boolean flag = isMatch(s,p);
        System.out.println("test1返回："+flag+",测试"+(flag?"通过":"不通过"));
        return flag;
    }
}
