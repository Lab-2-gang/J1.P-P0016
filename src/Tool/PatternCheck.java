package Tool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternCheck
{
    public static Boolean Check(String format, String inputToCheck)
    {
        Pattern pattern = Pattern.compile(format);
        Matcher matcher = pattern.matcher(inputToCheck);

        return matcher.find() == true;
    }
}
