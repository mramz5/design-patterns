package patterns.structutral.adapter.other.third_party;

import java.util.List;

public interface DataAnalyzer {
    List<JSONType> getData();
    void setMean();
    void setMax();
    void setMin();
    void refining();
}
