
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdentifyNumbers {

    public String extractAll(String text) {
        //text= "eighthree";
        String pattern = "one|two|three|four|five|six|seven|eight|nine|[0-9]";
        Matcher mt = Pattern.compile(pattern).matcher(text);
        String results = "";
        int offset = 0;

        while (mt.find(offset))
        {
            String number = mt.group();
            offset = mt.end();
            if (!number.matches("[0-9]+")) {
                results += convertWordToNumbers(number);
                offset = mt.end() -1;
                continue;
            }
            results += number;
        }


        return results.substring(0, 1) + results.substring(results.length() - 1);



    }


    private static String convertWordToNumbers(String word)
    {
        HashMap<String, String> map = new HashMap<>();

        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");

        return map.get(word);

    }
}
