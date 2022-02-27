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
        String check = "^1[3|4|5|7|8]\\d{9}$";
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
    public static String tleAndEmailAndPwdRegex(long tleNum,String email,String pwd){
        if(!tleNumRegex(tleNum)){
            return "tleNum";
        }
        else if(!emailRegex(email)){
            return "email";
        }
        else if(!pwdRegex(pwd)){
            return "pwd";
        }
        else {
            return "true";
        }
    }
}
