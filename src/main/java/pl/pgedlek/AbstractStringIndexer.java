package pl.pgedlek;

import java.util.Map;
import java.util.TreeSet;

abstract class AbstractStringIndexer {
    String input;
    private static final String squareBracketsRegex = "[\\[\\]]";
    static final String specialCharactersRegex = "[^a-zA-Z0-9\\s+]";

    AbstractStringIndexer(String input){
        this.input = input;
    }

    void setInput(String input) {
        this.input = input;
    }


    String transform() { return ""; }

    String buildResult(Map<Character, TreeSet<String>> letterOccurrenceMap) {
        StringBuilder stringResult = new StringBuilder();
        for (Map.Entry<Character, TreeSet<String>> entry : letterOccurrenceMap.entrySet()) {
            stringResult.append(entry.getKey());
            stringResult.append(": ");
            stringResult.append(entry.getValue().toString().replaceAll(squareBracketsRegex, ""));
            stringResult.append("\n");
        }

        return stringResult.toString();
    }
}
