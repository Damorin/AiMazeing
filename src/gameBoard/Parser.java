package gameBoard;

import java.io.IOException;
import java.util.List;

/**
 * Created by Damien on 17/10/2015.
 */
public interface Parser {

    List<String> loadAndParse(String pathToFile) throws IOException;
}
