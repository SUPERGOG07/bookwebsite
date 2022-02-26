import dao.UserMapper;
import org.junit.Test;
import pojo.User;
import service.UserService;
import service.UserServiceImpl;
import util.RegexUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyTest {
    @Test
    public void test01(){
        String email="1436216510@qq.com";
        String email2="adw5a1@qq.com";
        String email3="111@aa.aa";
        boolean a=RegexUtil.emailRegex(email);
        boolean b=RegexUtil.emailRegex(email2);
        boolean c=RegexUtil.emailRegex(email3);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    @Test
    public void test02(){
        boolean result=(true^true);
        System.out.println(result);
    }
}
