package principles.delegation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {
    private static XMLParser parser;

    public XMLParser getInstance() {
        if (parser == null)
            parser = new XMLParser();
        return parser;
    }

    public List<Object> parse(File file) {
        List<Object> list = new ArrayList<>();
        System.out.println("Parsing the xml file");
        return list;
    }
}
