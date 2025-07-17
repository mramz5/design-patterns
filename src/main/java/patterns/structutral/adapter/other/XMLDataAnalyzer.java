package patterns.structutral.adapter.other;

import java.util.List;

public interface XMLDataAnalyzer {
    List<XMLType> getData();
    void setMean();
    void setMax();
    void setMin();
    void refining();
}
