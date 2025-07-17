package patterns.structutral.adapter.other;

import patterns.structutral.adapter.other.third_party.DataAnalyzer;
import patterns.structutral.adapter.other.third_party.SimpleDataAnalyzer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final DataAnalyzer dataAnalyzer=new SimpleDataAnalyzer();
        final XMLDataAnalyzer xmlDataAnalyzer=new DataAnalyzerAdapter(dataAnalyzer);

        List<XMLType> xmlTypesData = xmlDataAnalyzer.getData();
        System.out.println("xml data : "+xmlTypesData);
        xmlDataAnalyzer.setMin();
        xmlDataAnalyzer.setMax();
        xmlDataAnalyzer.setMean();

    }
}
