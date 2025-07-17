package patterns.structutral.adapter.other;

import lombok.AllArgsConstructor;
import patterns.structutral.adapter.other.third_party.DataAnalyzer;

@AllArgsConstructor
public class Configurer {
    private XMLDataAnalyzer xmlDataAnalyzer;
    private final DataAnalyzer dataAnalyzer;

    public void config() {
        xmlDataAnalyzer = new DataAnalyzerAdapter(dataAnalyzer);
    }
}
