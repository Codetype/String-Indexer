package pl.pgedlek;

import java.nio.CharBuffer;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class ParallelStringIndexer extends AbstractStringIndexer {
    ParallelStringIndexer(String input) {
        super(input);
    }

    private String buildResult(Map<Character, List<String>> letterOccurenceMap) {
        StringBuilder stringResult = new StringBuilder();
        for (Map.Entry<Character, List<String>> entry : letterOccurenceMap.entrySet()) {
            stringResult.append(entry.getKey());
            stringResult.append(": ");
            stringResult.append(entry.getValue().toString().replaceAll(squareBracketsRegex, ""));
            stringResult.append("\n");
        }

        return stringResult.toString();
    }

    String transform() {
        Map<Character, List<String>> letterOccurrenceMap = new ConcurrentHashMap<>();

        if(input.equals("")) {
            return input;
        }

        input = input.toLowerCase();
        input = input.replaceAll(specialCharactersRegex, "");

        String[] words = input.split(" ");
        Arrays.stream(words).parallel().forEach(word ->
                CharBuffer.wrap(word).chars().parallel().forEach(letter ->
                        {
                            List<String> letterWordsList = letterOccurrenceMap.get((char)letter);

                            if(letterWordsList == null){
                                letterWordsList = Collections.synchronizedList(new ArrayList<>());
                            }

                            if(!letterWordsList.contains(word)){
                                letterWordsList.add(word);
                                Collections.sort(letterWordsList);
                            }

                            letterOccurrenceMap.put((char)letter, letterWordsList);
                        }
                )
        );

        TreeMap<Character, List<String>> sortedLetterOccurenceMap = new TreeMap<>(letterOccurrenceMap);

        return buildResult(sortedLetterOccurenceMap);
    }
}
