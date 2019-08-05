package pl.pgedlek;

import java.nio.CharBuffer;
import java.util.*;

class StringIndexer extends AbstractStringIndexer{
    StringIndexer(String input) {
        super(input);
    }

    private String buildResult(Map<Character, TreeSet<String>> letterOccurrenceMap) {
        StringBuilder stringResult = new StringBuilder();
        for (Map.Entry<Character, TreeSet<String>> entry : letterOccurrenceMap.entrySet()) {
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
                            TreeSet<String> letterWordsList = letterOccurrenceMap.get((char)letter);

                            if(letterWordsList == null){
                                letterWordsList = new TreeSet<>();
                            }

                            letterWordsList.add(word);

                            letterOccurrenceMap.put((char)letter, letterWordsList);
                        }
                )
        );

        return buildResult(letterOccurrenceMap);
    }
}
