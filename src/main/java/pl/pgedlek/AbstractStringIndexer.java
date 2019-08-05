package pl.pgedlek;

abstract class AbstractStringIndexer {
    String input;
    static final String squareBracketsRegex = "[\\[\\]]";
    static final String specialCharactersRegex = "[^a-zA-Z0-9\\s+]";

    AbstractStringIndexer(String input){
        this.input = input;
    }

    void setInput(String input) {
        this.input = input;
    }


    String transform() { return ""; }
}
