package pl.pgedlek;

public class Main {
    public static void main(String[] args) {
        String input = "ala ma kota, kot koduje w Javie kota";
        StringIndexer stringIndexer = new StringIndexer(input);

        System.out.println(stringIndexer.transform());
    }
}
