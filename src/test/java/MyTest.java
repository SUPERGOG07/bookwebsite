import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyTest {
    @Test
    public void email(){
        String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher("dffdfdf@a.com");
        boolean isMatched = matcher.matches();
        System.out.println(isMatched);
    }
}
