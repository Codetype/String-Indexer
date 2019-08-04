package pl.pgedlek;

import java.nio.CharBuffer;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

class StringIndexer {
    private String input;
    private static final String squareBracketsRegex = "[\\[\\]]";
    private static final String specialCharactersRegex = "[^a-zA-Z0-9\\s+]";

    StringIndexer(String input){
        this.input = input;
    }

    void setInput(String input) {
        this.input = input;
    }

    private String buildResult(Map<Character, TreeSet<String>> letterOccurenceMap) {
        StringBuilder stringResult = new StringBuilder();
        for (Map.Entry<Character, TreeSet<String>> entry : letterOccurenceMap.entrySet()) {
            stringResult.append(entry.getKey());
            stringResult.append(": ");
            stringResult.append(entry.getValue().toString().replaceAll(squareBracketsRegex, ""));
            stringResult.append("\n");
        }

        return stringResult.toString();
    }

    String transform() {
        Map<Character, TreeSet<String>> letterOccurrenceMap = new TreeMap<>();

        if(input.equals("")) {
            return input;
        }

        input = input.toLowerCase();
        input = input.replaceAll(specialCharactersRegex, "");

        String[] words = input.split(" ");
        Arrays.stream(words).forEach(word ->
                CharBuffer.wrap(word).chars().forEach(letter ->
                        {
                            TreeSet<String> letterWordsSet = letterOccurrenceMap.get((char)letter);

                            if(letterWordsSet == null){
                                letterWordsSet = new TreeSet<>();
                            }

                            letterWordsSet.add(word);

                            letterOccurrenceMap.put((char)letter, letterWordsSet);
                        }
                )
        );

        return buildResult(letterOccurrenceMap);
    }
}
