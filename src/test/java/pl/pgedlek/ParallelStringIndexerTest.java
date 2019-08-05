package pl.pgedlek;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class ParallelStringIndexerTest {
    private ParallelStringIndexer parallelStringIndexer = null;

    @Before
    public void beforeEachTest(){
        parallelStringIndexer = Mockito.mock(ParallelStringIndexer.class);
        parallelStringIndexer  = new ParallelStringIndexer(Constants.TestData.EMPTY_INPUT);
    }

    @Test
    public void testEmptyInput() {
        // given an empty string
        parallelStringIndexer.setInput(Constants.TestData.EMPTY_INPUT);

        // when string indexer maps empty input
        String result = parallelStringIndexer.transform();

        // then result should be empty as expected
        assertEquals(Constants.TestData.EMPTY_OUTPUT, result);
    }

    @Test
    public void testBasicInput() {
        // given a basic string example
        parallelStringIndexer.setInput(Constants.TestData.BASIC_INPUT);

        // when string indexer maps basic example input
        String result = parallelStringIndexer.transform();

        // then result should be basic string mapped by letter occurrence
        assertEquals(Constants.TestData.BASIC_OUTPUT, result);
    }

    @Test
    public void testDifferentCasesInput() {
        // given input with different letter case
        parallelStringIndexer.setInput(Constants.TestData.DIFFERENT_LETTER_CASE_INPUT);

        // when string indexer maps input with different letter case
        String result = parallelStringIndexer.transform();

        // then result should be similar to input with only lowercase
        assertEquals(Constants.TestData.DIFFERENT_LETTER_CASE_OUTPUT, result);
    }

    @Test
    public void testInputWithRepeats() {
        // given input with words repeats
        parallelStringIndexer.setInput(Constants.TestData.INPUT_WITH_REPEATS);

        // when string indexer maps input with words repeats
        String result = parallelStringIndexer.transform();

        // then result should be similar to input with single occurrence of word
        assertEquals(Constants.TestData.OUTPUT_WITH_REPEATS, result);
    }

    @Test
    public void testInputWithSpecialCharacters() {
        // given input with many special characters
        parallelStringIndexer.setInput(Constants.TestData.INPUT_WITH_SPECIAL_CHARACTERS);

        // when string indexer maps input with many special characters
        String result = parallelStringIndexer.transform();

        // then result should omit all special characters
        assertEquals(Constants.TestData.OUTPUT_WITH_SPECIAL_CHARACTERS, result);
    }

    @Test
    public void testLongInput() {
        // given long input
        parallelStringIndexer.setInput(Constants.TestData.LONG_INPUT);

        // when string indexer maps long input
        String result = parallelStringIndexer.transform();

        // then result should be return in satisfied time
        assertEquals(Constants.TestData.LONG_OUTPUT, result);
    }
}
