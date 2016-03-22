package gameBoard;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Damien on 17/10/2015.
 */
public class MazeParserImpl implements Parser {

    private List<String> fileContents;
    private Path path;

    @Override
    public List<String> loadAndParse(String pathToFile) throws IOException {
        path = Paths.get(pathToFile);
        this.parseFile();
        return fileContents;
    }

    private void parseFile() throws IOException {
        fileContents = Files.readAllLines(path);
    }
}
