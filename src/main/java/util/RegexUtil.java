package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {

    public static boolean emailRegex(String email){
        String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(email);
        return  matcher.matches();
    }
    public static boolean tleNumRegex(long tleNum){
        String check = "^(13[4,5,6,7,8,9]|15[0,8,9,1,7]|188|187)\\d{8}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(tleNum+"");
        return matcher.matches();
    }
    public static boolean pwdRegex(String pwd){
        String check1=".{9,15}";
        String check2="^.*[A-Z].*[A-Z].*[A-Z].*$";
        Pattern regex1 = Pattern.compile(check1);
        Pattern regex2 = Pattern.compile(check2);
        Matcher matcher1 = regex1.matcher(pwd);
        Matcher matcher2 = regex2.matcher(pwd);
        return matcher1.matches()&&matcher2.matches();

    }
    public static boolean tleAndEmailAndPwdRegex(long tleNum,String email,String pwd){
        return (tleNumRegex(tleNum)&&emailRegex(email)&&pwdRegex(pwd));
    }
}
