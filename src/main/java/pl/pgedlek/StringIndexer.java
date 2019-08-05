package pl.pgedlek;

import java.nio.CharBuffer;
import java.util.*;

class StringIndexer extends AbstractStringIndexer{
    StringIndexer(String input) {
        super(input);
    }

    @SuppressWarnings("Duplicates")
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
