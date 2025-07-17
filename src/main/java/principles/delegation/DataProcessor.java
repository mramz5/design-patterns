package principles.delegation;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

public class DataProcessor {
    //delegator
    private static XMLParser parser;
    private Path path;
    private File file;

    public DataProcessor(String path) {
        parser=new XMLParser();
        File file=Path.of(path).toFile();
    }

    public void process(){
        //delegating
        List<Object> list=parser.parse(file);
        toSomeFormat();
    }

    private void toSomeFormat(){
        System.out.println("Converting to some specific format");
    }
}
