package gameBoard;

import com.sun.xml.internal.bind.v2.TODO;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Damien on 17/10/2015.
 */
public class GameBoardImpl implements Board {

    private static final String BASIC_MAZE = "BasicMaze.txt";
    private Parser parser;
    private Logger logger;

    private List<List<BoardSquare>> maze;

    public GameBoardImpl() {
        logger = Logger.getLogger("AiMazeing");
        parser = new MazeParserImpl();

        initialiseBoard();
    }

    private void initialiseBoard() {

        // TODO: Ask user for which maze to load

        try {
            List<String> parsedLines = parser.loadAndParse(BASIC_MAZE);
            for (String line : parsedLines) {
                String[] delimitedLine = line.split(",");
            }
        } catch (IOException e) {
            logger.log(Level.WARNING, "File could not be loaded. File: " + BASIC_MAZE);
        }
    }
}
