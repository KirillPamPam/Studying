package mai;

import java.io.IOException;

/**
 * Created by Kirill Zhitelev on 03.04.2016.
 */
public class MainSentence {

    public static void main(String[] args) throws IOException {
        Sentence sentence = new Sentence();
        System.out.println(sentence.searchWords(4));
    }
}
