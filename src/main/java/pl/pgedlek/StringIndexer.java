package pl.pgedlek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

class StringIndexer {
    private String input;

    StringIndexer(String input){
        this.input = input;
    }

    void setInput(String input) {
        this.input = input;
    }

    private String buildResult(Map<Character, ArrayList<String>> letterOccurenceMap) {
        final String squareBracketsRegex = "[\\[\\]]";
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
        final String specialCharactersRegex = "[^a-zA-Z0-9\\s+]";
        final String inputCharacters = "abcdefghijklmnopqrstuvwxyz";
        Map<Character, ArrayList<String>> letterOccurenceMap = new LinkedHashMap<Character, ArrayList<String>>();

        if(input.equals("")) {
            return input;
        }

        input = input.toLowerCase();
        input = input.replaceAll(specialCharactersRegex, "");

        String[] words = input.split(" ");

        for(Character letter : inputCharacters.toCharArray()){
            for(String word : words) {
                if(word.contains(letter.toString())){
                    ArrayList<String> letterWordsList = letterOccurenceMap.get(letter);

                    if(letterWordsList == null){
                        letterWordsList = new ArrayList<String>();
                    }

                    if(!letterWordsList.contains(word)){
                        letterWordsList.add(word);
                        Collections.sort(letterWordsList);
                    }

                    letterOccurenceMap.put(letter, letterWordsList);
                }
            }
        }

        return buildResult(letterOccurenceMap);
    }
}
