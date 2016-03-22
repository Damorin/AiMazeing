package tests.Parser;

import gameBoard.MazeParserImpl;
import gameBoard.Parser;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Damien on 17/10/2015.
 */
public class MazeParserImplTest {

    private static final String INCORRECT_PATH = "NotAFile.Fake";
    private static final String CORRECT_PATH = "BasicMaze.txt";
    private static final String FIRST_LINE = "S,S,S,W,G";
    private static final String SECOND_LINE = "S,W,S,W,S";
    private static final String THIRD_LINE = "S,W,S,T,S";
    private static final String FOURTH_LINE = "S,W,S,S,S";
    private static final String FIFTH_LINE = "P,W,T,W,W";
    private Parser parser;
    private List<String> correctContents;

    @Before
    public void setUp() {
        parser = Mockito.mock(Parser.class);
        createContents();

        try {
            Mockito.when(parser.loadAndParse(CORRECT_PATH)).thenReturn(correctContents);
        } catch (IOException e) {
            System.out.println("Woops");
        }
    }

    private void createContents() {
        correctContents = new ArrayList<>();
        correctContents.add(FIRST_LINE);
        correctContents.add(SECOND_LINE);
        correctContents.add(THIRD_LINE);
        correctContents.add(FOURTH_LINE);
        correctContents.add(FIFTH_LINE);
    }

    @Test
    public void testMazeParserCreation() {
        assertNotNull(parser);
    }

    @Test(expected = IOException.class)
    public void testLoadAndParseIncorrectFile() throws IOException {
        parser.loadAndParse(INCORRECT_PATH);
    }

    @Test
    public void testLoadAndParseCorrectFile() throws IOException {
        List<String> fileContents = parser.loadAndParse(CORRECT_PATH);
        assertEquals(correctContents, fileContents);
    }

}