package pl.pgedlek;

import java.util.*;

class StringIndexer {
    private String input;
    private static final String squareBracketsRegex = "[\\[\\]]";
    private static final String specialCharactersRegex = "[^a-zA-Z0-9\\s+]";
    private static final String inputCharacters = "abcdefghijklmnopqrstuvwxyz";

    StringIndexer(String input){
        this.input = input;
    }

    void setInput(String input) {
        this.input = input;
    }

    private String buildResult(Map<Character, ArrayList<String>> letterOccurenceMap) {
        StringBuilder stringResult = new StringBuilder();
        for (Map.Entry<Character, ArrayList<String>> entry : letterOccurenceMap.entrySet()) {
            stringResult.append(entry.getKey());
            stringResult.append(": ");
            stringResult.append(entry.getValue().toString().replaceAll(squareBracketsRegex, ""));
            stringResult.append("\n");
        }

        return stringResult.toString();
    }

    String transform() {
        Map<Character, ArrayList<String>> letterOccurrenceMap = new TreeMap<Character, ArrayList<String>>();

        if(input.equals("")) {
            return input;
        }

        input = input.toLowerCase();
        input = input.replaceAll(specialCharactersRegex, "");

        String[] words = input.split(" ");

        for(String word : words) {
            for(Character letter : word.toCharArray()){
                ArrayList<String> letterWordsList = letterOccurrenceMap.get(letter);

                if(letterWordsList == null){
                    letterWordsList = new ArrayList<String>();
                }

                if(!letterWordsList.contains(word)){
                    letterWordsList.add(word);
                    Collections.sort(letterWordsList);
                }

                letterOccurrenceMap.put(letter, letterWordsList);
            }
        }

        return buildResult(letterOccurrenceMap);
    }
}
