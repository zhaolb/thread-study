package study.forkjoin;

import java.util.Random;

/**
 * Created by zhaolb on 2018/1/19.
 */
public class Document {
    private String words[] = {"the", "hello", "goodbye", "packt", "java", "thread", "pool", "random", "class", "main"};

    public String[][] generateDocument(int numLines, int numWords, String word) {
        int counter = 0;
        String document[][] = new String[numLines][numWords];
        Random random = new Random();

        for (int i = 0; i < numLines; i++) {
            for (int j = 0; j < numWords; j++) {
                int index = random.nextInt(words.length);
                document[i][j] = words[index];
                if (document[i][j].equals(word)) {
                    counter++;
                }
            }
        }
        System.out.println("Document: the word appears " + counter +" times in the document");
        return document;
    }
}
