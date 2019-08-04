package pl.pgedlek;

import static org.junit.Assert.assertEquals;
import static pl.pgedlek.Constants.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class StringIndexerTest {
    private StringIndexer stringIndexer = null;

    @Before
    public void beforeEachTest(){
        stringIndexer = Mockito.mock(StringIndexer.class);
        stringIndexer  = new StringIndexer(TestData.EMPTY_INPUT);
    }

    @Test
    public void testEmptyInput() {
        // given an empty string
        stringIndexer.setInput(TestData.EMPTY_INPUT);

        // when string indexer maps empty input
        String result = stringIndexer.transform();

        // then result should be empty as expected
        assertEquals(TestData.EMPTY_OUTPUT, result);
    }

    @Test
    public void testBasicInput() {
        // given a basic string example
        stringIndexer.setInput(TestData.BASIC_INPUT);

        // when string indexer maps basic example input
        String result = stringIndexer.transform();

        // then result should be basic string mapped by letter occurrence
        assertEquals(TestData.BASIC_OUTPUT, result);
    }

    @Test
    public void testDifferentCasesInput() {
        // given input with different letter case
        stringIndexer.setInput(TestData.DIFFERENT_LETTER_CASE_INPUT);

        // when string indexer maps input with different letter case
        String result = stringIndexer.transform();

        // then result should be similar to input with only lowercase
        assertEquals(TestData.DIFFERENT_LETTER_CASE_OUTPUT, result);
    }

    @Test
    public void testInputWithRepeats() {
        // given input with words repeats
        stringIndexer.setInput(TestData.INPUT_WITH_REPEATS);

        // when string indexer maps input with words repeats
        String result = stringIndexer.transform();

        // then result should be similar to input with single occurrence of word
        assertEquals(TestData.OUTPUT_WITH_REPEATS, result);
    }

    @Test
    public void testInputWithSpecialCharacters() {
        // given input with many special characters
        stringIndexer.setInput(TestData.INPUT_WITH_SPECIAL_CHARACTERS);

        // when string indexer maps input with many special characters
        String result = stringIndexer.transform();

        // then result should omit all special characters
        assertEquals(TestData.OUTPUT_WITH_SPECIAL_CHARACTERS, result);
    }

    @Test
    public void testLongInput() {
        // given long input
        stringIndexer.setInput(TestData.LONG_INPUT);

        // when string indexer maps long input
        String result = stringIndexer.transform();

        // then result should be return in satisfied time
        assertEquals(TestData.LONG_OUTPUT, result);
    }
}
