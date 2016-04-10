package mai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kirill Zhitelev on 03.04.2016.
 */
public class Sentence {
    private InputStream textStream = getClass().getClassLoader().getResourceAsStream("text.txt");
    private BufferedReader textReader = new BufferedReader(new InputStreamReader(textStream));

    private String getText()  {
        StringBuilder result = new StringBuilder();
        String value;
        try {
            while ((value = textReader.readLine()) != null) {
                result.append(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return String.valueOf(result);
    }

    private List<String> searchSentences() {
        Pattern pattern = Pattern.compile("([А-Я]|[A-Z])[^.!?]*\\?");
        Matcher matcher = pattern.matcher(getText());
        List<String> text = new ArrayList<>();
        while (matcher.find()) {
            text.add(matcher.group());
            System.out.println(matcher.group());
        }
        return text;
    }

    public Set<String> searchWords(int length) {
        Set<String> wordsList = new HashSet<>();
        for (String sentence: searchSentences()) {
            String[] words = sentence.split("[,\\s;:-]");
            for (String word: words) {
                if(word.length() == length) {
                    wordsList.add(word);
                }
            }
        }

        return wordsList;
    }
}
