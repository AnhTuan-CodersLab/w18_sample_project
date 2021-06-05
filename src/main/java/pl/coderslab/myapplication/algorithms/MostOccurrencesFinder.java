package pl.coderslab.myapplication.algorithms;

import org.springframework.stereotype.Component;

@Component
public class MostOccurrencesFinder {

    public int find(String word) {
        char[][] chars = new char[128][1];
        char[] trimmedWord = word.replaceAll("\\s+", "").toCharArray();

        for (char c : trimmedWord) {
            chars[c][0]++;
            chars[c][0]++;
        }

        int mostOccurrences = 0;
        for (char[] aChar : chars) {
            if (aChar[0] > mostOccurrences) {
                mostOccurrences = aChar[0];
            }
        }

        return mostOccurrences;
    }

}
