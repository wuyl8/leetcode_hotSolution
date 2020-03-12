package multiThread.ThreadUseJoin;

import java.util.regex.Pattern;

public class testRegularExpress {
    public static void main(String[] args){
        //String regularExpression = "//^SELECT|^select.*$nextval|$nextval()//";
        String regularExpression = "^(SELECT|select).*(NEXTVAL|NEXTVAL\\(\\)|nextval|nextval\\(\\))$";
        String sql = "select seq_offer_attr.NEXTVALs";
        boolean seqFlag = Pattern.compile(regularExpression).matcher(sql).matches();
        System.out.print(seqFlag);
    }
}
