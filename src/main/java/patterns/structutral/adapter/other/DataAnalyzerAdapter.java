package patterns.structutral.adapter.other;

import lombok.Setter;
import patterns.structutral.adapter.other.third_party.DataAnalyzer;
import patterns.structutral.adapter.other.third_party.JSONType;

import java.util.List;

@Setter
public class DataAnalyzerAdapter extends SimpleXMLDataAnalyzer {
    private final DataAnalyzer dataAnalyzer;
    private List<JSONType> jsonTypeList;

    public DataAnalyzerAdapter(DataAnalyzer dataAnalyzer) {
        this.dataAnalyzer = dataAnalyzer;
        //doing some processing on it
        jsonTypeList = dataAnalyzer.getData().stream()
                .map(xml -> new JSONType(xml.getJsonId(), xml.getJsonName(), xml.getJsonValue()))
                .toList();
    }

    @Override
    public List<XMLType> getData() {
        return jsonTypeList.stream()
                .map(jsonType -> new XMLType(jsonType.getJsonId(), jsonType.getJsonName(), jsonType.getJsonValue()))
                .toList();
    }

    @Override
    public void setMean() {
        dataAnalyzer.setMean();
    }

    @Override
    public void setMax() {
        dataAnalyzer.setMax();
    }

    @Override
    public void setMin() {
        dataAnalyzer.setMin();
    }

    @Override
    public void refining() {
        dataAnalyzer.refining();
    }
}
