package patterns.structutral.adapter.other;

import lombok.AllArgsConstructor;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class SimpleXMLDataAnalyzer implements XMLDataAnalyzer {
    private final List<XMLType> data = new ArrayList<>();

    @Override
    public List<XMLType> getData() {
        return data;
    }

    @Override
    public void setMean() {
        XMLType mean = new XMLType(0, "min", data.stream().map(XMLType::getValue).min(Double::compare).get());
        System.out.println("mean set");
    }

    @Override
    public void setMax() {
        XMLType max = new XMLType(0, "max", data.stream().map(XMLType::getValue).max(Double::compare).get());
        System.out.println("max set");
    }

    @Override
    public void setMin() {
        XMLType min = new XMLType(-2, "mean", data.stream()
                .map(XMLType::getValue)
                .reduce(0.0, Double::sum) / data.size());
        System.out.println("min set");
    }

    @Override
    public void refining() {
        SecureRandom random = new SecureRandom();
        StringBuffer buffer = new StringBuffer();
        while (buffer.length() != 5)
            buffer.append((char) random.nextInt(100));
        data.stream().peek(d -> d.setName(buffer.toString()));
        System.out.println("refined!");
    }
}
