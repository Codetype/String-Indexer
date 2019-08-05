package pl.pgedlek;

import java.nio.CharBuffer;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class ParallelStringIndexer extends AbstractStringIndexer {
    ParallelStringIndexer(String input) {
        super(input);
    }

    @SuppressWarnings("Duplicates")
    String transform() {
        Map<Character, TreeSet<String>> concurrentLetterOccurrenceMap = new ConcurrentHashMap<>();

        if(input.equals("")) {
            return input;
        }

        input = input.toLowerCase();
        input = input.replaceAll(specialCharactersRegex, "");

        String[] words = input.split(" ");
        Arrays.stream(words).parallel().forEach(word ->
                CharBuffer.wrap(word).chars()
                        .forEach(letter ->
                        {
                            TreeSet<String> letterWordsTreeSet = concurrentLetterOccurrenceMap.get((char)letter);

                            if(letterWordsTreeSet == null){
                                letterWordsTreeSet = new TreeSet<>();
                            }

                            letterWordsTreeSet.add(word);

                            concurrentLetterOccurrenceMap.put((char)letter, letterWordsTreeSet);
                        }
                )
        );

        TreeMap<Character, TreeSet<String>> sortedLetterOccurrenceMap = new TreeMap<>(concurrentLetterOccurrenceMap);

        return buildResult(sortedLetterOccurrenceMap);
    }
}
